//package com.example.bentostream.data
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface AnimeDao {
//
//    @Insert
//    suspend fun insertAnimeList(animeList: List<AnimeEntity>)
//
//    @Insert
//    suspend fun insertAnime(anime: AnimeEntity)
//
//    @Query("SELECT * FROM anime_table")
//    fun getAllAnime(): Flow<List<AnimeEntity>>
//
//    @Query("SELECT * FROM anime_table WHERE malId = :id")
//    fun getAnimeById(id: Int): Flow<AnimeEntity?>
//
//    @Query("DELETE FROM anime_table")
//    suspend fun clearAll()
//}