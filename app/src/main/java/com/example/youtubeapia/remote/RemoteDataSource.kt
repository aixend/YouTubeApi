package com.example.youtubeapia.remote

import com.example.youtubeapia.BuildConfig
import com.example.youtubeapia.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}
class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {



    suspend fun getPlaylists() = getResult {
        apiService.getPlaylist(
            BuildConfig.API_KEY,
            "contentDetails,snippet",
            "UCkJ1rbOrsyPfBuHNfnLPm-Q",
            20
        )
    }

    suspend fun getPlaylistItem(playlistId: String?) = getResult {
        apiService.getPlaylistItem(
            BuildConfig.API_KEY,
            "contentDetails,snippet",
            playlistId!!,
            20
        )
    }
}