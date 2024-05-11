package com.pettpro.data.repository.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pettpro.data.repository.db.converter.UserConvertor
import com.pettpro.data.repository.db.dao.UserDao
import com.pettpro.data.repository.db.model.UserEntity

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(UserConvertor::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getDatabaseInstance(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}