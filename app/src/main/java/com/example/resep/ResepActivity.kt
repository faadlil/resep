package com.example.resep

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resep.databinding.ActivityMainBinding

class ResepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val padding = resources.getDimensionPixelSize(R.dimen.padding) / 4

        val onItemClick = { resep : Resep ->                                    //INTENT DETAIL
            val intent = Intent(this, resepDetail::class.java)
            resep.toBundle(intent)

            startActivity(intent)
        }

        binding.recycleView.run {
            addItemDecoration(ItemDecoration(padding))
            layoutManager = GridLayoutManager(this@ResepActivity,2)
            adapter = resepAdapter(onItemClick).apply {
                submitData(data())
            }
        }
    }



    private fun data() = listOf(
            Resep(
                    title = "Rendang",
                    image = R.drawable.resep2,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Sate Padang",
                    image = R.drawable.resep3,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Gado-gado",
                    image = R.drawable.resep4,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Bikang Ambon",
                    image = R.drawable.resep5,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Rendang",
                    image = R.drawable.resep2,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Sate Padang",
                    image = R.drawable.resep3,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Gado-gado",
                    image = R.drawable.resep4,
                    isLike = false,
                    isSave = false
            ),
            Resep(
                    title = "Bikang Ambon",
                    image = R.drawable.resep5,
                    isLike = false,
                    isSave = false
            )
    )
}



