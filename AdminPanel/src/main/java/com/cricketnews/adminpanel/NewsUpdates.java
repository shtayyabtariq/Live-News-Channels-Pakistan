package com.cricketnews.adminpanel;

/**
 * Created by tayyab on 9/1/18.
 */

public class NewsUpdates {

    private String videoid;
    private String description;
    private String date;
    private String url;
    private String imageurl;

    public NewsUpdates(String videoid, String description, String date) {
        this.videoid = videoid;
        this.description = description;
        this.date = date;
    }

    public NewsUpdates(String videoid, String description, String date, String url, String imageurl) {
        this.videoid = videoid;
        this.description = description;
        this.date = date;
        this.url = url;
        this.imageurl = imageurl;
    }

    public NewsUpdates() {
    }

    public String getUrl() {
        return url;
    }

    public NewsUpdates setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getImageurl() {
        return imageurl;
    }

    public NewsUpdates setImageurl(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }

    public String getVideoid() {
        return videoid;
    }

    public NewsUpdates setVideoid(String videoid) {
        this.videoid = videoid;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NewsUpdates setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDate() {
        return date;
    }

    public NewsUpdates setDate(String date) {
        this.date = date;
        return this;
    }
}
