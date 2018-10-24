package xeon.com.youtube;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

import mopub.xeon.com.mopub.ApplicationController;
import mopub.xeon.com.mopub.MopubManager;
import xeon.com.youtube.ApplicationManager.Constants;


public class VideoViewActivity extends AppCompatActivity {
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().registerActivityLifecycleCallbacks(ApplicationController.getInstance());


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        String videoid = getIntent().getStringExtra(Constants.VideoId);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);


        Initializeyoutube(videoid);


        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // Toast.makeText(getApplicationContext(),"it is called",Toast.LENGTH_LONG).show();
                MopubManager.ShowIntersitial();
                MopubManager.LoadIntersitial();
                //Do something after 100ms
                handler.postDelayed(this, 950000);
            }
        }, 5000);
    }


    public void Initializeyoutube(final String videoId) {

        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull final YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {

                        initializedYouTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }
        }, true);

        // youTubePlayerView.enterFullScreen();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
