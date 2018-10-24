package xeon.com.youtube.ViewAdapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import xeon.com.youtube.ApplicationManager.Constants;
import xeon.com.youtube.FragmentNewsAlert;


public class FragmentNewsUpdatesPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = FragmentNewsUpdatesPageAdapter.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 4;


    public FragmentNewsUpdatesPageAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentNewsAlert newsAlert = FragmentNewsAlert.newInstance(Constants.NewsUpdates);
                return newsAlert;

            case 1:
                FragmentNewsAlert highlights = FragmentNewsAlert.newInstance(Constants.Highlights);
                return highlights;

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
                return "Pakistan News";
            case 1:
                return "World Wide News";

        }
        return null;
    }
}
