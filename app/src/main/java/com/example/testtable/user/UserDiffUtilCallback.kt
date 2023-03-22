package com.example.testtable.user

import androidx.recyclerview.widget.DiffUtil

class UserDiffUtilCallback(
    private val oldLIst: List<User>,
    private val newLIst: List<User>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldLIst.size
    }

    override fun getNewListSize(): Int {
        return newLIst.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldLIst[oldItemPosition]
        val newUser = newLIst[newItemPosition]
        return oldUser.id == newUser.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldUser = oldLIst[oldItemPosition]
        val newUser = newLIst[newItemPosition]
        return oldUser.place.toIntOrNull() == newUser.place.toIntOrNull() && oldUser == newUser
    }
}