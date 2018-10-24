package xeon.com.youtube.DataAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import xeon.com.youtube.Models.CurrentMatches;
import xeon.com.youtube.R;

/**
 * Created by tayyab on 8/25/18.
 */

public class CurrentMatchesAdapter extends RecyclerView.Adapter<CurrentMatchesAdapter.MyViewHolder> {


    public List<CurrentMatches> currentMatchesAdapterslist;
    private Context mActivity;
    private int lastPosition = -1;

    public CurrentMatchesAdapter(Context activity, List<CurrentMatches> currentMatchesAdapters) {
        this.mActivity = activity;
        this.currentMatchesAdapterslist = currentMatchesAdapters;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_current_matches, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.title.setText(currentMatchesAdapterslist.get(position).getTitle());
        holder.venue.setText(currentMatchesAdapterslist.get(position).getVenue());
        holder.scorecard1.setText(currentMatchesAdapterslist.get(position).getTeam1scorecard());
        holder.scorecard2.setText(currentMatchesAdapterslist.get(position).getTeam2scorecard());
        holder.result.setText(currentMatchesAdapterslist.get(position).getResult());
        holder.match.setText(currentMatchesAdapterslist.get(position).getSchedule());

    }

    @Override
    public int getItemCount() {
        return currentMatchesAdapterslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title, result, scorecard1, scorecard2, venue, match;


        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = view.findViewById(R.id.currentmatch_title);
            result = view.findViewById(R.id.currentmatch_result);
            scorecard1 = view.findViewById(R.id.currentmatch_scorecard1);
            scorecard2 = view.findViewById(R.id.currentmatch_scorecard2);
            venue = view.findViewById(R.id.currentmatch_venue);
            match = view.findViewById(R.id.currentmatch_match);


        }


        @Override
        public void onClick(View v) {


        }
    }
}