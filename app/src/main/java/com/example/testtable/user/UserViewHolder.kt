package com.example.testtable.user

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.testtable.databinding.ItemViewHolderBinding

class UserViewHolder(private val binding: ItemViewHolderBinding) : ViewHolder(binding.root) {
    private var bindFlag = false
    private val draw1 = binding.editText1.background
    private val draw2 = binding.editText2.background
    private val draw3 = binding.editText3.background
    private val draw4 = binding.editText4.background
    private val draw5 = binding.editText5.background
    private val draw6 = binding.editText6.background
    private val draw7 = binding.editText7.background


    fun onBind(user: User, rowListener: RowListener) {
        bindFlag = true

        binding.textViewName.text = user.name
        binding.textViewId.text = user.id.toString()

        val point1 = user.point1?.toString() ?: ""
        binding.editText1.setText(point1)
        binding.editText1.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText1.background = draw1
                    binding.editText2.requestFocus()
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText1.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.editText2.setText(user.point2?.toString() ?: "")
        binding.editText2.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText2.background = draw2
                    binding.editText3.requestFocus()
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText2.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.editText3.setText(user.point3?.toString() ?: "")
        binding.editText3.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText3.background = draw3
                    binding.editText4.requestFocus()
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText3.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.editText4.setText(user.point4?.toString() ?: "")
        binding.editText4.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText4.background = draw4
                    binding.editText5.requestFocus()
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText4.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.editText5.setText(user.point5?.toString() ?: "")
        binding.editText5.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText5.background = draw5
                    binding.editText6.requestFocus()
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText5.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.editText6.setText(user.point6?.toString() ?: "")
        binding.editText6.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText6.background = draw6
                    binding.editText7.requestFocus()
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText6.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.editText7.setText(user.point7?.toString() ?: "")
        binding.editText7.addTextChangedListener { str ->
            if (!str.isNullOrEmpty()) {
                if (str.toString().toInt() in 0..5) {
                    binding.editText7.background = draw7
                    if (!bindFlag) sumPoint(rowListener)
                } else {
                    binding.editText7.setBackgroundColor(Color.RED)
                    rowListener.showError()
                }
            }
        }

        binding.textViewSum.text = user.sumPoint
        binding.textViewPlace.text = user.place

        bindFlag = false
    }

    @SuppressLint("SetTextI18n")
    private fun sumPoint(rowListener: RowListener) {
        binding.apply {
            if (!editText1.text.isNullOrEmpty() && editText1.text.toString().toInt() in 0..5 &&
                !editText2.text.isNullOrEmpty() && editText2.text.toString().toInt() in 0..5 &&
                !editText3.text.isNullOrEmpty() && editText3.text.toString().toInt() in 0..5 &&
                !editText4.text.isNullOrEmpty() && editText4.text.toString().toInt() in 0..5 &&
                !editText5.text.isNullOrEmpty() && editText5.text.toString().toInt() in 0..5 &&
                !editText6.text.isNullOrEmpty() && editText6.text.toString().toInt() in 0..5 &&
                !editText7.text.isNullOrEmpty() && editText7.text.toString().toInt() in 0..5
            ) {
                textViewSum.text =
                    (editText1.text.toString().toInt() +
                            editText2.text.toString().toInt() +
                            editText3.text.toString().toInt() +
                            editText4.text.toString().toInt() +
                            editText5.text.toString().toInt() +
                            editText6.text.toString().toInt() +
                            editText7.text.toString().toInt()).toString()

                rowListener.rowComplete(
                    User(
                        textViewName.text.toString(),
                        textViewId.text.toString().toInt(),
                        editText1.text.toString().toInt(),
                        editText2.text.toString().toInt(),
                        editText3.text.toString().toInt(),
                        editText4.text.toString().toInt(),
                        editText5.text.toString().toInt(),
                        editText6.text.toString().toInt(),
                        editText7.text.toString().toInt(),
                        textViewSum.text.toString(),
                        textViewPlace.text.toString()
                    )
                )
            }
        }
    }
}