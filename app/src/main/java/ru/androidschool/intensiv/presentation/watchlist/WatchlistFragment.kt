package ru.androidschool.intensiv.presentation.watchlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_watchlist.movies_recycler_view
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.database.MovieDatabase
import ru.androidschool.intensiv.database.MovieEntity


class WatchlistFragment : Fragment(R.layout.fragment_watchlist) {

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = context?.let { MovieDatabase.getContext(it).movieDAO() }

        val disposable = db?.getAllMovie()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe{ createMovieCard(it)}

    }

    private fun createMovieCard(resultMovieResponse: List<MovieEntity>) {
        val listMovie = resultMovieResponse.map {
            MoviePreviewItem(it) { tvShow -> }
        }.toList()
        movies_recycler_view.layoutManager = GridLayoutManager(context, 4)
        movies_recycler_view.adapter = adapter.apply { addAll(listMovie) }
    }

    companion object {
        @JvmStatic
        fun newInstance() = WatchlistFragment()
    }
}
