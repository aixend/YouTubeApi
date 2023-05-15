package com.example.youtubeapia.ui.playlistItem

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.youtube.ui.playlist.loadImage
import com.example.youtubeapia.databinding.ItemDetailBinding
import com.example.youtubeapia.model.PlaylistItem

class DetailAdapter(): Adapter<DetailAdapter.DetailViewHolder>() {
    private var list = arrayListOf<PlaylistItem.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<PlaylistItem.Item>) {
        this.list = list as ArrayList<PlaylistItem.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class DetailViewHolder(private val binding: ItemDetailBinding)
        :ViewHolder(binding.root) {
        fun onBind(item: PlaylistItem.Item) {
            with(binding){
                image.loadImage(item.snippet?.thumbnails?.standard?.url!!)
                titleTv.text= item.snippet.title
                durationTv.text= item.snippet.description

            }

        }
    }

}