package com.example.youtubeapia.ui.playlist

import android.content.Intent
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeapia.core.network.result.Resource
import com.example.youtubeapia.core.ui.BaseActivity
import com.example.youtubeapia.databinding.ActivityMainBinding
import com.example.youtubeapia.model.Playlist
import com.example.youtubeapia.ui.playlistItem.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListActivity : BaseActivity<ActivityMainBinding, PlaylistViewModel>() {

    private lateinit var adapter: PlayListAdapter

    override val viewModel:  PlaylistViewModel by viewModel()


    override fun initViews() {
        super.initViews()
        adapter = PlayListAdapter(this::onClick)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it

        }
        viewModel.getPlaylists().observe(this) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 -> adapter.addList(it1.items) }
                    viewModel.loading.postValue(false)
                }
                Resource.Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
                Resource.Status.ERROR -> {
                    viewModel.loading.postValue(false)
                }
            }
        }
    }



    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    private fun onClick(item: Playlist.Item) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("title", item.snippet?.title)
        intent.putExtra("desc", item.snippet?.description)
        intent.putExtra("count",item.contentDetails?.itemCount)
        startActivity(intent)
    }

}
