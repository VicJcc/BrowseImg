package jcc.example.com.browseimg.beans;

import android.graphics.Rect;

import java.io.Serializable;

/**
 * Created by jincancan
 */

public class JPhotosInfos implements Serializable {

    private int mHeight;
    private int mWidth;
    private int mLeft;
    private int mTop;

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getLeft() {
        return mLeft;
    }

    public void setLeft(int left) {
        mLeft = left;
    }

    public int getTop() {
        return mTop;
    }

    public void setTop(int top) {
        mTop = top;
    }

    public JPhotosInfos build(Rect rect){
        if(null != rect) {
            this.setHeight(rect.height());
            this.setWidth(rect.width());
            this.setLeft(rect.left);
            this.setTop(rect.top);
        }
        return this;
    }
}
