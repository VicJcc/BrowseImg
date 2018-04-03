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
            "http://img.hb.aicdn.com/f22df3bca217f7435b6b7d3c66bc6d21d72b60c3a70eb-yctL70_fw658",
            "http://img.hb.aicdn.com/266e4c85ef38c4ef468dd28cc5ae9deba47080867d89-urhOsD_fw658",
            "http://img.hb.aicdn.com/652b269af2818f6f1c468399e00152d73d0a7beb29d1e-2vnLBW_fw658",
            "http://img.hb.aicdn.com/b8ce046106dc17ebb3782351f2a493b52daf149611f57-YkEgOp_fw658"
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
