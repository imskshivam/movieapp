package com.example.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.MovieModel;
import com.example.myapplication.network.APIservice;
import com.example.myapplication.network.Retrofitinstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movieList;

    public MovieListViewModel() {
        movieList=new MutableLiveData<>();
    }
    public  MutableLiveData<List<MovieModel>> getMovieListObserver(){
        return movieList;
    }

    public void makeapicall(){
        APIservice apIservice= Retrofitinstance.getRetrofitClient().create(APIservice.class);
        Call<List<MovieModel>> call= apIservice.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movieList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }
}
