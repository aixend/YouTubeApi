package com.example.youtubeapia.di

import com.example.youtubeapia.repository.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }
}

