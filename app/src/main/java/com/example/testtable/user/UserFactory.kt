package com.example.testtable.user

object UserFactory {
    private val listUser = mutableListOf(
        User("Участник 1", 1, null, null, null, null, null, null, null, "", ""),
        User("Участник 2", 2, null, null, null, null, null, null, null, "", ""),
        User("Участник 3", 3, null, null, null, null, null, null, null, "", ""),
        User("Участник 4", 4, null, null, null, null, null, null, null, "", ""),
        User("Участник 5", 5, null, null, null, null, null, null, null, "", ""),
        User("Участник 6", 6, null, null, null, null, null, null, null, "", ""),
        User("Участник 7", 7, null, null, null, null, null, null, null, "", ""),
    )


    fun getUsers(): List<User> {
        return listUser.map { it.copy() }
    }

    fun distributionPlaces(user: User): Boolean {
        updateUser(user)
        return if (tableComplete()) {
            listUser.sortBy { it.sumPoint.toInt() }

            for (i in 0 until listUser.size) {
                listUser[i].place = (listUser.size - i).toString()
            }

            listUser.sortBy { it.id }
            return true
        } else false
    }

    private fun updateUser(user: User) {
        val index = listUser.indexOfFirst {
            it.id == user.id
        }
        listUser[index] = user
    }

    private fun tableComplete(): Boolean {
        listUser.forEach {
            if (it.sumPoint.isEmpty()) return false
        }
        return true
    }
}