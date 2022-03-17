package com.example.myapplication.network;

import com.example.myapplication.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIservice {

    @GET("/find")
    Call<List<MovieModel>> getMovieList();
}
