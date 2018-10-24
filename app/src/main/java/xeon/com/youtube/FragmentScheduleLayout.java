package xeon.com.youtube;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xeon.com.youtube.ViewAdapters.FragmentSchedulesAdapter;


public class FragmentScheduleLayout extends Fragment {

    private static final String TAG = FragmentNewsUpdates.class.getSimpleName();

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public FragmentScheduleLayout() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_updates, container, false);

        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.view_pager);

        viewPager.setAdapter(new FragmentSchedulesAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


}
