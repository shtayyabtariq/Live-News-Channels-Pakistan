package xeon.com.youtube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mopub.xeon.com.mopub.ApplicationController;
import mopub.xeon.com.mopub.MopubManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class splashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getApplication().registerActivityLifecycleCallbacks(ApplicationController.getInstance());

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        View v = findViewById(R.id.fullscreen_content);
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        final Handler handler = new Handler();


        final Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);


        MopubManager.Create(new MopubManager.MopubCallback() {
            @Override
            public void onSuccess() {

                MopubManager.LoadIntersitial();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        // Toast.makeText(getApplicationContext(),"it is called",Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        finish();
                        //Do something after 100ms
                        handler.postDelayed(this, 950000);
                    }
                }, 3000);

            }
        });

    }


}
