package com.example.lianyuzhang.newyorktimedemo.activity.presenter

import com.example.lianyuzhang.newyorktimedemo.activity.presentation.NewsListPresentation
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NewsListPresenterTest {

    @Mock
    private lateinit var presentation: NewsListPresentation

    private lateinit var presenter: NewsListPresenter

    @Before
    fun setup() {
        presenter = NewsListPresenter(presentation)
    }

    @Test
    fun onCreate() {
        presenter.onCreate()
        verifyNoMoreInteractions()
    }

    @Test
    fun onStart() {
        //doNothing().`when`(presenter).query(null, null, null, null, null, 0)
        presenter.onStart()
        verify(presentation).showLoadingBar(true)
        verifyNoMoreInteractions()
    }

    @Test
    fun onResume() {
        presenter.onResume()
        verifyNoMoreInteractions()
    }

    @Test
    fun onPause() {
        presenter.onPause()
        verifyNoMoreInteractions()
    }

    @Test
    fun onStop() {
        presenter.onStop()
        verifyNoMoreInteractions()
    }

    @Test
    fun onDestroy() {
        presenter.onDestroy()
        verifyNoMoreInteractions()
    }

    @Test
    fun query() {
        doNothing().`when`(presentation).showLoadingBar(true)
        presenter.query("Clinton", null, null, null, null, 0)
        verify(presentation).showLoadingBar(true)
        verifyNoMoreInteractions()
    }

    private fun verifyNoMoreInteractions() {
        Mockito.verifyNoMoreInteractions(presentation)
    }
}