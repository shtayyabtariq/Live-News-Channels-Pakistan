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
import java.util.List;

import mopub.xeon.com.mopub.MopubManager;
import xeon.com.youtube.ApplicationManager.Constants;
import xeon.com.youtube.DataAdapters.UpComingMatchesAdapter;
import xeon.com.youtube.Models.UpComingMatches;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUpComingSchedule extends Fragment {


    RecyclerView rv;
    LinearLayoutManager llm;
    List<UpComingMatches> upComingMatchesList;
    UpComingMatchesAdapter upComingMatchesAdapter;

    View v;

    public FragmentUpComingSchedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_up_coming_schedule, container, false);


        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        new Description().execute();


        Toast.makeText(getContext(), "Coming Soon Jobs", Toast.LENGTH_LONG).show();

        MopubManager.LoadBanner(v.findViewById(R.id.adview));

//        rv = view.findViewById(R.id.upcomingmatch_list);
//        llm = new LinearLayoutManager(view.getContext());
//        upComingMatchesList = new ArrayList<>();
//        upComingMatchesAdapter = new UpComingMatchesAdapter(v.getContext(),upComingMatchesList);
//        rv.setLayoutManager(llm);
//        rv.setAdapter(upComingMatchesAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();

        ((MainActivity) getActivity())
                .setActionBarTitle("News Reading");
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
                Document mBlogDocument = Jsoup.connect(Constants.UpComingMatchesURL).get();

                // Using Elements to get the Meta data
                Elements mElementDataSize = mBlogDocument.select("div [class=cb-col-100 cb-col][ng-show=((filtered_category == 0 || filtered_category == 9))]");
                // Locate the content attribute
                int mElementSize = mElementDataSize.size();


                Log.d("Data", mElementDataSize.toString());


                for (int i = 0; i < mElementSize; i++) {


                    UpComingMatches upComingMatches = new UpComingMatches();

                    String Date = mElementDataSize.eq(i).select("div [class=cb-col-33 cb-col cb-mtchs-dy text-bold]").text();
                    String teams = mElementDataSize.eq(i).select("a").attr("title");
                    String location = mElementDataSize.eq(i).select("div[class=cb-font-12 text-gray cb-ovr-flo]").text();
                    String time = mElementDataSize.eq(i).select("div[class=cb-col-40 cb-col cb-mtchs-dy-tm ]").text();


                    upComingMatches.date = Date;
                    upComingMatches.location = location;
                    upComingMatches.team = teams;
                    upComingMatches.time = time;


                    Log.d("Date", "Date" + Date);
                    Log.d("teams", teams);
                    Log.d("location", location);
                    Log.d("time", "time" + time);


                    upComingMatchesList.add(upComingMatches);

                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("exception", e.toString());
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


            upComingMatchesAdapter.notifyDataSetChanged();
        }
    }
}
