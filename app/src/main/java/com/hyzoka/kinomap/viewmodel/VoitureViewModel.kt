package com.hyzoka.kinomap.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyzoka.kinomap.model.Voiture
import com.hyzoka.kinomap.repo.VoitureRepository
import com.hyzoka.kinomap.utils.network.ScreenState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class VoitureViewModel(private val repository: VoitureRepository) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState>
        get() = _screenState

    private val _listVoitures = MutableStateFlow<List<Voiture>>(emptyList())
    val listVoitures: StateFlow<List<Voiture>>
        get() = _listVoitures

    init {
        fetchVoitures()
    }

     fun fetchVoitures() {
        viewModelScope.launch {
            try {
                repository.getVoitures()
                    .onStart {
                        _screenState.value = ScreenState.Loading
                    }
                    .catch {
                        _screenState.value = ScreenState.Error
                    }
                    .collect { voitures ->
                        _screenState.value = ScreenState.Success
                        _listVoitures.value = voitures
                    }
            } catch (e: Exception) {
                _screenState.value = ScreenState.Error
            }
        }
    }
}
