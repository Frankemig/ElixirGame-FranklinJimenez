package com.example.elixirgamefranklinjimenez.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.elixirgamefranklinjimenez.GameViewModel
import com.example.elixirgamefranklinjimenez.R
import com.example.elixirgamefranklinjimenez.databinding.DetailGameBinding
import com.example.elixirgamefranklinjimenez.remoto.Game
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: DetailGameBinding
    private lateinit var game:Game

    val gameViewModel : GameViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val binding = DetailGameBinding.inflate(inflater)

        game = gameViewModel.getSelected()

        gameViewModel.getGame(game.id)

     gameViewModel.getGame().observe(viewLifecycleOwner,{
        binding.tvNameDetail.text = it.name
         binding.tvFormato.text = it.format
         binding.tvGenero.text = it.genres
         binding.tvLastPrice.text = it.lastPrice
         binding.tvPrice.text = it.price
         binding.tvPlataforma.text = it.platforms
         binding.tvRatingDetail.text = it.released

         Picasso.get().load(it.background_image)
             .placeholder(R.drawable.ic_idea_comodin)
             .into(binding.imageDetailZoom)

         when(it.delivery == true){

             true -> /*Picasso.get().load(it.deliverySi)
                 .into(binding.imageDelivery)*/
                 Toast.makeText(context, "Si Tiene Delivery", Toast.LENGTH_LONG).show()
             false -> /*Picasso.get().load(it.DeliveryNo)
                 .into(binding.imageDelivery)*/
                 Toast.makeText(context, "No Tiene Delivery", Toast.LENGTH_LONG).show()
         }

     })
        binding.btPedidos.setOnClickListener{
            val addresses = arrayOfNulls<String>(1)

            addresses[0] = "ventas@elixirgames.cl"
            composeEmail(addresses, "Consulta por el juego " + "'" + game.name + "'" + " id " + "'" + game.id+ "'")
        }
        return binding.root
    }

    fun composeEmail(addresses: Array<String?>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, "Hola,\nVi el juego " + "'" + game.name+ "'" + " de código " + "'" + game.id + "'" + "y me gustaría que me contactaran a este correo o al número:_________.\n\n" +
                    "Quedo Atento(a).")
        }
        startActivity(intent)
    }
/*    fun link(url: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }*/
}