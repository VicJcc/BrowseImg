/*
 * Copyright (C) 2014 pengjianbo(pengjianbosoft@gmail.com), Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package jcc.example.com.browseimg.third.widget.zoonview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import jcc.example.com.browseimg.third.widget.GFImageView;
import jcc.example.com.browseimg.util.JWindowUtil;


public class PhotoView extends GFImageView implements IPhotoView {
    
    private static final String TAG = "PhotoView";

    private PhotoViewAttacher mAttacher;

    private ImageView.ScaleType mPendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public PhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        init();
    }

    protected void init() {
        if (null == mAttacher || null == mAttacher.getImageView()) {
            mAttacher = new PhotoViewAttacher(this);
        }

        if (null != mPendingScaleType) {
            setScaleType(mPendingScaleType);
            mPendingScaleType = null;
        }
    }

    /**
     * @deprecated use {@link #setRotationTo(float)}
     */
    @Override
    public void setPhotoViewRotation(float rotationDegree) {
        mAttacher.setRotationTo(rotationDegree);
    }

    @Override
    public void setRotationTo(float rotationDegree) {
        mAttacher.setRotationTo(rotationDegree);
    }

    @Override
    public void setRotationBy(float rotationDegree) {
        mAttacher.setRotationBy(rotationDegree);
    }

    @Override
    public boolean isScaling() {
        return mAttacher.isScaling();
    }

    @Override
    public boolean canZoom() {
        return mAttacher.canZoom();
    }

    @Override
    public RectF getDisplayRect() {
        return mAttacher.getDisplayRect();
    }

    @Override
    public Matrix getDisplayMatrix() {
        return mAttacher.getDisplayMatrix();
    }

    @Override
    public boolean setDisplayMatrix(Matrix finalRectangle) {
        return mAttacher.setDisplayMatrix(finalRectangle);
    }

    @Override
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override
    public float getMinimumScale() {
        return mAttacher.getMinimumScale();
    }

    @Override
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override
    public float getMediumScale() {
        return mAttacher.getMediumScale();
    }

    @Override
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override
    public float getMaximumScale() {
        return mAttacher.getMaximumScale();
    }

    @Override
    public float getScale() {
        return mAttacher.getScale();
    }

    @Override
    public ImageView.ScaleType getScaleType() {
        return mAttacher.getScaleType();
    }

    @Override
    public void setAllowParentInterceptOnEdge(boolean allow) {
        mAttacher.setAllowParentInterceptOnEdge(allow);
    }

    @Override
    @Deprecated
    public void setMinScale(float minScale) {
        setMinimumScale(minScale);
    }

    @Override
    public void setMinimumScale(float minimumScale) {
        mAttacher.setMinimumScale(minimumScale);
    }

    @Override
    @Deprecated
    public void setMidScale(float midScale) {
        setMediumScale(midScale);
    }

    @Override
    public void setMediumScale(float mediumScale) {
        mAttacher.setMediumScale(mediumScale);
    }

    @Override
    @Deprecated
    public void setMaxScale(float maxScale) {
        setMaximumScale(maxScale);
    }

    @Override
    public void setMaximumScale(float maximumScale) {
        mAttacher.setMaximumScale(maximumScale);
    }

    @Override
    public void setScaleLevels(float minimumScale, float mediumScale, float maximumScale) {
        mAttacher.setScaleLevels(minimumScale, mediumScale, maximumScale);
    }

    @Override
    // setImageBitmap calls through to this method
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (null != mAttacher) {
            mAttacher.update();
        }
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        if (null != mAttacher) {
            mAttacher.update();
        }
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (null != mAttacher) {
            mAttacher.update();
        }
    }

    @Override
    public void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener listener) {
        mAttacher.setOnMatrixChangeListener(listener);
    }

    @Override
    public void setOnLongClickListener(View.OnLongClickListener l) {
        mAttacher.setOnLongClickListener(l);
    }

    @Override
    public void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener listener) {
        mAttacher.setOnPhotoTapListener(listener);
    }

    @Override
    public PhotoViewAttacher.OnPhotoTapListener getOnPhotoTapListener() {
        return mAttacher.getOnPhotoTapListener();
    }

    @Override
    public void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener listener) {
        mAttacher.setOnViewTapListener(listener);
    }

    @Override
    public PhotoViewAttacher.OnViewTapListener getOnViewTapListener() {
        return mAttacher.getOnViewTapListener();
    }

    @Override
    public void setScale(float scale) {
        mAttacher.setScale(scale);
    }

    @Override
    public void setScale(float scale, boolean animate) {
        mAttacher.setScale(scale, animate);
    }

    @Override
    public void setScale(float scale, float focalX, float focalY, boolean animate) {
        mAttacher.setScale(scale, focalX, focalY, animate);
    }

    @Override
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (null != mAttacher) {
            mAttacher.setScaleType(scaleType);
        } else {
            mPendingScaleType = scaleType;
        }
    }

    @Override
    public void setZoomable(boolean zoomable) {
        mAttacher.setZoomable(zoomable);
    }

    @Override
    public Bitmap getVisibleRectangleBitmap() {
        return mAttacher.getVisibleRectangleBitmap();
    }

    @Override
    public void setZoomTransitionDuration(int milliseconds) {
        mAttacher.setZoomTransitionDuration(milliseconds);
    }

    @Override
    public IPhotoView getIPhotoViewImplementation() {
        return mAttacher;
    }

    @Override
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener newOnDoubleTapListener) {
        mAttacher.setOnDoubleTapListener(newOnDoubleTapListener);
    }

    @Override
    public void setOnScaleChangeListener(PhotoViewAttacher.OnScaleChangeListener onScaleChangeListener) {
        mAttacher.setOnScaleChangeListener(onScaleChangeListener);
    }

    @Override
    public void setOnViewDragListener(PhotoViewAttacher.OnViewDragListener onViewDragListener) {
        mAttacher.setOnViewDragListener(onViewDragListener);
    }

    @Override
    protected void onDetachedFromWindow() {
//        mAttacher.cleanup();
        super.onDetachedFromWindow();
    }

    @Override
    protected void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }





    private float mScale = 0.3f; // 图片缩放比例

    private float mPressX;
    private float mPressY;

    private boolean bHasMoveMore;

    public void onMove(float dx, float dy) {
        Log.i(TAG, "onTouchEvent");
//            case MotionEvent.ACTION_MOVE:
                float diffX = dx;
                float diffY = dy;
                Log.i(TAG, diffX + "  " + diffY);

                if(Math.abs(diffY) > 10 && !bHasMoveMore){ // Y轴移动大于10 当做移动事件处理
                    bHasMoveMore = true;
                }

                if(!bHasMoveMore){
                    return;
                }

                setTranslationX(diffX);
                setTranslationY(diffY);
                setBackgroundColor(Color.parseColor(getAlphaBg(1 - diffY / JWindowUtil.getWindowHeight(getContext()))));
//                setScaleX(1 - Math.abs(diffX) / JWindowUtil.getWindowWidth(this));
                float scale = Math.abs(diffY) / JWindowUtil.getWindowHeight(getContext());
                if(scale < 1 && scale > 0) {
                    setScaleY(1 - scale);
                    setScaleX(1 - scale);
                }
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//
//                Log.v(TAG,  "ACTION_UP  "
//                        + getScaleX() + "  "
//                        + getTranslationX() + "  "
//                        + getTranslationY() + "  "
//                );
//
//                float diffYfinal = event.getRawY() - mPressY;
//
//                if(Math.abs(diffYfinal) < 10 && !bHasMoveMore){
//                    startEndAnim();
//                    bHasMoveMore = false;
//                    return;
//                }
//
//                if(diffYfinal < 600) {
//                    setTranslationX(0);
//                    setTranslationY(0);
//                    setBackgroundColor(Color.parseColor(getAlphaBg(1)));
//                    setScaleX(1.0f);
//                    setScaleY(1.0f);
//                }else {
//                    startEndAnim();
//                }
//                bHasMoveMore = false;
    }


    public void up(float dy){
        Log.v(TAG,  "ACTION_UP  "
                + getScaleX() + "  "
                + getTranslationX() + "  "
                + getTranslationY() + "  "
        );

        float diffYfinal = dy;

        if(Math.abs(diffYfinal) < 10 && !bHasMoveMore){
            startEndAnim();
            bHasMoveMore = false;
            return;
        }

        if(diffYfinal < 600) {
            setTranslationX(0);
            setTranslationY(0);
            setBackgroundColor(Color.parseColor(getAlphaBg(1)));
            setScaleX(1.0f);
            setScaleY(1.0f);
        }else {
            startEndAnim();
        }
        bHasMoveMore = false;
    }

    public void startImgAnim(int height, int width, int localX, int localY){

        float pivotX;
        float pivotY;
        float animImgStartHeight;
        float animImgStartWidth;

        float windowScale = JWindowUtil.getWindowScale(getContext());
        float imgScale = getImgScale(width, height);

        if(imgScale >= windowScale){
            mScale = width * 1.0f / JWindowUtil.getWindowWidth(getContext());
            animImgStartHeight = JWindowUtil.getWindowHeight(getContext()) * mScale;
            pivotX = localX / (1 - mScale);
            pivotY = (localY - (animImgStartHeight - height) / 2) / (1 - mScale);
        }else{
            mScale = height * 1.0f / JWindowUtil.getWindowHeight(getContext());
            animImgStartWidth = JWindowUtil.getWindowWidth(getContext()) * mScale;
            pivotX = (localX - (animImgStartWidth - width) / 2) / (1 - mScale);
            pivotY = localY / (1 - mScale);
        }

        setPivotX(pivotX);
        setPivotY(pivotY);

        Log.d(TAG, getPivotX() + "  " + getPivotY());
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, SCALE_X,
                mScale,
                1.0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, SCALE_Y,
                mScale,
                1.0f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY);
        set.setDuration(300);
        set.start();

        AlphaAnimation alphaAnimation = new AlphaAnimation(mScale, 1f);
        alphaAnimation.setDuration(300);
        startAnimation(alphaAnimation);

    }

    public void startEndAnim(){
        setBackgroundColor(Color.parseColor(getAlphaBg(0)));

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(this, SCALE_X,
                getScaleX(),
                mScale);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(this, SCALE_Y,
                getScaleY(),
                mScale);

        ObjectAnimator animatorTransX = ObjectAnimator.ofFloat(this, TRANSLATION_X,
                getTranslationX(),
                0f);
        ObjectAnimator animatorTransY = ObjectAnimator.ofFloat(this, TRANSLATION_Y,
                getTranslationY(),
                0f);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY, animatorTransX, animatorTransY);
        set.setDuration(300);
        set.start();

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                if(mCallback != null){
//                    mCallback.needDismiss();
//                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private float getImgScale(float width, float height){
        return width * 1.0f / height;
    }

    private String getAlphaBg(float alpha){
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