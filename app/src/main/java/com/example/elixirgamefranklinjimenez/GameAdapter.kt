package com.example.elixirgamefranklinjimenez

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.elixirgamefranklinjimenez.databinding.ItemGameBinding
import com.example.elixirgamefranklinjimenez.remoto.Game
import com.squareup.picasso.Picasso

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameVH>() {
companion object {
     val selectedItem = MutableLiveData<Game>()
}
    fun selectedItem(): LiveData<Game> = selectedItem
    private var gameList = listOf<Game>()

    class GameVH(val binding: ItemGameBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(game : Game){
            binding.tvName.text = game.name
            binding.tvReleased.text = game.released
            binding.tvRating.text = game.rating.toString()
            binding.tvFuerza.text = game.metacritic.toString()

            Picasso.get().load(game.background_image)
                .resize(200,120)
                .placeholder(R.drawable.ic_idea_comodin)
                .centerCrop()
                .into(binding.imageList)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameVH {
val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context))
        return GameVH(binding)
    }

    override fun onBindViewHolder(holder: GameVH, position: Int) {
        val game = gameList[position]
        holder.bind(game)

        holder.itemView.setOnClickListener {
            selectedItem.value = game
        }
    }

    override fun getItemCount() = gameList.size

    fun update(gamelist: List<Game>) {
        gameList = gamelist
        notifyDataSetChanged()
    }
}