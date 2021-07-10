package ru.androidschool.intensiv.ui.movie_details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tv_show.view.*
import kotlinx.android.synthetic.main.movie_details_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.moviedetails.MovieDetails
import ru.androidschool.intensiv.extensions.addSchedulers
import ru.androidschool.intensiv.network.MovieApiClient
import ru.androidschool.intensiv.ui.feed.FeedFragment
import timber.log.Timber
import java.util.*


class MovieDetailsFragment : Fragment(R.layout.movie_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val index = args?.getInt(FeedFragment.KEY_TITLE, 0)

        val callMovieDetails = index?.let { MovieApiClient.apiClient.getMovieDetail(it, API_KEY, "ru") }

        callMovieDetails?.addSchedulers()?.subscribe({
                        settingAttributesFragment(it)
            }, {Log.e("error", it.message.toString())})

    }

    private fun settingAttributesFragment(movieDetails: MovieDetails) {
        title_detail_movie.text = movieDetails.title
        description_detail_movie.text = movieDetails.description
        year_creation_detail_movie.text =movieDetails.yearCreate
        Picasso.get()
            .load(movieDetails.image)
            .into(image_detail_movie)
    }

    companion object {
        private val API_KEY = "0d4fd65801631f856cd4df53e7c5a7e3"
    }
}
