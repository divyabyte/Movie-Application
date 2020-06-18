package com.example.movieapp.utils;

import com.example.movieapp.Models.Movie;
import com.example.movieapp.R;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Movie> getPopularMovies()
    {

        List<Movie> listMovie = new ArrayList<>();
        listMovie.add(new Movie("Iron Man", R.drawable.im,R.drawable.fb));
        listMovie.add(new Movie("Fantastic Beats",R.drawable.fb,R.drawable.fb));
        listMovie.add(new Movie("Money Heist",R.drawable.mh,R.drawable.fb));
        listMovie.add(new Movie("Martian",R.drawable.martian,R.drawable.fb));
        listMovie.add(new Movie("Joker",R.drawable.j,R.drawable.fb));
        listMovie.add(new Movie("Martian",R.drawable.martian,R.drawable.fb));

        return listMovie;

    }

    public static List<Movie> getWeekMovies()
    {
        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie("Iron Man", R.drawable.im,R.drawable.fb));
        lstMovie.add(new Movie("Iron Man",R.drawable.martian,R.drawable.fb));
        lstMovie.add(new Movie("Iron Man",R.drawable.im,R.drawable.fb));
        lstMovie.add(new Movie("Iron Man",R.drawable.martian,R.drawable.fb));
        lstMovie.add(new Movie("Iron Man",R.drawable.mh,R.drawable.fb));
        lstMovie.add(new Movie("Iron Man",R.drawable.fb,R.drawable.fb));

        return lstMovie;
    }
}
