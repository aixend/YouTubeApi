package com.example.youtubeapia.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapia.BuildConfig
import com.example.youtubeapia.base.BaseViewModel
import com.example.youtubeapia.model.Playlist
import com.example.youtubeapia.remote.ApiService
import com.example.youtubeapia.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlists(): LiveData<Playlist> {
        return getPlaylists()
    }

    private fun getPlaylists(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()

        apiService.getPlaylist(
            BuildConfig.API_KEY,
            "contentDetails,snippet",
            "UCkJ1rbOrsyPfBuHNfnLPm-Q",
            30
        ).enqueue(
            object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    println("${t.stackTrace}")
                }

            }
        )
        return data
    }

}