package com.example.youtubeapia.di

import com.example.youtubeapia.ui.playlist.PlaylistViewModel
import com.example.youtubeapia.ui.playlistItem.PlaylistItemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { PlaylistItemViewModel(get()) }
    viewModel { PlaylistViewModel(get()) }
}
