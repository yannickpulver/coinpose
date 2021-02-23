package com.appswithlove.coinpose.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.plus
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    val ioScope: CoroutineScope get() = viewModelScope + Dispatchers.IO + exceptionHandler

    private val exceptionHandler = CoroutineExceptionHandler { _, t ->
        // unexpectedErrors.tryEmit(t)
        Timber.e(t)
    }
}