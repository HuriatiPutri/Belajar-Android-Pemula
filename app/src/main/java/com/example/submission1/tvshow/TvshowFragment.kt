package com.example.submission1.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.submission1.data.source.remote.response.ResultsItemTv
import com.example.submission1.databinding.FragmentTvshowBinding
import com.example.submission1.viewModel.ViewModelFactory


class TvshowFragment : Fragment(), TvShowFragmentCallback {

    private lateinit var fragmentTvshowBinding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(layoutInflater, container, false)
        return fragmentTvshowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstant(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
//            val tvshow = viewModel.getDataTvShow()
            val tvShowAdapter = TvShowAdapter(this)
            fragmentTvshowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getDataTvShow().observe(viewLifecycleOwner) { tvShow ->
                fragmentTvshowBinding.progressBar.visibility = View.GONE
                tvShowAdapter.setTvShow(tvShow)
                tvShowAdapter.notifyDataSetChanged()
            }

            with(fragmentTvshowBinding.rvTvshow){
                layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                fragmentTvshowBinding.rvTvshow.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 3)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }


    override fun onShareClick(tvshow: ResultsItemTv) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(tvshow.name)
                    .startChooser()
        }
    }
}