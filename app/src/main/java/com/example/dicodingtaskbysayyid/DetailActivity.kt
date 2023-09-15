package com.example.dicodingtaskbysayyid

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.activity_detail)
        val pokemon = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Pokemon>(EXTRA_POKE, Pokemon::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Pokemon>(EXTRA_POKE)
        }
        val tvDetailName:TextView = findViewById(R.id.name_poke)
        val tvDetailDescription:TextView = findViewById(R.id.desc_poke)
        val ivDetailPhoto:ImageView = findViewById(R.id.picture_poke)

        if (pokemon!=null){
            tvDetailName.text = pokemon.name
            tvDetailDescription.text = pokemon.description
            Glide.with(this).load(pokemon.picture).centerCrop().into(ivDetailPhoto)
        }
        super.onCreate(savedInstanceState)
    }

    companion object {
        val EXTRA_POKE= "extra_poke"
    }


}



