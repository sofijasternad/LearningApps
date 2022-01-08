package ru.freeit.dictapp.core.network

import androidx.annotation.StringRes
import ru.freeit.dictapp.R

enum class GetError(@StringRes val resId: Int) {
    MISSING_INTERNET(R.string.missing_internet), OTHER(R.string.nothing_found);
}