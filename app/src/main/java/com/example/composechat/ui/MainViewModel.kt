package com.example.composechat.ui

import androidx.lifecycle.ViewModel
import com.example.composechat.local.DataStoreRepository
import com.example.composechat.local.SharedPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userPreferences: DataStoreRepository,
    private val sharedPreferencesRepository: SharedPreferencesRepository
): ViewModel() {

}