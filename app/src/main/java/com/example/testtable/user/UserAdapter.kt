package com.example.testtable.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.testtable.R
import com.example.testtable.databinding.ItemViewHolderBinding

class UserAdapter(private val rowListener: RowListener) : Adapter<UserViewHolder>() {
    var listUser = mutableListOf<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    R.color.purple_200
                )
            )
        } else {
            holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    com.google.android.material.R.color.material_grey_300
                )
            )
        }
        holder.onBind(listUser[position], rowListener)
    }

    fun setData(list: List<User>) {
        listUser.clear()
        listUser.addAll(list)
    }
}