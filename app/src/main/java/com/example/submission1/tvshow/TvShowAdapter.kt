package com.example.submission1.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission1.R
import com.example.submission1.data.source.remote.response.ResultsItemTv
import com.example.submission1.databinding.ItemsTvshowBinding
import com.example.submission1.detailTvShow.DetailTvShowActivity

class TvShowAdapter(private val callback: TvShowFragmentCallback) : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<ResultsItemTv>()

    fun setTvShow(tvshow : List<ResultsItemTv>?){
        if(tvshow == null)
            return this.listTvShow.clear()
        this.listTvShow.addAll(tvshow)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.TvShowViewHolder {
       val itemsTvShowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun getItemCount(): Int = listTvShow.size

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val tvshow = listTvShow[position]
        holder.bind(tvshow)
    }

    inner class TvShowViewHolder(private val binding : ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow : ResultsItemTv){
            with(binding){
                txtItemTitle.text = tvshow.name
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_DETAIL, tvshow.id)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvshow) }
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500/"+tvshow.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgPoster)
            }
        }
    }
}