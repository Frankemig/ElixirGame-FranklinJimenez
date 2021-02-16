package com.example.elixirgamefranklinjimenez.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.elixirgamefranklinjimenez.GameViewModel
import com.example.elixirgamefranklinjimenez.R
import com.example.elixirgamefranklinjimenez.databinding.DetailGameBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: DetailGameBinding

    val gameViewModel : GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val binding = DetailGameBinding.inflate(inflater)

     gameViewModel.getGame().observe(viewLifecycleOwner,{
        binding.tvNameDetail.text = it.name

         Picasso.get().load(it.background_image)
             .placeholder(R.drawable.ic_idea_comodin)
             .into(binding.imageDetailZoom)

     })
        return binding.root
    }
}