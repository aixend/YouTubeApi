package com.example.youtubeapia.ui.playlistItem

import androidx.lifecycle.LiveData
import com.example.youtubeapia.core.network.result.Resource
import com.example.youtubeapia.core.ui.BaseViewModel
import com.example.youtubeapia.model.PlaylistItem
import com.example.youtubeapia.repository.Repository

class PlaylistItemViewModel(private val repository: Repository): BaseViewModel() {
    fun getPlaylistItem(playlistId: String?): LiveData<Resource<PlaylistItem>> {
        return repository.getPlaylistItem(playlistId!!)
    }
}