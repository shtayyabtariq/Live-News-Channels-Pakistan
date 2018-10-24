package com.cricketnews.adminpanel;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cricketnews.adminpanel.ApplicationManager.Constants;
import com.cricketnews.adminpanel.ApplicationManager.YouTubeHelper;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    FirebaseDatabase db;
    DatabaseReference ref;

    String node;
    EditText link;
    Spinner list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        link = findViewById(R.id.youtubelink);

        db = FirebaseDatabase.getInstance();
        ref = db.getReference();


        list = findViewById(R.id.dropdown);


        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NewsUpdates newsUpdates = new NewsUpdates();
                String youtubelink = link.getText().toString().trim();
                newsUpdates.setImageurl(YouTubeHelper.getImageUrlQuietly(youtubelink));
                newsUpdates.setDescription(YouTubeHelper.getTitleQuietly(youtubelink));
                newsUpdates.setVideoid(YouTubeHelper.getVideoId(youtubelink));
                newsUpdates.setUrl(youtubelink);
                newsUpdates.setDate(Calendar.getInstance().getTime().toString());

                AddValue(node, newsUpdates);


            }
        });

        String items[] = new String[]{Constants.Highlights, Constants.NewsUpdates, Constants.LiveTelecast};


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set the spinners adapter to the previously created one.
        list.setAdapter(adapter);

        list.setOnItemSelectedListener(this);


        findViewById(R.id.addh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddInsertHighlights();
            }
        });

        findViewById(R.id.addn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddInsertNews();
            }
        });


        findViewById(R.id.addl).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddInsertLive();
            }
        });


    }


    public void AddValue(String link, String node) {

        NewsUpdates newsUpdates = new NewsUpdates();
        String youtubelink = link.trim();

        newsUpdates.setImageurl(YouTubeHelper.getImageUrlQuietly(youtubelink));
        newsUpdates.setDescription(YouTubeHelper.getTitleQuietly(youtubelink));
        newsUpdates.setVideoid(YouTubeHelper.getVideoId(youtubelink));
        newsUpdates.setUrl(youtubelink);
        newsUpdates.setDate(Calendar.getInstance().getTime().toString());


        ref.child(node).child(newsUpdates.getVideoid()).setValue(newsUpdates, new DatabaseReference.CompletionListener() {


            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {

                Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();

            }
        });


    }


    public void AddValue(String node, NewsUpdates newsUpdates) {


//        Log.d("YouTubeTitle", YouTubeHelper.getTitleQuietly("https://www.youtube.com/watch?v=gRJ8F3AZ-40"));
//        Log.d("YouTubeImage",YouTubeHelper.getImageUrlQuietly("https://www.youtube.com/watch?v=gRJ8F3AZ-40"));
//        Log.d("YouTubeVideoId", YouTubeHelper.getVideoId("https://www.youtube.com/watch?v=gRJ8F3AZ-40"));
//
//
//        NewsUpdates newsUpdates = new NewsUpdates(YouTubeHelper.getVideoId("https://www.youtube.com/watch?v=gRJ8F3AZ-40"),YouTubeHelper.getTitleQuietly("https://www.youtube.com/watch?v=gRJ8F3AZ-40"), Calendar.getInstance().getTime().toString(),"https://www.youtube.com/watch?v=gRJ8F3AZ-40",YouTubeHelper.getImageUrlQuietly("https://www.youtube.com/watch?v=gRJ8F3AZ-40"));
//


        ref.child(node).child(newsUpdates.getVideoid()).setValue(newsUpdates, new DatabaseReference.CompletionListener() {


            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {

                Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        node = adapter.getItem(position);
        Toast.makeText(getApplicationContext(), node, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * Called when pointer capture is enabled or disabled for the current window.
     *
     * @param hasCapture True if the window has pointer capture.
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void AddInsertLive() {

        ref.child(Constants.insertlive).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                String link = dataSnapshot.getValue().toString();
                AddValue(link, Constants.LiveTelecast);
                Toast.makeText(getApplicationContext(), "Data Inserted" + link, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    public void AddInsertHighlights() {

        ref.child(Constants.inserthighlights).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                String link = dataSnapshot.getValue().toString();
                AddValue(link, Constants.Highlights);
                Toast.makeText(getApplicationContext(), "Data Inserted" + link, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    public void AddInsertNews() {


        ref.child(Constants.insertnewsupdates).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                String link = dataSnapshot.getValue().toString();
                AddValue(link, Constants.NewsUpdates);
                Toast.makeText(getApplicationContext(), "Data Inserted" + link, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
