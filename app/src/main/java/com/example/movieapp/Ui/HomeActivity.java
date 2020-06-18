package com.example.movieapp.Ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movieapp.Models.Movie;
import com.example.movieapp.Models.slide;
import com.example.movieapp.R;
import com.example.movieapp.adapters.MovieAdapter;
import com.example.movieapp.adapters.MovieItemClickListener;
import com.example.movieapp.adapters.SliderPagerAdapter;
import com.example.movieapp.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {


    private List<slide> list;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RecyclerView rv,rv_week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
        initSlides();
        intPopularMovies();
        intWeekMovies();

    }

    private void intWeekMovies() {


        MovieAdapter weekMovieAdapter = new MovieAdapter(this, DataSource.getWeekMovies(),this);
        rv_week.setAdapter(weekMovieAdapter);
        rv_week.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false ));
    }

    private void intPopularMovies() {
        //recycler

        MovieAdapter movieAdapter = new MovieAdapter(this, DataSource.getPopularMovies(),this);
        rv.setAdapter(movieAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false ));
    }

    private void initSlides() {
        list = new ArrayList<>();
        list.add(new slide(R.drawable.im ,"Iron Man \nMovie"));
        list.add(new slide(R.drawable.j ,"Joker \nMovie"));
        list.add(new slide(R.drawable.mh,"Money Heist \nSeries"));
        list.add(new slide(R.drawable.fb ,"Fantastic Beast \nMovie"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,list);
        viewPager.setAdapter(adapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new slider(),4000,6000);

        tabLayout.setupWithViewPager(viewPager,true);
    }

    private void initviews() {

        viewPager = findViewById(R.id.slider_pager);
        tabLayout = findViewById(R.id.indicator);
        rv = findViewById(R.id.Rv_movies);
        rv_week = findViewById(R.id.Rv_movies_week);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {

        Intent intent = new Intent(this,MovieDetail.class);
        // send movie information to deatilActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                movieImageView,"sharedName");

        startActivity(intent,options.toBundle());



        // i l make a simple test to see if the click works

        Toast.makeText(this,"item clicked : " + movie.getTitle(),Toast.LENGTH_LONG).show();
        // it works great

    }

    class slider extends TimerTask{

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()<list.size()-1)
                    {
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else {
                        viewPager.setCurrentItem(0 );
                    }
                }
            });
        }
    }
}
