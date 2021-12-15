package com.ezzy.adanianpixabay.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.testcoroutinesrule.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

abstract class BaseViewModelTest {
    @get:Rule
    open val instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    open val coroutineTestRule = TestCoroutineRule()
}