package com.example.testtable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import com.example.testtable.databinding.FragmentTableBinding
import com.example.testtable.user.*


class TableFragment : Fragment(), RowListener {
    private var _binding: FragmentTableBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: UserAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UserAdapter(this)
        binding.recycler.adapter = adapter
        updateData(UserFactory.getUsers())
    }

    private fun updateData(list: List<User>) {
        val userDiffUtilCallback = UserDiffUtilCallback(adapter.listUser, list)
        val userDiffResult = DiffUtil.calculateDiff(userDiffUtilCallback)
        adapter.setData(list)
        userDiffResult.dispatchUpdatesTo(adapter)
    }

    override fun rowComplete(user: User) {
        if (UserFactory.distributionPlaces(user))
            updateData(UserFactory.getUsers())
    }

    override fun showError() {
        Toast.makeText(requireContext(), "Введите цифру от 0 до 5", Toast.LENGTH_SHORT).show()
    }

    companion object {

        @JvmStatic
        fun newInstance() = TableFragment()
    }
}