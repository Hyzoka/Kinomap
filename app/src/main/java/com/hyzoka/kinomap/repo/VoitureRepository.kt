package com.hyzoka.kinomap.repo

import com.hyzoka.kinomap.datasources.VoitureDataSource
import com.hyzoka.kinomap.model.Voiture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


class VoitureRepository(private val dataSource: VoitureDataSource){

      fun getVoitures(): Flow<List<Voiture>> {
        return dataSource.getVoitures()
            .flowOn(Dispatchers.IO)
    }
}