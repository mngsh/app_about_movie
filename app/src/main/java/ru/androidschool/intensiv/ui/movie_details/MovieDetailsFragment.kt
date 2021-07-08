package ru.androidschool.intensiv.ui.movie_details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.movie_details_fragment.*
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.moviedetails.MovieDetails
import ru.androidschool.intensiv.database.MovieDatabase
import ru.androidschool.intensiv.database.MovieEntity
import ru.androidschool.intensiv.extensions.addSchedulers
import ru.androidschool.intensiv.network.MovieApiClient
import ru.androidschool.intensiv.ui.feed.FeedFragment
import timber.log.Timber


class MovieDetailsFragment : Fragment(R.layout.movie_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val index = args?.getInt(FeedFragment.KEY_TITLE, 0)

        val db = context?.let { MovieDatabase.getContext(it).movieDAO() }

        val callMovieDetails = index?.let { MovieApiClient.apiClient.getMovieDetail(it, API_KEY, "ru") }

        val disposable = callMovieDetails?.addSchedulers()?.subscribe {
            val movieResponse = convertMovieToDB(it)
            like_detail_movie.setOnClickListener {
                db?.save(movieResponse)
                    ?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe({}, { Timber.e(it.message.toString()) })
            }
            settingAttributesFragment(it)
        }
    }

    private fun settingAttributesFragment(movieDetails: MovieDetails) {
        title_detail_movie.text = movieDetails.title
        description_detail_movie.text = movieDetails.description
        year_creation_detail_movie.text =movieDetails.yearCreate
        Picasso.get()
            .load(movieDetails.image)
            .into(image_detail_movie)
    }

    private fun convertMovieToDB(dto: MovieDetails): MovieEntity {
        return MovieEntity(dto.id.toLong(), dto.title, dto.image)
    }

    override fun onStop() {
        super.onStop()
    }

    companion object {
        private val API_KEY = "0d4fd65801631f856cd4df53e7c5a7e3"
    }
}
