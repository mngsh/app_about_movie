package ru.androidschool.intensiv.ui.tvshows

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import kotlinx.android.synthetic.main.fragment_watchlist.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.MoviesResponse
import ru.androidschool.intensiv.data.tvshow.TVShow
import ru.androidschool.intensiv.data.tvshow.TVShowResponse
import ru.androidschool.intensiv.extensions.addSchedulers
import ru.androidschool.intensiv.network.MovieApiClient
import ru.androidschool.intensiv.network.TVShowApiClient
import ru.androidschool.intensiv.ui.feed.FeedFragment
import ru.androidschool.intensiv.ui.feed.MainCardContainer
import ru.androidschool.intensiv.ui.feed.MovieItem
import timber.log.Timber


class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShows_recyclerview.layoutManager = LinearLayoutManager(context)

        val getTvShow = TVShowApiClient.apiClient.getTVShow(API_KEY, "ru")

        val disposable = getTvShow
            .addSchedulers()
            .subscribe({createTVShowCard(it.tvShow)}, {Log.e("error", it.message.toString())})

    }

    private fun createTVShowCard(resultTVShowResponse: List<TVShow>){
        val listTVShow = resultTVShowResponse.map {  TVShowItem(it) { tvShow ->
            openMovieDetails(tvShow) }
        }.toList()
        tvShows_recyclerview.adapter = adapter.apply { addAll(listTVShow) }
    }

    private fun openMovieDetails(tvShow: TVShow) {

    }

    companion object {
        private val API_KEY = "0d4fd65801631f856cd4df53e7c5a7e3"
    }

}