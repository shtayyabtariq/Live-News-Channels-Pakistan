package xeon.com.youtube;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mopub.xeon.com.mopub.MopubManager;
import xeon.com.youtube.ApplicationManager.Constants;
import xeon.com.youtube.DataAdapters.CricketNewsAlertAdapter;
import xeon.com.youtube.Models.NewsUpdates;


public class FragmentNewsAlert extends Fragment {


    public static String name;
    RecyclerView recyclerView;
    LinearLayoutManager gridLayoutManager;
    CricketNewsAlertAdapter cricketNewsAlertAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;
    List<NewsUpdates> newsUpdatesList;
    View v;

    public static FragmentNewsAlert newInstance(String parameter) {


        name = parameter;
        Bundle args = new Bundle();
        args.putString(Constants.FragmentParam, parameter);
        FragmentNewsAlert fragment = new FragmentNewsAlert();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment_news_alert, container, false);


        return v;

    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MopubManager.LoadBanner(v.findViewById(R.id.adview));


        newsUpdatesList = new ArrayList<>();
        recyclerView = v.findViewById(R.id.rec_newsalert);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        // int spacingInPixels = getResources().getDimensionPixelSize(R.dimen._10sdp);
//        SpacesItemDecoration itemDecoration = new SpacesItemDecoration(Utility.calculateNoOfColumns(v.getContext()),dpToPx(10),true);
//        recyclerView.addItemDecoration(itemDecoration);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        cricketNewsAlertAdapter = new CricketNewsAlertAdapter(v.getContext(), newsUpdatesList);
        recyclerView.setAdapter(cricketNewsAlertAdapter);


        String child = getArguments().getString(Constants.FragmentParam);


        firebaseDatabase = FirebaseDatabase.getInstance();

        ref = firebaseDatabase.getReference(child);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                NewsUpdates newsUpdates = new NewsUpdates();
                newsUpdates = dataSnapshot.getValue(NewsUpdates.class);
                newsUpdatesList.add(newsUpdates);
                Collections.sort(newsUpdatesList, new Comparator<NewsUpdates>() {
                    @Override
                    public int compare(NewsUpdates o1, NewsUpdates o2) {


                        return o2.getDate().compareToIgnoreCase(o1.getDate());
                    }
                });

                cricketNewsAlertAdapter.notifyDataSetChanged();
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


    @Override
    public void onResume() {
        super.onResume();


        if (name.equals(Constants.LiveTelecast)) {

            ((MainActivity) getActivity())
                    .setActionBarTitle("Live Streaming");

        } else {

            ((MainActivity) getActivity())
                    .setActionBarTitle("News Updates");

        }

    }
}
