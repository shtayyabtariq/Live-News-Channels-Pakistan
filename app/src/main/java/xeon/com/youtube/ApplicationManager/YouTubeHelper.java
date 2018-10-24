package xeon.com.youtube.ApplicationManager;

import android.net.Uri;
import android.os.StrictMode;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;


/**
 * Created by tayyab on 9/2/18.
 */

public class YouTubeHelper {


    public static String getImageUrlQuietly(String youtubeUrl) {
        try {
            if (youtubeUrl != null) {
                return String.format("http://img.youtube.com/vi/%s/0.jpg", Uri.parse(youtubeUrl).getQueryParameter("v"));
            }
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getVideoId(String youtubeUrl) {
        try {
            if (youtubeUrl != null) {
                return Uri.parse(youtubeUrl).getQueryParameter("v");
            }
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
        return null;


    }

    public static String getTitleQuietly(String youtubeUrl) {
        try {
            if (youtubeUrl != null) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);

                URL embededURL = new URL("http://www.youtube.com/oembed?url=" + youtubeUrl + "&format=json");


                return new JSONObject(IOUtils.toString(embededURL)).getString("title");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
