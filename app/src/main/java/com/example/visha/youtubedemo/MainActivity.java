package com.example.visha.youtubedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class MainActivity extends AppCompatActivity {

    private final String YOUTUBE_API = "AIzaSyDJXg1cOna70Jnpz97VMGmkPfW9xn3wx0E";
    //Youtube Listener
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    //declare view
    private YouTubePlayerSupportFragment fragment;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.search_button);
        fragment = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_player);
        initPlayer();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.initialize(YOUTUBE_API, onInitializedListener);
            }
        });


    }

    private void initPlayer() {

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.cueVideo("MY6AkFny-0w");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();

            }
        };

    }
}
