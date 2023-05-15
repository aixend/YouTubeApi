package com.example.youtubeapia.remote

import com.example.youtubeapia.model.Playlist
import com.example.youtubeapia.model.PlaylistItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylist(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResult: Int,
    ) : Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItem(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResult: Int,
    ): Call<PlaylistItem>
}
