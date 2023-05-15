package com.example.youtubeapia.ui.playlist

import androidx.lifecycle.LiveData
import com.example.youtubeapia.core.network.result.Resource
import com.example.youtubeapia.core.ui.BaseViewModel
import com.example.youtubeapia.model.Playlist
import com.example.youtubeapia.repository.Repository

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        return repository.getPlaylists()
    }
}