package ru.androidschool.intensiv.presentation.tvshows

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_tv_shows.*
import ru.androidschool.intensiv.BuildConfig.API_KEY
import ru.androidschool.intensiv.BuildConfig.LANGUAGE
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.dto.tvshow.TVShowDTO
import ru.androidschool.intensiv.domain.usecase.extensions.addSchedulers
import ru.androidschool.intensiv.data.network.TVShowApiClient


class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShows_recyclerview.layoutManager = LinearLayoutManager(context)

        val getTvShow = TVShowApiClient.apiClient.getTVShow(API_KEY, LANGUAGE)

        getTvShow
            .addSchedulers()
            .subscribe({ createTVShowCard(it.tvShowDTO) })

    }

    private fun createTVShowCard(resultTVShowDTOResponse: List<TVShowDTO>) {
        val listTVShow = resultTVShowDTOResponse.map {
            TVShowItem(it) { tvShow ->

            }
        }.toList()
        tvShows_recyclerview.adapter = adapter.apply { addAll(listTVShow) }
    }

}