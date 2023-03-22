package com.example.testtable.user

interface RowListener {
    fun rowComplete(user: User)
    fun showError()
}