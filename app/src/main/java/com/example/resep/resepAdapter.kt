package com.example.resep

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.resep.databinding.ItemResepBinding

class resepAdapter(private val onItemClick: (Resep)-> Unit):RecyclerView.Adapter<resepViewHolder>(){

    private val reseps : MutableList<Resep> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): resepViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemResepBinding.inflate(inflater, parent, false)
        return resepViewHolder(binding)
    }

    override fun onBindViewHolder(holder: resepViewHolder, position: Int) {
        holder.binding.textView.text = reseps[position].title
        holder.binding.imgView.setImageResource(reseps[position].image)

        holder.binding.imgView.setOnClickListener {
            onItemClick(reseps[position])                           //Untuk mengklik gambar supaya ke intent
        }

        holder.binding.favorit.setOnClickListener {
            setLiked(position)                           //Untuk mengklik favorit dan merubah warnanya
        }
        if (reseps[position].isLike) {
            holder.binding.favorit.setColorFilter(ContextCompat.getColor(holder.binding.root.context, R.color.pink))
        } else {
            holder.binding.favorit.clearColorFilter()
        }

        holder.binding.bookmark.setOnClickListener {
            setSave(position)                           //Untuk mengklik BOOKMARK dan merubah warnanya
        }
        if (reseps[position].isSave) {
            holder.binding.bookmark.setColorFilter(ContextCompat.getColor(holder.binding.root.context, R.color.design_default_color_on_secondary))
        } else {
            holder.binding.bookmark.clearColorFilter()
        }

        holder.binding.share.setOnClickListener {
            holder.binding.root.context.sendData(reseps[position])                          //Untuk mengklik share data
        }
    }

    private fun setLiked(position: Int){
        val current = reseps[position]
        reseps[position] = current.copy(isLike = !reseps[position].isLike)
        notifyItemChanged(position)
    }

    private fun setSave(position: Int){
        val current = reseps[position]
        reseps[position] = current.copy(isSave = !reseps[position].isSave)
        notifyItemChanged(position)
    }

    private fun Context.sendData(resep: Resep){
        val sendIntent: Intent = Intent().apply{
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, resep.title)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }


    override fun getItemCount(): Int = reseps.size
    fun submitData(data: List<Resep>) {
        reseps.clear()
        reseps.addAll(data)
        notifyDataSetChanged()
    }

}