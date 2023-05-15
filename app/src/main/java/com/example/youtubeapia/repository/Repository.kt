package com.example.youtubeapia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapia.core.network.result.Resource
import com.example.youtubeapia.model.Playlist
import com.example.youtubeapia.model.PlaylistItem
import com.example.youtubeapia.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers


class Repository(private val dataSource: RemoteDataSource) {

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getPlaylists()
            emit(response)
        }
    }

    fun getPlaylistItem(playlistId: String): LiveData<Resource<PlaylistItem>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getPlaylistItem(playlistId)
            emit(response)
        }
    }
}