package ru.androidschool.intensiv.presentation.tvshows

import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_tv_show.*
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.dto.tvshow.TVShowDTO


class TVShowItem(
    private val content: TVShowDTO,
    private val onClick: (tvShowDTO: TVShowDTO) -> Unit
) : Item() {

    override fun getLayout() = R.layout.item_tv_show

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.description.text = content.title
//        viewHolder.tvShow_rating.rating = content.rating
        viewHolder.content.setOnClickListener {
            onClick.invoke(content)
        }

        Picasso.get()
            .load(content.image)
            .into(viewHolder.image_tvShow)
    }
}