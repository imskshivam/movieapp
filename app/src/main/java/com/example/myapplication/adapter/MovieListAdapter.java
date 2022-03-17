package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewholder> {
    private Context context;
    private List<MovieModel> movieList;

    public MovieListAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<MovieModel> movieList){
        this.movieList=movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieListAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false);
      return new MyViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewholder holder, int position) {
        String name=movieList.get(position).getUsername();
        String email=movieList.get(position).getEmail();
        String pass=movieList.get(position).getPassword();
        holder.setName(name,email,pass);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{

        TextView name,email,pass;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            pass=itemView.findViewById(R.id.pass);
        }

        public void setName(String name1,String email1, String pass1){
            name.setText(name1);
            email.setText(email1);
            name.setText(name1);
        }
    }
}
