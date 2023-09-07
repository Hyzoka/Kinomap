package com.hyzoka.kinomap

import com.hyzoka.kinomap.datasources.VehicleList
import com.hyzoka.kinomap.datasources.VoitureDataSource
import com.hyzoka.kinomap.datasources.VoitureResponse
import com.hyzoka.kinomap.datasources.VoitureService
import com.hyzoka.kinomap.model.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response
import kotlin.test.assertEquals

class VoitureDataSourceTest {

    @Mock
    private lateinit var mockService: VoitureService

    private lateinit var dataSource: VoitureDataSource

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        dataSource = VoitureDataSource(mockService)
    }

    @Test
    fun `test fetching voitures`() = runBlocking {
        val expectedResponse = VoitureResponse(
            VehicleList(
                status = "OK", response = listOf(
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
            )
        )

        whenever(mockService.getVoitures()).doReturn(Response.success(expectedResponse))

        val result = dataSource.getVoitures()

        result.collect { voitures ->
            voitures.forEach {
                assertEquals(it.id, 0)
                assertEquals(it.name, "4x4")

            }
        }
    }

    @Test
    fun `test fetching voitures with error`() = runBlocking {

        val errorResponse = Response.error<VoitureResponse>(404, mock())
        whenever(mockService.getVoitures()).doReturn(errorResponse)

        val result = dataSource.getVoitures()

        result.catch { e ->
            assertEquals(e.message, "${R.string.data_not_received}")
        }.collect {
        }
    }
}
