package xeon.com.youtube.DataAdapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import xeon.com.youtube.ApplicationManager.Constants;
import xeon.com.youtube.ApplicationManager.IntentsManager;
import xeon.com.youtube.FragmentNewsAlert;
import xeon.com.youtube.Models.NewsUpdates;
import xeon.com.youtube.R;
import xeon.com.youtube.VideoViewActivity;

/**
 * Created by tayyab on 8/25/18.
 */

public class CricketNewsAlertAdapter extends RecyclerView.Adapter<CricketNewsAlertAdapter.MyViewHolder> {


    public List<NewsUpdates> news;
    private Context mActivity;
    private int lastPosition = -1;

    public CricketNewsAlertAdapter(Context activity, List<NewsUpdates> news) {
        this.mActivity = activity;
        this.news = news;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_newsalert, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.title.setText(news.get(position).getDescription());
        holder.videoid = news.get(position).getVideoid();
        holder.url = news.get(position).getUrl();
        Picasso.get().load(news.get(position).getImageurl()).centerCrop().resize(150, 150).into(holder.img);
//        holder.description.setText(news.get(position).getDescription());
//        holder.date.setText(news.get(position).Date);
//        holder.url = news.get(position).NewsLink;
//        Picasso.with(mActivity).load(news.get(position).getImageUrl()).centerCrop().resize(150,150).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public String url;
        public String videoid;
        private TextView title;
        private ImageView img;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = view.findViewById(R.id.title_newsalert);
            img = view.findViewById(R.id.image_newsalert);
            title.setOnClickListener(this);
            img.setOnClickListener(this);
            if (!FragmentNewsAlert.name.equals(Constants.LiveTelecast)) {

                TextView live = view.findViewById(R.id.livenow);
                live.setText("");

            }

            view.findViewById(R.id.sharebtn).setOnClickListener(this);


        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {


            if (v.getId() == R.id.sharebtn) {

                IntentsManager.ShareText(mActivity, "Hey Checkout this video: " + url +
                        "For download App see the this link :  https://play.google.com/store/apps/details?id=" + mActivity.getPackageName()
                );

                return;
            }

            Intent i = new Intent(v.getContext(), VideoViewActivity.class);
            i.putExtra(Constants.VideoId, videoid);
            v.getContext().startActivity(i);


        }
    }
}