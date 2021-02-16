package com.example.elixirgamefranklinjimenez.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.elixirgamefranklinjimenez.GameAdapter
import com.example.elixirgamefranklinjimenez.GameViewModel
import com.example.elixirgamefranklinjimenez.R
import com.example.elixirgamefranklinjimenez.databinding.ListGameBinding

class GameList : Fragment() {

    private val gameVM: GameViewModel by activityViewModels()
    private lateinit var adapter : GameAdapter
    private lateinit var binding: ListGameBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListGameBinding.inflate(inflater)

        adapter = GameAdapter()
        binding.rvList.adapter = adapter

        binding.rvList.layoutManager = GridLayoutManager(context, 1)

        gameVM.gameList().observe(viewLifecycleOwner, {
        adapter.update(it)
        })

        adapter.selectedItem().observe(viewLifecycleOwner, {

            gameVM.setSelected(it)

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, DetailFragment())
                ?.addToBackStack("detail")?.commit()

        })

            return binding.root
    }
}