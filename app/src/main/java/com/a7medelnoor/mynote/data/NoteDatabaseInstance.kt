package com.a7medelnoor.mynote.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.a7medelnoor.mynote.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabaseInstance : RoomDatabase() {

    abstract fun getNoteRoomDataBaseDao(): NoteRoomDataBaseDao

    companion object {
        @Volatile
        private var noteDatabaseInstance: NoteDatabaseInstance? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = noteDatabaseInstance ?: synchronized(LOCK) {
            noteDatabaseInstance ?:
            createNoteDataBase(context).also { noteDatabaseInstance = it }
        }

        private fun createNoteDataBase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabaseInstance::class.java,
            "note_database",
        ).fallbackToDestructiveMigration().build()
    }

}