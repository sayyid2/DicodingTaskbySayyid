package com.example.dicodingtaskbysayyid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPokelist:RecyclerView
    private val list=ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPokelist=findViewById(R.id.rv_PokeList)
        rvPokelist.setHasFixedSize(true)

        list.addAll(getList())
        showRecycle()

    }
    private fun getList():ArrayList<Pokemon>{
        val pokeName=resources.getStringArray(R.array.data_name)
        val pokeDesc=resources.getStringArray(R.array.data_description)
        val pokePic= resources.getStringArray(R.array.data_picture)
        val listPoke=ArrayList<Pokemon>()
        for (i in pokeName.indices){
            val poke=Pokemon(pokeName[i],pokeDesc[i],pokePic[i])
            listPoke.add(poke)
        }
        return listPoke
    }

    private fun showRecycle(){
        rvPokelist.layoutManager=GridLayoutManager(this,2)
        val listPokeAdapter=ListPokeAdapter(list)
        rvPokelist.adapter=listPokeAdapter

        listPokeAdapter.setOnItemClickCallback(object : ListPokeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Pokemon) {
                showSelectedPoke(data)
            }
        })
    }

    private fun showSelectedPoke(pokemon: Pokemon) {

        val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
        intentDetail.putExtra(DetailActivity.EXTRA_POKE, pokemon)
        startActivity(intentDetail)
//        Toast.makeText(this, "Kamu memilih " + pokemon.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.About-> {
                val moveAbout= Intent(this@MainActivity,About::class.java)
                startActivity(moveAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}