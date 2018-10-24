package xeon.com.youtube.ApplicationManager;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by tayyab on 9/7/18.
 */

public class Utility {

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 160);
        return noOfColumns;
    }
}
