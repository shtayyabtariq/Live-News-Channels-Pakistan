package xeon.com.youtube.Models;

/**
 * Created by tayyab on 9/5/18.
 */

public class CurrentMatches {

    public String title;
    public String schedule;
    public String venue;
    public String team1scorecard;
    public String team2scorecard;
    public String result;

    public CurrentMatches(String title, String schedule, String venue, String team1scorecard, String team2scorecard, String result) {
        this.title = title;
        this.schedule = schedule;
        this.venue = venue;
        this.team1scorecard = team1scorecard;
        this.team2scorecard = team2scorecard;
        this.result = result;
    }

    public CurrentMatches() {
    }

    public String getTitle() {
        return title;
    }

    public CurrentMatches setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSchedule() {
        return schedule;
    }

    public CurrentMatches setSchedule(String schedule) {
        this.schedule = schedule;
        return this;
    }

    public String getVenue() {
        return venue;
    }

    public CurrentMatches setVenue(String venue) {
        this.venue = venue;
        return this;
    }

    public String getTeam1scorecard() {
        return team1scorecard;
    }

    public CurrentMatches setTeam1scorecard(String team1scorecard) {
        this.team1scorecard = team1scorecard;
        return this;
    }

    public String getTeam2scorecard() {
        return team2scorecard;
    }

    public CurrentMatches setTeam2scorecard(String team2scorecard) {
        this.team2scorecard = team2scorecard;
        return this;
    }

    public String getResult() {
        return result;
    }

    public CurrentMatches setResult(String result) {
        this.result = result;
        return this;
    }
}
