package ru.androidschool.intensiv.presentation.watchlist

import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_with_text.*
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.dto.moviefeed.MovieDTO
import ru.androidschool.intensiv.data.entity.MovieEntity

class MoviePreviewItem(
    private val content: MovieEntity,
    private val onClick: (movieDTO: MovieDTO) -> Unit
) : Item() {

    override fun getLayout() = R.layout.item_small

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.image_preview.setOnClickListener {

        }

        Picasso.get()
            .load(content.image)
            .into(viewHolder.image_preview)
    }
}
