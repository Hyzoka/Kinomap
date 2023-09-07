package com.hyzoka.kinomap

import com.hyzoka.kinomap.datasources.VoitureDataSource
import com.hyzoka.kinomap.model.*
import com.hyzoka.kinomap.repo.VoitureRepository
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

class VoitureRepositoryTest {

    private val mockDataSource = mock<VoitureDataSource>()
    private val repository = VoitureRepository(mockDataSource)

    @Test
    fun `getVoitures() returns list of voitures`() = runBlocking {
        val testVoitures = listOf(
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
        whenever(mockDataSource.getVoitures()).doReturn(flowOf(testVoitures))

        val result = repository.getVoitures()

        result.collect{
            assertEquals(testVoitures, it)
        }
    }

}