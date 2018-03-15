package jcc.example.com.browseimg.util;

import android.content.Context;

import jcc.example.com.browseimg.beans.JPhotosInfos;


/**
 * Created by Jincancan.
 */
public class JBitmapUtils {

    public static float getImgScale(float width, float height){
        return width * 1.0f / height;
    }

    public static float getCurrentPicOriginalScale(Context context, JPhotosInfos infos){

        float mScale;

        int width = infos.getWidth();
        int height = infos.getHeight();

        float imgScale = JBitmapUtils.getImgScale(width, height);
        float mWindowScale = JWindowUtil.getWindowScale(context);

        if(imgScale >= mWindowScale){
            mScale = width * 1.0f / JWindowUtil.getWindowWidth(context);
        }else{
            mScale = height * 1.0f / JWindowUtil.getWindowHeight(context);
        }
        return mScale;
    }
}
