package ru.androidschool.intensiv.ui.movie_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.movie_details_fragment.*
import ru.androidschool.intensiv.BuildConfig.API_KEY
import ru.androidschool.intensiv.BuildConfig.LANGUAGE
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.moviedetails.MovieDetails
import ru.androidschool.intensiv.database.MovieDatabase
import ru.androidschool.intensiv.database.MovieEntity
import ru.androidschool.intensiv.extensions.addSchedulers
import ru.androidschool.intensiv.extensions.addSchedulersToDB
import ru.androidschool.intensiv.network.MovieApiClient
import ru.androidschool.intensiv.ui.feed.FeedFragment
import timber.log.Timber


class MovieDetailsFragment : Fragment(R.layout.movie_details_fragment) {
    lateinit var disposable: Disposable
    lateinit var movieResponse: MovieEntity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = context?.let { MovieDatabase.getContext(it).movieDAO() }

        val args = arguments
        val index = args?.getInt(FeedFragment.KEY_TITLE, 0)

        val callMovieDetails = index?.let {
            MovieApiClient.apiClient.getMovieDetail(it, API_KEY, LANGUAGE) }

        disposable = callMovieDetails?.addSchedulers()?.subscribe{
            movieResponse = convertMovieToDB(it)
            settingAttributesFragment(it)
        }!!

        like_detail_movie.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                db?.save(movieResponse)?.addSchedulersToDB()?.subscribe()
                buttonView.setButtonDrawable(R.drawable.ic_like_red)
            } else if (!isChecked) {
                db?.delete(movieResponse)?.addSchedulersToDB()?.subscribe()
                buttonView.setButtonDrawable(R.drawable.ic_like)
            }
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
        disposable.dispose()
    }

}
