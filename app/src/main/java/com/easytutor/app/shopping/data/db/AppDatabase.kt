package com.easytutor.app.shopping.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.easytutor.app.shopping.data.db.entity.Cart

@Database(entities = [Cart::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCartDao() : CartDao

    companion object{

        private var instance : AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context : Context) = instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDB.db"
            ).build()
    }
}