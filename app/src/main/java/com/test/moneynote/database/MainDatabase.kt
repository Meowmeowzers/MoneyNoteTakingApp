package com.test.moneynote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ListItem::class], version = 1, exportSchema = false)
abstract class MainDatabase: RoomDatabase() {

    abstract val databaseDao: DatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDatabase::class.java, "database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
//                        .createFromAsset("quiz_database.db")
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}