package jcc.example.com.browseimg;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jcc.example.com.browseimg.util.JImageShowUtil;
import jcc.example.com.browseimg.util.JMatrixUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mIvTest;
    private ImageView mIvTest1;
    private ImageView mIvTest2;
    private ImageView mIvTest3;

    private String[] mPaths = new String[]{
            "http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521111466196&di=4abfe93a8d72938931f49728c9794824&imgtype=0&src=http%3A%2F%2Fimg001.21cnimg.com%2Fphotos%2Falbum%2F20150911%2Fm600%2F8E9813CB8FCF58BB33A452B3912B3149.jpg",
            "http://img.zcool.cn/community/018d4e554967920000019ae9df1533.jpg@900w_1l_2o_100sh.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521117438294&di=92e228dd7303a470e3edc8cedb6329b5&imgtype=0&src=http%3A%2F%2Fattimg.dospy.com%2Fimg%2Fday_150423%2F20150423_7ef133d562957e27be33aOLlEAEC31RM.jpg",
            "http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int sdk = Build.VERSION.SDK_INT;
        if (sdk >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        setContentView(R.layout.activity_main);

        mIvTest = findViewById(R.id.iv_test);
        mIvTest1 = findViewById(R.id.iv_test1);
        mIvTest2 = findViewById(R.id.iv_test2);
        mIvTest3 = findViewById(R.id.iv_test3);

        JImageShowUtil.displayImage(mPaths[0], mIvTest);
        JImageShowUtil.displayImage(mPaths[1], mIvTest1);
        JImageShowUtil.displayImage(mPaths[2], mIvTest2);
        JImageShowUtil.displayImage(mPaths[3], mIvTest3);

        mIvTest.setOnClickListener(this);
        mIvTest1.setOnClickListener(this);
        mIvTest2.setOnClickListener(this);
        mIvTest3.setOnClickListener(this);
    }

    private void startBrowse(int pos){
        List<Rect> rects = new ArrayList<>();
        rects.add(JMatrixUtil.getDrawableBoundsInView(mIvTest));
        rects.add(JMatrixUtil.getDrawableBoundsInView(mIvTest1));
        rects.add(JMatrixUtil.getDrawableBoundsInView(mIvTest2));
        rects.add(JMatrixUtil.getDrawableBoundsInView(mIvTest3));
        JBrowseImgActivity.start(this, new ArrayList<>(Arrays.asList(mPaths)), pos, rects);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_test:
                startBrowse(0);
                break;
            case R.id.iv_test1:
                startBrowse(1);
                break;
            case R.id.iv_test2:
                startBrowse(2);
                break;
            case R.id.iv_test3:
                startBrowse(3);
                break;
        }
    }
}
