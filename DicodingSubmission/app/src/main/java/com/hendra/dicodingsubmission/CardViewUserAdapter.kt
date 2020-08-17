package com.hendra.dicodingsubmission

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_layout.view.*

class CardViewUserAdapter (private val users: ArrayList<User>) : RecyclerView.Adapter<CardViewUserAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = CardViewViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_layout, viewGroup, false))

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val listUser = users[position]

        holder.bindItem(listUser)
        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "You choose " + listUser.name, Toast.LENGTH_SHORT).show()
        }
    }

    inner class CardViewViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(user: User) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(user.avatar)
                    .into(imgViewAvatar)
                tvName.text = user.name
                tvCompany.text = user.company
            }
        }
    }
}