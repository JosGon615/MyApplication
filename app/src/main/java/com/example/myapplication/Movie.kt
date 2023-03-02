package com.example.myapplication

class Movie {
    private var titulo = ""
    private var duracion = 0
    private var director = ""
    private var fecha = ""
    private var peliculas = ArrayList<Movie>()

    constructor(titulo: String, duracion: Int, director: String, fecha: String, peliculas: ArrayList<Movie>){
        this.titulo = titulo
        this.duracion = duracion
        this.director = director
        this.fecha = fecha
        this.peliculas = peliculas
    }

    constructor()

    fun getTitulo(): String{
        return titulo
    }

    fun setTitulo(titulo: String){
        this.titulo = titulo
    }

    override fun toString(): String {
        return "Movie(titulo='$titulo', duracion=$duracion, director='$director', fecha='$fecha', peliculas=$peliculas)"
    }




}