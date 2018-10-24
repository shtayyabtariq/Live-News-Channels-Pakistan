package xeon.com.youtube.Models;

/**
 * Created by tayyab on 9/5/18.
 */

public class UpComingMatches {

    public String date;
    public String location;
    public String team;
    public String time;

    public UpComingMatches() {
    }

    public UpComingMatches(String date, String location, String team, String time) {
        this.date = date;
        this.location = location;
        this.team = team;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public UpComingMatches setDate(String date) {
        this.date = date;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public UpComingMatches setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getteam() {
        return team;
    }

    public UpComingMatches setteam(String team) {
        this.team = team;
        return this;
    }

    public String getTime() {
        return time;
    }

    public UpComingMatches setTime(String time) {
        this.time = time;
        return this;
    }
}
