package com.eburg_soft.voicerecorder

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.eburg_soft.voicerecorder.database.RecordDatabase
import com.eburg_soft.voicerecorder.database.RecordDatabaseDao
import com.eburg_soft.voicerecorder.database.RecordingItem
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.*

@RunWith(AndroidJUnit4::class)
class RecordDatabaseTest {

    private lateinit var recordDatabaseDao: RecordDatabaseDao
    private lateinit var database: RecordDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, RecordDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        recordDatabaseDao = database.recordDatabaseDao
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    fun testDatabase() {
        recordDatabaseDao.insert(RecordingItem())
        val count = recordDatabaseDao.getCount()
        assertEquals(1, count)
    }
}