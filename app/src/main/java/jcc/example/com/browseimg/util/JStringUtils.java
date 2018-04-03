package jcc.example.com.browseimg.util;

/**
 * Created by JCC
 */
public class JStringUtils {

    public static String getBlackAlphaBg(float alpha){
        if(alpha >= 1){
            alpha = 1f;
        }
        if(alpha <= 0){
            alpha = 0.0f;
        }
        String colorAlpha = Integer.toHexString((int) (255 * alpha));
        if(colorAlpha.length() == 1){
            colorAlpha = "0" + colorAlpha;
        }
        if(colorAlpha.length() == 0){
            colorAlpha = "00";
        }
        return "#" + colorAlpha + "000000";
    }
}
