package xeon.com.youtube;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import mopub.xeon.com.mopub.MopubManager;
import xeon.com.youtube.DataAdapters.ReadNewsAdapter;
import xeon.com.youtube.Models.News;

public class FragmentReadNews extends Fragment {

    public View view;
    private ProgressDialog mProgressDialog;
    private String url = "https://www.thenews.com.pk/latest-stories/1/50";
    private ArrayList<News> newsArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_readnews, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.view = view;


        new Description().execute();
        MopubManager.LoadBanner(view.findViewById(R.id.adview));
        MopubManager.ShowIntersitial();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                MopubManager.LoadIntersitial();
                MopubManager.ShowIntersitial();
            }
        }, 115000);
    }


    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {


            try {
                // Connect to the web site
                Document mBlogDocument = Jsoup.connect(url).get();

                // Using Elements to get the Meta data
                Elements mElementDataSize = mBlogDocument.select("body").select("li");
                // Locate the content attribute
                int mElementSize = mElementDataSize.size();


                Log.d("Data", String.valueOf(mElementDataSize));


//                Elements elements = mElementDataSize.eq(0);
//                Log.d("firstdatatitle",elements.select("div[class=latest-right]").select("h2").select("a").attr("href").toString());
//
//                Log.d("firstdatatitle",elements.select("div[class=latest-right]").select("h2").select("a").text().toString());
//                Log.d("firstdatadate",elements.select("div[class=latest-right]").select("span[class=latestDate]").text().toString());
//                Log.d("firstdatap",elements.select("div[class=latest-right]").select("p").text().toString());


                for (int i = 0; i < mElementSize; i++) {


                    News news = new News();

                    Elements elements = mElementDataSize.eq(i);
                    news.setTitle(elements.select("div").select("h2").select("a").text());
                    news.setDescription(elements.select("div").select("p").text());
                    news.setImageUrl(elements.select("div").select("a").select("img").attr("src"));
                    news.Date = elements.select("div").select("span[class=latestDate]").text();
                    news.NewsLink = elements.select("a").attr("href");
                    newsArrayList.add(news);
                    Log.d("firstdatatitle", elements.select("a").attr("href"));

                    Log.d("firstdatatitle", elements.select("div").select("h2").select("a").text());
                    Log.d("firstdatadate", elements.select("div").select("span[class=latestDate]").text());
                    Log.d("firstdatap", elements.select("div").select("p").text());

//                    Elements mElementAuthorName = mBlogDocument.select("span[class=vcard author post-author test]").select("a").eq(i);
//                    String mAuthorName = mElementAuthorName.text();
//
//                    Elements mElementBlogUploadDate = mBlogDocument.select("span[class=post-date updated]").eq(i);
//                    String mBlogUploadDate = mElementBlogUploadDate.text();
//
//                    Elements mElementBlogTitle = mBlogDocument.select("h2[class=entry-title]").select("a").eq(i);
//                    String mBlogTitle = mElementBlogTitle.text();
//
//                    mAuthorNameList.add(mAuthorName);
//                    mBlogUploadDateList.add(mBlogUploadDate);
//                    mBlogTitleList.add(mBlogTitle);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView

            RecyclerView mRecyclerView = view.findViewById(R.id.act_recyclerview);

            ReadNewsAdapter mDataAdapter = new ReadNewsAdapter(view.getContext(), newsArrayList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mDataAdapter);

//            mProgressDialog.dismiss();
        }
    }
}