package com.example.youtubeapia.ui.playlistItem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapia.BuildConfig
import com.example.youtubeapia.base.BaseViewModel
import com.example.youtubeapia.model.PlaylistItem
import com.example.youtubeapia.remote.ApiService
import com.example.youtubeapia.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistItemViewModel: BaseViewModel() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlistItems(id:String): LiveData<PlaylistItem> {
        return getPlaylistItem(id)
    }

    private fun getPlaylistItem(id: String): LiveData<PlaylistItem> {
        val data = MutableLiveData<PlaylistItem>()

        apiService.getPlaylistItem(
            BuildConfig.API_KEY,
            "contentDetails,snippet",
            id,
            30
        ).enqueue(
            object : Callback<PlaylistItem> {
                override fun onResponse(call: Call<PlaylistItem>, response: Response<PlaylistItem>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<PlaylistItem>, t: Throwable) {
                    println("${t.stackTrace}")
                }

            }
        )
        return data
    }

}