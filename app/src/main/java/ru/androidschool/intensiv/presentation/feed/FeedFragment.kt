package ru.androidschool.intensiv.presentation.feed


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import io.reactivex.Observable
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.feed_fragment.*
import kotlinx.android.synthetic.main.feed_header.*
import kotlinx.android.synthetic.main.search_toolbar.view.*
import ru.androidschool.intensiv.BuildConfig.API_KEY
import ru.androidschool.intensiv.BuildConfig.LANGUAGE
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.dto.moviefeed.MovieDTO
import ru.androidschool.intensiv.data.dto.moviefeed.MovieResponseDTO
import ru.androidschool.intensiv.data.dto.moviefeed.FeedMovieDTO
import ru.androidschool.intensiv.domain.usecase.extensions.addSchedulers
import ru.androidschool.intensiv.data.network.MovieApiClient
import ru.androidschool.intensiv.presentation.afterTextChanged
import timber.log.Timber

class FeedFragment : Fragment(R.layout.feed_fragment) {

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    private val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_toolbar.search_edit_text.afterTextChanged {
            Timber.d(it.toString())
            if (it.toString().length > MIN_LENGTH) {
                openSearch(it.toString())
            }
        }

        val getNowPlayingMovie = MovieApiClient.apiClient.getUpcomingMovie(API_KEY, LANGUAGE)
        val getRecommendedMovie = MovieApiClient.apiClient.getTopRatedMovie(API_KEY, LANGUAGE)
        val getPopularMovie = MovieApiClient.apiClient.getPopularMovie(API_KEY, LANGUAGE)

        val disp = Observable.zip(getNowPlayingMovie, getRecommendedMovie, getPopularMovie,
            Function3<MovieResponseDTO, MovieResponseDTO, MovieResponseDTO, FeedMovieDTO>
            { getNowPlayingMovie, getRecommendedMovie, getPopularMovie ->
                FeedMovieDTO(
                    getNowPlayingMovie.results,
                    getRecommendedMovie.results,
                    getPopularMovie.results
                )
            }
        )
            .addSchedulers()
            .doOnSubscribe { feed_fragment_progress_bar.visibility = View.VISIBLE }
            .doFinally { feed_fragment_progress_bar.visibility = View.INVISIBLE }
            .subscribe {
                createMovieCard(it.popularMovieDTO, R.string.recommended)
                createMovieCard(it.recommendedMovieDTO, R.string.popular)
                createMovieCard(it.playingMovieDTO, R.string.upcoming)
            }
    }

    private fun createMovieCard(resultMoviesResponse: List<MovieDTO>, titleSection: Int) {
        val listMovie = resultMoviesResponse.map {
            MovieItem(it) { movie ->
                openMovieDetails(movie)
            }
        }.toList()
        val listCard = listOf(listMovie.let { MainCardContainer(titleSection, it) })

        movies_recycler_view.adapter = adapter.apply { addAll(listCard) }
    }

    private fun openMovieDetails(movieDTO: MovieDTO) {
        val bundle = Bundle()
        if (movieDTO.movieId != null) {
            bundle.putInt(KEY_TITLE, movieDTO.movieId)
        }
        findNavController().navigate(R.id.movie_details_fragment, bundle, options)
    }

    private fun openSearch(searchText: String) {
        val bundle = Bundle()
        bundle.putString(KEY_SEARCH, searchText)
        findNavController().navigate(R.id.search_dest, bundle, options)
    }

    override fun onStop() {
        super.onStop()
        search_toolbar.clear()
        adapter.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    companion object {
        const val MIN_LENGTH = 3
        const val KEY_TITLE = "title"
        const val KEY_SEARCH = "search"
    }
}
