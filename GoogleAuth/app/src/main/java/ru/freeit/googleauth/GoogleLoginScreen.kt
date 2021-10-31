package ru.freeit.googleauth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import ru.freeit.googleauth.databinding.GoogleLoginScreenBinding

class GoogleLoginScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = GoogleLoginScreenBinding.inflate(layoutInflater)

        val account = GoogleUserData(requireContext())
        val isLogIn = account.isLogin()
        binding.logoutButton.isEnabled = isLogIn
        binding.loginButton.isEnabled = !isLogIn

        if (isLogIn) {
            binding.statusText.text = getString(R.string.user_data, account.displayName(), account.email())
        }

        val googleSignClient = GoogleSignClient(requireActivity())

        val googleSignInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(activityResult.data)
            try {
                val account = task.getResult(ApiException::class.java)

                binding.statusText.text = getString(R.string.user_data, account.displayName, account.email)

                binding.logoutButton.isEnabled = true
                binding.loginButton.isEnabled = false

            } catch (e: ApiException) {
                binding.statusText.text = getString(R.string.auth_error, e.message)
            }
        }

        binding.loginButton.setOnClickListener {
            googleSignInLauncher.launch(googleSignClient.signInIntent())
        }

        binding.logoutButton.setOnClickListener {
            binding.loginButton.isEnabled = true
            binding.logoutButton.isEnabled = false
            binding.statusText.text = getString(R.string.you_arent_in_account)
        }

        return binding.root
    }

}