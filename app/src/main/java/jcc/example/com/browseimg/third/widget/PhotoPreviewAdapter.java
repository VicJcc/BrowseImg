package jcc.example.com.browseimg.third.widget;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import jcc.example.com.browseimg.R;
import jcc.example.com.browseimg.third.beans.PhotoInfo;
import jcc.example.com.browseimg.third.widget.zoonview.PhotoView;
import jcc.example.com.browseimg.third.widget.zoonview.PhotoViewAttacher;
import jcc.example.com.browseimg.third.widget.zoonview.ViewHolderRecyclingPagerAdapter;
import jcc.example.com.browseimg.util.JImageShowUtil;


/**
 * Desction:
 * Author:pengjianbo
 * Date:2015/12/29 0029 15:53
 */
public class PhotoPreviewAdapter extends ViewHolderRecyclingPagerAdapter<PhotoPreviewAdapter.PreviewViewHolder, PhotoInfo> {

    private Activity mActivity;
    private PhotoCallback mCallback;

    public PhotoPreviewAdapter(Activity activity, List<PhotoInfo> list, PhotoCallback callback) {
        super(activity, list);
        this.mActivity = activity;
        mCallback = callback;
    }

    @Override
    public PreviewViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = getLayoutInflater().inflate(R.layout.item_preview_img, null);
        return new PreviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PreviewViewHolder holder, int position) {
        PhotoInfo photoInfo = getDatas().get(position);
//        String path = "";
//        if (photoInfo != null) {
//            path = photoInfo.getPhotoPath();
//        }
        String path = photoInfo.getPhotoPath();
        if(path.startsWith("http")) {
            JImageShowUtil.displayImageScale(path, "", holder.mImageView, null);
        }else{
            int source = 0;
            try{
                source = Integer.valueOf(path);
                JImageShowUtil.displayImageScale(source, "", holder.mImageView, null);
            }catch (NumberFormatException e){
                JImageShowUtil.displayImage(path, holder.mImageView, true);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onPhotoClick();
            }
        });
        holder.mImageView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                if(mCallback != null){
                    mCallback.onPhotoClick();
                }
            }
        });

        holder.mImageView.setOnViewDragListener(new PhotoViewAttacher.OnViewDragListener() {
            @Override
            public void onViewDrag(float x, float y) {
                Log.i("JccTest", x + " " + y + "  " + holder.mImageView.getScale());
                if(null != mCallback
                        &&holder.mImageView.getScale() <= 1.01f && Math.abs(y) > 30){
                    mCallback.onDrag(x, y);
                }
            }

            @Override
            public void onDragFinish() {
                Log.i("JccTest", "onDragFinish");
                if(null != mCallback){
                    mCallback.onDragFinish();
                }
            }
        });
    }

    static class PreviewViewHolder extends ViewHolderRecyclingPagerAdapter.RCViewHolder{
        PhotoView mImageView;
        ImageView mIvSmall;
        public PreviewViewHolder(View view) {
            super(view);
            mImageView = (PhotoView) view.findViewById(R.id.iv_pic);
            mIvSmall = (ImageView) view.findViewById(R.id.iv_small);
        }
    }

    public interface PhotoCallback{
        void onPhotoClick();
        void onDrag(float x, float y);
        void onDragFinish();
    }
}
