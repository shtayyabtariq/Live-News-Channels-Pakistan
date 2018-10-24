package xeon.com.youtube.ViewAdapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import xeon.com.youtube.FragmentReadNews;
import xeon.com.youtube.FragmentUpComingSchedule;

public class FragmentSchedulesAdapter extends FragmentPagerAdapter {

    private static final String TAG = FragmentNewsUpdatesPageAdapter.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 4;


    public FragmentSchedulesAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentReadNews currentMatches = new FragmentReadNews();
                return currentMatches;

            case 1:
                FragmentUpComingSchedule upComingSchedule = new FragmentUpComingSchedule();
                return upComingSchedule;

                /*case 1:
                return new PlaylistFragment();
            case 2:
                return new AlbumFragment();
            case 3:
                return new ArtistFragment();*/
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "News";
            case 1:
                return "Jobs";

        }
        return null;
    }
}
