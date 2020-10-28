package com.eburg_soft.voicerecorder.listRecord

import androidx.lifecycle.ViewModel
import com.eburg_soft.voicerecorder.database.RecordDatabaseDao

class ListRecordViewModel(dataSource: RecordDatabaseDao) : ViewModel() {

    val database = dataSource
    val records = dataSource.getAllRecords()
}