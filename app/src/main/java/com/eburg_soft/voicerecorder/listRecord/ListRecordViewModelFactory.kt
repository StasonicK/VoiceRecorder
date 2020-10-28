package com.eburg_soft.voicerecorder.listRecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eburg_soft.voicerecorder.database.RecordDatabaseDao
import java.lang.IllegalArgumentException

class ListRecordViewModelFactory(private val databaseDao: RecordDatabaseDao):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListRecordViewModel::class.java)){
            return ListRecordViewModel(databaseDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}