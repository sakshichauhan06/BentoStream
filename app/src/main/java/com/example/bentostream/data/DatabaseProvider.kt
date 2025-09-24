//package com.example.bentostream.data
//
//import android.content.Context
//import androidx.room.Room
//
//object DatabaseProvider {
//
//    @Volatile
//    private var INSTANCE: AnimeDatabase? = null
//
//    fun getDatabase(context: Context): AnimeDatabase {
//        return INSTANCE ?: synchronized(this) {
//            val instance = Room.databaseBuilder(
//                context.applicationContext,
//                AnimeDatabase::class.java,
//                "anime_database"
//            ).build()
//            INSTANCE = instance
//            instance
//        }
//
//    }
//
//}