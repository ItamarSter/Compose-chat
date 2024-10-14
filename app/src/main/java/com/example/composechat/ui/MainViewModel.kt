package com.example.composechat.ui

import androidx.lifecycle.ViewModel
import com.example.composechat.local.DataStoreRepository
import com.example.composechat.local.SharedPreferencesRepository
import com.example.composechat.use_cases.ChatsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreferences: DataStoreRepository,
    private val sharedPreferencesRepository: SharedPreferencesRepository,
    private val chatsManager: ChatsManager
): ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun createNewChat(chatName: String) {
        chatsManager.createNewChat(chatName)
    }

    fun joinToChat(chatCode: String) {
        chatsManager.joinToChat(chatCode)
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