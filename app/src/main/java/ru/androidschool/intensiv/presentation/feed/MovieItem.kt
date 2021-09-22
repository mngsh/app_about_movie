package ru.androidschool.intensiv.presentation.feed

import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_with_text.*
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.dto.moviefeed.MovieDTO

class MovieItem(
    private val content: MovieDTO,
    private val onClick: (movieDTO: MovieDTO) -> Unit
) : Item() {

    override fun getLayout() = R.layout.item_with_text

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.description.text = content.title
//        viewHolder.movie_rating.rating = content.voteAverage
        viewHolder.content.setOnClickListener {
            onClick.invoke(content)
        }

        Picasso.get()
            .load(content.image)
            .into(viewHolder.image_preview)
    }
}