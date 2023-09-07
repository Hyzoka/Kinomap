package com.hyzoka.kinomap

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hyzoka.kinomap.model.*
import com.hyzoka.kinomap.repo.VoitureRepository
import com.hyzoka.kinomap.utils.network.ScreenState
import com.hyzoka.kinomap.viewmodel.VoitureViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class VoitureViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val repository: VoitureRepository = mock()

    private lateinit var viewModel: VoitureViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = VoitureViewModel(repository)

    }

    @Test
    fun fetchVoitures_shouldReturnErrorIfRepositoryThrowsError() {
        // Given
        whenever(repository.getVoitures()).doAnswer { throw Exception() }

        // When
        viewModel.fetchVoitures()

        // Then
        val screenState = viewModel.screenState.value
        assertEquals(screenState, ScreenState.Error)
    }

    @Test
    fun fetchVoitures_shouldCallRepositoryGetVoitures() {
        // Given
        val listVoitures = listOf(
            Voiture(
                id = 0,
                name = "4x4",
                training = null,
                icon = Icons(
                    Anchor(33, 32),
                    size = Size(23, 32),
                    url = UrlImage("", "", "")
                )
            )
        )
        whenever(repository.getVoitures()).doReturn(flowOf(listVoitures))

        // When
        viewModel.fetchVoitures()

        // Then
        val screenState = viewModel.screenState.value
        assertEquals(screenState, ScreenState.Success)
        viewModel.listVoitures.value.forEach {
            assertEquals(it.name,"4x4")
            assertEquals(it.id,0)
        }
    }
}