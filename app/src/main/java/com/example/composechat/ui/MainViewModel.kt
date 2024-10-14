package com.example.composechat.ui

import androidx.lifecycle.ViewModel
import com.example.composechat.local.DataStoreRepository
import com.example.composechat.local.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreferences: DataStoreRepository,
    private val sharedPreferencesRepository: SharedPreferencesRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun createNewChat() {

    }

    fun joinToChat() {

    }

    data class UiState (
//        var isConnected: Boolean = false,
        var state: State = State.Loading
    ) {
        enum class State {
            Loading, Fetched, Failure
        }
    }
}