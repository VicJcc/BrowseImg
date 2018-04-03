package jcc.example.com.browseimg.util;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 *  Created by jincancan on 16/8/11.
 */
public class JMatrixUtil {

    public static Rect getDrawableBoundsInView(ImageView iv) {
        if (iv == null || iv.getDrawable() == null) {
            return null;
        }
        Drawable d = iv.getDrawable();
        Rect result = new Rect();
        iv.getGlobalVisibleRect(result);
        Rect tDrawableRect = d.getBounds();
        android.graphics.Matrix drawableMatrix = iv.getImageMatrix();

        float[] values = new float[9];
        if (drawableMatrix != null) {
            drawableMatrix.getValues(values);
        }

        result.left = result.left + (int) values[android.graphics.Matrix.MTRANS_X];
        result.top = result.top + (int) values[android.graphics.Matrix.MTRANS_Y];
        result.right = (int) (result.left + tDrawableRect.width() * (values[android.graphics.Matrix.MSCALE_X] == 0 ? 1.0f : values[android.graphics.Matrix.MSCALE_X]));
        result.bottom = (int) (result.top + tDrawableRect.height() * (values[android.graphics.Matrix.MSCALE_Y] == 0 ? 1.0f : values[android.graphics.Matrix.MSCALE_Y]));

        return result;
    }
}
