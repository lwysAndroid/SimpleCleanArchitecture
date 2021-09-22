package com.example.luistovar.archapp.testutils

import com.example.luistovar.archapp.presentation.commons.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher

class CoroutineDispatcherProviderTest: CoroutineDispatcherProvider {
    override val main: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val unconfined: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val io: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
    override val default: CoroutineDispatcher
        get() = TestCoroutineDispatcher()
}