package xeon.com.youtube.DataAdapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import xeon.com.youtube.ApplicationManager.IntentsManager;
import xeon.com.youtube.Models.News;
import xeon.com.youtube.NewsDetailActivity;
import xeon.com.youtube.R;

/**
 * Created by tayyab on 9/10/18.
 */

public class ReadNewsAdapter extends RecyclerView.Adapter<ReadNewsAdapter.MyViewHolder> {


    public List<News> news;
    private Context mActivity;
    private int lastPosition = -1;

    public ReadNewsAdapter(Context activity, List<News> news) {
        this.mActivity = activity;
        this.news = news;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_data, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.title.setText(news.get(position).Title);
        holder.description.setText(news.get(position).getDescription());
        holder.date.setText(news.get(position).Date);
        holder.url = news.get(position).NewsLink;
        Picasso.get().load(news.get(position).getImageUrl()).centerCrop().resize(150, 150).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public String url;
        private TextView title, description, date;
        private ImageView img;
        private ImageButton share;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
            img = view.findViewById(R.id.newspic);
            date = view.findViewById(R.id.date);
            share = view.findViewById(R.id.githubcard_sharebtn);
            share.setOnClickListener(this);

        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.githubcard_sharebtn) {

                IntentsManager.ShareText(mActivity, url);
                return;


            }

            Intent i = new Intent(v.getContext(), NewsDetailActivity.class);
            Toast.makeText(v.getContext(), url, Toast.LENGTH_LONG).show();
            i.putExtra("Url", url);
            v.getContext().startActivity(i);


        }
    }
}