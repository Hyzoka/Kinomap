package com.hyzoka.kinomap.datasources

import com.google.gson.annotations.SerializedName
import com.hyzoka.kinomap.model.Voiture

data class VoitureResponse(
    @SerializedName("vehicleList") val vehicleList: VehicleList
)

data class VehicleList(
    @SerializedName("status") val status: String,
    @SerializedName("response") val response: List<Voiture>
)