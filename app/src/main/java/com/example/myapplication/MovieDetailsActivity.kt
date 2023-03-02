package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMovieDetailsBinding
import com.google.gson.Gson

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Movie", MODE_PRIVATE)
        val gson = Gson()
        var movieString = compartir.getString("Movie", "")
        val movie = gson.fromJson(movieString, Movie::class.java)

        val peli = Movie(movie.titulo, movie.duracion, movie.director, movie.fecha, movie.peliculas)
        movie.director = binding.director.toString()
        movie.fecha = binding.fecha.toString()

        movie.peliculas.add(peli)

        binding.continuar.setOnClickListener(){
            val editor = compartir.edit()
            movieString = gson.toJson(movie)
            editor.putString("Personaje", movieString)
            editor.apply()

            val intent = Intent(this@MovieDetailsActivity, MovieDisplayActivity::class.java)
            startActivity(intent)
        }

        binding.volver.setOnClickListener(){
            val editor = compartir.edit()
            movieString = gson.toJson(movie)
            editor.putString("Personaje", movieString)
            editor.apply()

            val intent = Intent(this@MovieDetailsActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}