package com.hendra.dicodingsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendra.dicodingsubmission.DetailActivity.Companion.EXTRA_DATA
import kotlinx.android.synthetic.main.item_grid_layout.view.*

class GridUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<GridUserAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = GridViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_layout, viewGroup, false))

    override fun getItemCount() = listUser.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val users = listUser[position]

        holder.bindItem(users)
        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "You Choose ${users.name}", Toast.LENGTH_SHORT).show()

            val moveIntentWithObject = Intent(view.context, DetailActivity::class.java)
            moveIntentWithObject.putExtra(EXTRA_DATA, users)
            view.context.startActivity(moveIntentWithObject)
        }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(user: User) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .into(imgViewAvatar)
            }
        }
    }
}