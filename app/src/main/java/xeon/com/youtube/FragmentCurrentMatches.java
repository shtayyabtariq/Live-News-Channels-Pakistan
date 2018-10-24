package xeon.com.youtube;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xeon.com.youtube.ApplicationManager.Constants;
import xeon.com.youtube.DataAdapters.CurrentMatchesAdapter;
import xeon.com.youtube.Models.CurrentMatches;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCurrentMatches extends Fragment {


    RecyclerView recyclerView;
    LinearLayoutManager llm;
    CurrentMatchesAdapter currentMatchesAdapter;
    List<CurrentMatches> currentMatchesList;


    public FragmentCurrentMatches() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_current_matches, container, false);

        Toast.makeText(view.getContext(), "In Activity", Toast.LENGTH_LONG).show();


        new Description().execute();
        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView = view.findViewById(R.id.currentmatch_list);

        llm = new LinearLayoutManager(view.getContext());

        recyclerView.setLayoutManager(llm);
        currentMatchesList = new ArrayList<>();
        currentMatchesAdapter = new CurrentMatchesAdapter(view.getContext(), currentMatchesList);

        recyclerView.setAdapter(currentMatchesAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("Current Matches");
    }

    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //  mProgressDialog = new ProgressDialog(MainActivity.this);
//            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {


            try {
                // Connect to the web site
                Document mBlogDocument = Jsoup.connect(Constants.CurrentMatchesURL).get();

                // Using Elements to get the Meta data
                Elements mElementDataSize = mBlogDocument.select("body").select("div [class=cb-col cb-col-100 cb-lv-main]");
                // Locate the content attribute
                int mElementSize = mElementDataSize.size();

                //  html.setText(Html.fromHtml(mElementDataSize.toString()));

//                Log.d("Data",mElementDataSize.toString());
//
//                 Log.d("DataSize",String.valueOf(mElementDataSize.size()));


//                Elements elements = mElementDataSize.eq(0);
//                Log.d("firstdatatitle",elements.select("div[class=latest-right]").select("h2").select("a").attr("href").toString());
//
//                Log.d("firstdatatitle",elements.select("div[class=latest-right]").select("h2").select("a").text().toString());
//                Log.d("firstdatadate",elements.select("div[class=latest-right]").select("span[class=latestDate]").text().toString());
//                Log.d("firstdatap",elements.select("div[class=latest-right]").select("p").text().toString());


                for (int i = 0; i < mElementSize; i++) {


                    Elements elements1 = mElementDataSize.eq(i);

                    String title = elements1.select("div h3 a").text();
                    String schedule = elements1.select("div span").text();
                    String Scorecard = elements1.select("div[class=cb-col-100 cb-col cb-schdl]").eq(1).select("div [class=cb-lv-scrs-col text-black]").text();
                    String Result = elements1.select("div[class=cb-col-100 cb-col cb-schdl]").eq(1).select("div [class=cb-lv-scrs-col cb-text-complete]").text();

                    Log.d("title", title);


                    CurrentMatches currentMatches = new CurrentMatches();
                    currentMatches.setTitle(title);
                    currentMatches.setResult(Result);


                    for (int k = 0; k < schedule.split("•").length; k++) {

                        if (k == 0) {

                            currentMatches.setSchedule(schedule.split("•")[k]);
                        } else if (k == 1) {

                            currentMatches.setVenue(schedule.split("•")[k]);

                        }

                        Log.d("scheudle", schedule.split("•")[k]);
                    }

                    for (int z = 0; z < Scorecard.split("•").length; z++) {
                        if (z == 0) {

                            currentMatches.setTeam1scorecard(Scorecard.split("•")[z]);
                        } else if (z == 1) {

                            currentMatches.setTeam2scorecard(Scorecard.split("•")[z]);

                        }


                        currentMatchesList.add(currentMatches);
                        Log.d("Scorecard", Scorecard.split("•")[z]);
                    }

                    // Log.d("Scorecard",Scorecard);
                    Log.d("Result", Result);


                }
            } catch (IOException e) {
//                Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView

//            RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerview);
//
//            DataAdapter mDataAdapter = new DataAdapter(MainActivity.this, newsArrayList);
//            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//            mRecyclerView.setLayoutManager(mLayoutManager);
//            mRecyclerView.setAdapter(mDataAdapter);

//            mProgressDialog.dismiss();


            currentMatchesAdapter.notifyDataSetChanged();
        }
    }

}
