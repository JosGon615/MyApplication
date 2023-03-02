package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = Movie()
        val titulo = binding.titulo.text.toString()
        val duracion = binding.duracion.text.toString().toInt()

        movie.setTitulo(titulo)

        binding.continuar.setOnClickListener(){
            if(binding.duracion.text.toString().toInt() < 0){
                movie.duracion = duracion
            }else{
                val compartir = getSharedPreferences("Movie", MODE_PRIVATE)
                val editor = compartir.edit()
                val gson = Gson()
                val movieString = gson.toJson(movie)
                editor.putString("Movie", movieString)
                editor.apply()

                val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
                startActivity(intent)
            }


        }

    }
}