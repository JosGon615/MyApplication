package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMovieDisplayBinding
import com.google.gson.Gson

class MovieDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compartir = getSharedPreferences("Movie", MODE_PRIVATE)
        val gson = Gson()
        var movieString = compartir.getString("Movie", "")
        val movie = gson.fromJson(movieString, Movie::class.java)

        binding.textTitulo.text = movie.titulo
        binding.textDuracion.text = movie.duracion.toString()
        binding.textDirector.text = movie.director
        binding.textLanzamiento.text = movie.fecha

        binding.aAdir.setOnClickListener(){
            val editor = compartir.edit()
            movieString = gson.toJson(movie)
            editor.putString("Personaje", movieString)
            editor.apply()

            val intent = Intent(this@MovieDisplayActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.volver2.setOnClickListener(){
            val editor = compartir.edit()
            movieString = gson.toJson(movie)
            editor.putString("Personaje", movieString)
            editor.apply()

            val intent = Intent(this@MovieDisplayActivity, MovieDetailsActivity::class.java)
            startActivity(intent)
        }

    }
}