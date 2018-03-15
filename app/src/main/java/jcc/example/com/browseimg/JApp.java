package jcc.example.com.browseimg;

import android.app.Application;

/**
 * Created by jincancan on 2018/3/15.
 * Description:
 */

public class JApp extends Application {

    private static JApp instance;

    public static JApp getIns(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
