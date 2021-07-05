package ru.androidschool.intensiv.ui.movie_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.moviedetails.MovieDetails
import ru.androidschool.intensiv.network.MovieApiClient
import ru.androidschool.intensiv.ui.feed.FeedFragment
import timber.log.Timber

/**
 * как лучше привязать данные с view? через viewbinding? или какой-то другой вариант?
 */
class MovieDetailsFragment : Fragment(R.layout.movie_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val index = args?.getInt(FeedFragment.KEY_TITLE, 0)

        val callMovieDetails = MovieApiClient.apiClient.getMovieDetail(index!!, API_KEY)

//        callMovieDetails.enqueue(object: Callback<MovieDetails> {
//            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
//                Timber.d("Response")
//
//                val detailMovieResponse = response.body()
//
//            }
//
//            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
//                Timber.e("Fail")
//            }
//
//        })

    }

    companion object {
        private val API_KEY = "0d4fd65801631f856cd4df53e7c5a7e3"
    }
}
