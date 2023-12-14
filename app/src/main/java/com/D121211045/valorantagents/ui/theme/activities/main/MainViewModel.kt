package com.makassar.newsappcompose.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211045.valorantagents.MyApplication
import com.D121211045.valorantagents.data.models.Ability
import com.D121211045.valorantagents.data.models.Data
import com.D121211045.valorantagents.data.models.RecruitmentData
import com.D121211045.valorantagents.data.models.Role
import com.D121211045.valorantagents.data.repository.ValorantAgentsRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val data: List<Data>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val valorantAgentsRepository: ValorantAgentsRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getData() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = valorantAgentsRepository.getValorantAgents()
            mainUiState = MainUiState.Success(result.data.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getNews error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getData()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val newsRepository = application.container.valorantAgentsRepository
                MainViewModel(newsRepository)
            }
        }
    }

}
