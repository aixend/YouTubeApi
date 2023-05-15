package com.example.youtubeapia.ui.playlistItem

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapia.base.BaseActivity
import com.example.youtubeapia.databinding.ActivityDetailBinding
import com.example.youtubeapia.model.PlaylistItem

class DetailActivity : BaseActivity<ActivityDetailBinding, PlaylistItemViewModel>() {
    private lateinit var adapter: DetailAdapter
    override val viewModel: PlaylistItemViewModel by lazy {
        ViewModelProvider(this)[PlaylistItemViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        adapter = DetailAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun initViewModel() {
        super.initViewModel()
        val getIntent:String = intent.getStringExtra("id").toString()
        viewModel.playlistItems(getIntent).observe(this) {
            binding.recyclerView.adapter = adapter
            adapter.addList(it.items!! as List<PlaylistItem.Item>)
        }
    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }


}