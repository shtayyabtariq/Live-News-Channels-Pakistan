package xeon.com.youtube.DataAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xeon.com.youtube.Models.UpComingMatches;
import xeon.com.youtube.R;

/**
 * Created by tayyab on 8/25/18.
 */

public class UpComingMatchesAdapter extends RecyclerView.Adapter<UpComingMatchesAdapter.MyViewHolder> {


    public List<UpComingMatches> currentMatchesAdapterslist;
    private Context mActivity;
    private int lastPosition = -1;

    public UpComingMatchesAdapter(Context activity, List<UpComingMatches> upComingMatchesList) {
        this.mActivity = activity;
        this.currentMatchesAdapterslist = upComingMatchesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_upcoming_matches, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.title.setText(currentMatchesAdapterslist.get(position).date);
        holder.team.setText(currentMatchesAdapterslist.get(position).team);
        holder.time.setText(currentMatchesAdapterslist.get(position).time);
        holder.location.setText(currentMatchesAdapterslist.get(position).location);

    }

    @Override
    public int getItemCount() {
        return currentMatchesAdapterslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title, team, location, time;


        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = view.findViewById(R.id.upcomingmatch_title);
            team = view.findViewById(R.id.upcomingmatch_teams);
            location = view.findViewById(R.id.upcomingmatch_location);
            time = view.findViewById(R.id.upcomingmatch_time);


        }


        @Override
        public void onClick(View v) {


            // IntentsManager.ShareText(mActivity,"Hey Check this video : "+);


        }
    }
}