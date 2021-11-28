package com.jeksonshar.internship

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ActivityViewModel(
    private val dataStore: TestDataStore/*,
    savedStateHandle: SavedStateHandle*/
    ) : ViewModel() {

//    val firstLaunch = savedStateHandle.getLiveData("first launch", dataStore.getFirstLaunch().asLiveData())
    val firstLaunch = dataStore.getFirstLaunch().asLiveData()
    val checkBox1 = dataStore.getCheckbox1().asLiveData()
    val checkBox2 = dataStore.getCheckbox2().asLiveData()

    fun onClear() = viewModelScope.launch { dataStore.saveFirstLaunch(true) }

    fun onSinging() = viewModelScope.launch { dataStore.saveFirstLaunch(false) }

    fun saveCheckbox1() = viewModelScope.launch {
        dataStore.saveCheckBox1(checkBox1.value!!)  // !! можно т.к. присваиваем false при null в getCheckbox()
    }

    fun saveCheckbox2() = viewModelScope.launch {   // !! можно т.к. присваиваем false при null в getCheckbox()
        dataStore.saveCheckBox2(checkBox2.value!!)
    }

}