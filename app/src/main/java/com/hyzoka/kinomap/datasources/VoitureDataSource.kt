package com.hyzoka.kinomap.datasources

import com.hyzoka.kinomap.model.Voiture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class VoitureDataSource(private val voitureService: VoitureService) {

    fun getVoitures(): Flow<List<Voiture>> = flow {
        try {
            val response = withContext(Dispatchers.IO){
                voitureService.getVoitures()
            }
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(body.vehicleList.response)
                } else {
                    throw Exception("Réponse vide")
                }
            } else {
                throw Exception("Échec de la récupération des données")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}
