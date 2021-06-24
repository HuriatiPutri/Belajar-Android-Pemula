package com.example.submission1.data.apiservice

class ApiHelper(private val apiService: ApiService) {
    val APIKEY = "9002eea5e03b905cf981e82dffcc1630"

    fun getMovie()  = apiService.getMovies(APIKEY, "EN",1)
}