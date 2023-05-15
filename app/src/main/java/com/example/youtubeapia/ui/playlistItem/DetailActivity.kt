package com.example.youtubeapia.ui.playlistItem

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapia.core.ui.BaseActivity
import com.example.youtubeapia.databinding.ActivityDetailBinding
import com.example.youtubeapia.model.PlaylistItem
import org.koin.androidx.viewmodel.ext.android.viewModel


@Suppress("UNCHECKED_CAST")
class DetailActivity : BaseActivity<ActivityDetailBinding, PlaylistItemViewModel>() {
    private lateinit var adapter: DetailAdapter

    override val viewModel:  PlaylistItemViewModel by viewModel()


    override fun initViews() {
        super.initViews()
        adapter = DetailAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun initViewModel() {
        super.initViewModel()
        val getIntent:String = intent.getStringExtra("id").toString()
        viewModel.getPlaylistItem(getIntent).observe(this) {
            it.data?.let { it1 -> adapter.addList(it1.items as List<PlaylistItem.Item>) }
        }

    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }


}