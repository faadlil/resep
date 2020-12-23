package com.example.resep

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.resep.databinding.ResepDetailBinding

class resepDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ResepDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resep = BundleParam.fromBundle<Resep>(intent.extras)
        binding.imgRecipe.setImageResource(resep.image)
        binding.txtTitle.text = resep.title
        binding.txtBahan.text = resep.bahan
        binding.txtCara.text = resep.Langkah

    }

}