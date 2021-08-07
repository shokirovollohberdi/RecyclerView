package com.example.recycelview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recycelview.Models.User
import com.example.recycelview.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_rv.view.*

class UserAdapter(val rvClick: RvClick,var userList: List<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {
    inner class Vh(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User){
            itemView.item_text.text = user.name
            Picasso.get().load(user.imageUrl).into(itemView.image_item)

            itemView.setOnClickListener {
                rvClick.onClick(user)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(userList[position])


    }

    override fun getItemCount(): Int = userList.size

    interface RvClick{
        fun onClick(user:User)
    }
}