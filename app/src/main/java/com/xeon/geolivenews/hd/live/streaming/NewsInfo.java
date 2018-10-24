package com.xeon.geolivenews.hd.live.streaming;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by tayyab on 8/8/18.
 */

public class NewsInfo {


    public static ArrayList<NewsInfo> newschannels = new ArrayList<>();
    public Drawable d;
    public String name;

    public NewsInfo(Drawable d, String s) {
        this.d = d;
        this.name = s;
    }

    public static void AddChannels(NewsInfo news) {


        newschannels.add(news);

    }
}
