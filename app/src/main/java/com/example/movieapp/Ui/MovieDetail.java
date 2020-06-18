package com.example.movieapp.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.Models.Cast;
import com.example.movieapp.R;
import com.example.movieapp.adapters.CastAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetail extends AppCompatActivity {

    private ImageView MovieThumbnailImg,MovieCoverImg;
    private TextView tv_title,tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        iniViews();
        setUpRvCast();
    }

    private void setUpRvCast() {
        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("Tony Shark",R.drawable.tony));
        mdata.add(new Cast("Scarlett",R.drawable.scarlett));
        mdata.add(new Cast("Elon Musk",R.drawable.elon));
        mdata.add(new Cast("Gwyneth",R.drawable.gwyneth));
        mdata.add(new Cast("Tony",R.drawable.tony));
        mdata.add(new Cast("Tony",R.drawable.tony));

        castAdapter = new CastAdapter(this,mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }

    void iniViews() {
        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        // setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.scale_animation));





    }
}
