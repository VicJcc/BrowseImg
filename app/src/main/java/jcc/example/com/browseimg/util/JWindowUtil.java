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

//    public static int getWindowHeight(Context context) {
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        int screenHeight = 0;
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            DisplayMetrics dm = new DisplayMetrics();
//            display.getRealMetrics(dm);
//            screenHeight = dm.heightPixels;
//
//            //或者也可以使用getRealSize方法
////            Point size = new Point();
////            display.getRealSize(size);
////            screenHeight = size.y;
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
//            try {
//                screenHeight = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
//            } catch (Exception e) {
//                DisplayMetrics dm = new DisplayMetrics();
//                display.getMetrics(dm);
//                screenHeight = dm.heightPixels;
//            }
//        }
//        return screenHeight;
//
////        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
//    }

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
