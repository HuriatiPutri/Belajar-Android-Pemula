package com.example.submission1.utils

import android.content.Context
import com.example.submission1.data.apiservice.ApiService
import com.example.submission1.data.source.remote.response.ResultsItem
import com.example.submission1.data.source.remote.response.ResultsItemTv
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String?{
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        }catch (ex:IOException){
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie() : List<ResultsItem>{
        val fileName = String.format("movie.json")
        val list = ArrayList<ResultsItem>()
        try{
            val result = parsingFileToString(fileName)
            if(result != null){
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("results")
                for(i in 0 until listArray.length()){
                    val course = listArray.getJSONObject(i)

                    val movieId = course.getInt("id")
                    val originalTitle = course.getString("original_title")
                    val posterPath = course.getString("poster_path")
                    val title = course.getString("title")

                    val courseResponse = ResultsItem(originalTitle, title,posterPath, movieId)
                    list.add(courseResponse)
                }
            }
        }catch (e :JSONException){
            e.printStackTrace()
        }

        return list
    }
    fun loadTvShow() : List<ResultsItemTv>{
        val fileName = String.format("tv.json")
        val list = ArrayList<ResultsItemTv>()
        try{
            val result = parsingFileToString(fileName)
            if(result != null){
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("results")
                for(i in 0 until listArray.length()){
                    val course = listArray.getJSONObject(i)

                    val movieId = course.getInt("id")
                    val originalTitle = course.getString("name")
                    val posterPath = course.getString("poster_path")

                    val courseResponse = ResultsItemTv(originalTitle, posterPath, movieId)
                    list.add(courseResponse)
                }
            }
        }catch (e :JSONException){
            e.printStackTrace()
        }

        return list
    }
//
//    fun loadContent(moduleId : String) : ContentResponse{
//        val fileName = String.format("Content_%s.json", moduleId)
//        var contentResponse : ContentResponse? = null
//        try{
//            val result = parsingFileToString(fileName)
//            if(result != null){
//                val responseObject = JSONObject(result)
//                val content = responseObject.getString("content")
//                contentResponse = ContentResponse(moduleId, content)
//            }
//        }catch (e :JSONException){
//            e.printStackTrace()
//        }
//
//        return contentResponse as ContentResponse
//    }

}