package com.example.youtubeapia.ui.playlist

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapia.base.BaseActivity
import com.example.youtubeapia.databinding.ActivityMainBinding
import com.example.youtubeapia.model.Playlist
import com.example.youtubeapia.ui.PlayListAdapter

class PlaylistActivity : BaseActivity<ActivityMainBinding, PlaylistViewModel>() {
    private lateinit var adapter: PlayListAdapter

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        adapter = PlayListAdapter(this::onClick)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.playlists().observe(this) {
            binding.recyclerView.adapter = adapter
            adapter.addList(it.items!! as List<Playlist.Item>)
        }
    }
    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
    private fun onClick(item:Playlist.Item) {

    }
}