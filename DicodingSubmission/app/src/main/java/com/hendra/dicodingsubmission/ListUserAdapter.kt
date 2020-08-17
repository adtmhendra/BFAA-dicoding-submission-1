package com.hendra.dicodingsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendra.dicodingsubmission.DetailActivity.Companion.EXTRA_DATA
import kotlinx.android.synthetic.main.users_row.view.*

class ListUserAdapter(private val list: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) = ListViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.users_row, viewGroup, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listUser = list[position]

        holder.bindItem(listUser)
        holder.itemView.setOnClickListener { view ->
            Toast.makeText(view.context, "You choose " + listUser.name, Toast.LENGTH_SHORT).show()

            val moveIntentWithObject = Intent(view.context, DetailActivity::class.java)
            moveIntentWithObject.putExtra(EXTRA_DATA, listUser)
            view.context.startActivity(moveIntentWithObject)
        }
    }

    inner class ListViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(user: User) {
            with(view) {
                tvName.text    = user.name
                tvCompany.text = user.company
                Glide.with(view).load(user.avatar).into(imgAvatar)
            }
        }
    }
}