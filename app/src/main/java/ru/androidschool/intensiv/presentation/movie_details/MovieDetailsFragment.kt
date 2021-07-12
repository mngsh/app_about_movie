package ru.androidschool.intensiv.presentation.movie_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.movie_details_fragment.*
import ru.androidschool.intensiv.BuildConfig.API_KEY
import ru.androidschool.intensiv.BuildConfig.LANGUAGE
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.dto.moviedetail.MovieDetailsDTO
import ru.androidschool.intensiv.data.database.MovieDatabase
import ru.androidschool.intensiv.data.entity.MovieEntity
import ru.androidschool.intensiv.domain.extensions.addSchedulers
import ru.androidschool.intensiv.domain.extensions.addSchedulersToDB
import ru.androidschool.intensiv.data.network.MovieApiClient
import ru.androidschool.intensiv.presentation.feed.FeedFragment
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
                db?.save(movieResponse)?.addSchedulersToDB()?.subscribe({},
                    {Timber.e(it.message.toString())})
                buttonView.setButtonDrawable(R.drawable.ic_like_red)
            } else {
                db?.delete(movieResponse)?.addSchedulersToDB()?.subscribe({},
                    {Timber.e(it.message.toString())})
                buttonView.setButtonDrawable(R.drawable.ic_like)
            }
        }

    }

    private fun settingAttributesFragment(movieDetailsDTO: MovieDetailsDTO) {
        title_detail_movie.text = movieDetailsDTO.title
        description_detail_movie.text = movieDetailsDTO.description
        year_creation_detail_movie.text =movieDetailsDTO.yearCreate
        Picasso.get()
            .load(movieDetailsDTO.image)
            .into(image_detail_movie)
    }

    private fun convertMovieToDB(dto: MovieDetailsDTO): MovieEntity {
        return MovieEntity(dto.id.toLong(), dto.title, dto.image)
    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }

}
