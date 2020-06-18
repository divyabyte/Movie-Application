package com.example.movieapp.adapters;

import android.widget.ImageView;

import com.example.movieapp.Models.Movie;

public interface MovieItemClickListener {

    void onMovieClick(Movie movie, ImageView movieImageView);
}
