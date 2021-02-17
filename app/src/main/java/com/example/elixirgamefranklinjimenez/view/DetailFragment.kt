package com.example.elixirgamefranklinjimenez.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.elixirgamefranklinjimenez.GameAdapter
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
        binding.btCarrito.setOnClickListener{
            val addresses = arrayOfNulls<String>(1)

            addresses[0] = "ventas@elixirgames.cl"
            composeEmail(addresses, "Consulta por el juego " + "'" + GameAdapter.selectedItem.value?.name + "'" + " id " + "'" + GameAdapter.selectedItem.value?.id + "'")
        }
        return binding.root
    }

    fun composeEmail(addresses: Array<String?>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, "Hola,\nVi el juego " + "'" + GameAdapter.selectedItem.value?.name + "'" + " de código " + "'" +GameAdapter.selectedItem.value?.id + "'" + "y me gustaría que me contactaran a este correo o al número:_________.\n\n" +
                    "Quedo Atento(a).")
        }
        startActivity(intent)
    }
}