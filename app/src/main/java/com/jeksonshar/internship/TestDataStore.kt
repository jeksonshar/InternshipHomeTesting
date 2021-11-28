package com.jeksonshar.internship

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class TestDataStore(context: Context) {

    private val preferences = context.dataStore

    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
        val FIRST_LAUNCH = booleanPreferencesKey("first launch")
        val CHECKBOX_1 = booleanPreferencesKey("checkbox 1")
        val CHECKBOX_2 = booleanPreferencesKey("checkbox 2")
    }

    fun getFirstLaunch(): Flow<Boolean> = preferences.data.map {
        it[FIRST_LAUNCH] ?: true
    }

    suspend fun saveFirstLaunch(value: Boolean) {
        preferences.edit {
            it[FIRST_LAUNCH] = value
        }
    }

    fun getCheckbox1(): Flow<Boolean> = preferences.data.map {
        it[CHECKBOX_1] ?: false
    }

    fun getCheckbox2(): Flow<Boolean> = preferences.data.map {
        it[CHECKBOX_2] ?: false
    }

    suspend fun saveCheckBox1(value: Boolean){
        preferences.edit {
            it[CHECKBOX_1] = !value
        }
    }

    suspend fun saveCheckBox2(value: Boolean){
        preferences.edit {
            it[CHECKBOX_2] = !value
        }
    }

}