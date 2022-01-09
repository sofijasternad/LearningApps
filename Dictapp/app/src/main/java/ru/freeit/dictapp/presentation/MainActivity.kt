package ru.freeit.dictapp.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.*
import ru.freeit.dictapp.core.Debounce
import ru.freeit.dictapp.core.onTextChange
import ru.freeit.dictapp.data.repo.DictRepositoryImpl
import ru.freeit.dictapp.databinding.ActivityMainBinding
import ru.freeit.dictapp.presentation.ui.DictResultUi
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        val viewModel = ViewModelProvider(this, DictViewModelFactory(DictRepositoryImpl(executor, handler)))
            .get(DictViewModel::class.java)

        viewModel.observe(this) { dictResult ->

            val isError = dictResult is DictResultUi.Error
            val isSuccess = dictResult is DictResultUi.Success
            val isLoading = dictResult is DictResultUi.Loading

            binding.frameLayout.isVisible = isLoading or isError
            binding.progress.isVisible = isLoading
            binding.errorText.isVisible = isError
            binding.definitionsLayout.isVisible = isSuccess
            binding.wordText.isVisible = isSuccess

            if (dictResult is DictResultUi.Error) {
                dictResult.text(binding.errorText)
            }

            if (dictResult is DictResultUi.Success) {
                dictResult.word(binding.wordText)
                dictResult.definitions(binding.definitionsLayout)
            }

        }

        val debounce = Debounce(Handler(Looper.getMainLooper()))
        val runnable = Runnable { viewModel.found(binding.searchEdit.text.toString()) }
        binding.searchEdit.onTextChange { debounce.run(runnable) }
        binding.searchBox.setEndIconOnClickListener { runnable.run() }
    }

}