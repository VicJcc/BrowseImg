package jcc.example.com.browseimg.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;


/**
 *  Created by jincancan
 */
public class JWindowUtil {

    public static int getWindowHeight(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWindowWidth(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusHeight(Activity mActivity){
        DisplayMetrics metric = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        Display disp = mActivity.getWindowManager().getDefaultDisplay();
        Point outP = new Point();
        disp.getRealSize(outP);
        return outP.y - metric.heightPixels;
    }

    public static float getWindowScale(Context context){
        return getWindowWidth(context) * 1.0f / getWindowHeight(context);
    }

}
