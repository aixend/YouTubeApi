package com.example.youtubeapia.di

import com.example.youtubeapia.core.network.networkModule
import com.example.youtubeapia.remote.remoteDataSource
import org.koin.core.module.Module

val koinModules = listOf<Module>(
    repoModules,
    viewModules,
    remoteDataSource,
    networkModule
)