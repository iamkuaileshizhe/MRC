package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.neo.mobilerefueling.R;
//import com.uuzuche.lib_zxing.activity.CodeUtils;

import com.neocom.mobilerefueling.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/3/1.
 */

public class QrCodeActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_bar_ok_ll)
    LinearLayout topBarOkLl;
    @BindView(R.id.image_content)
    ImageView imageContent;
    @BindView(R.id.image_share)
    ImageView imageShare;
    public Bitmap mBitmap = null;

    @Override
    public void initContentView() {
        setContentView(R.layout.qrcode_layout);
    }

    // 长按保存 二维码
    @Override
    public void initView() {
        topBarFinishLl.setOnClickListener(this);
        imageShare.setOnClickListener(this);
        imageContent.setOnLongClickListener(this);


//        intent.putExtra("sharUrl", sharUrl);

        Intent intent = getIntent();
        String sharUrl = intent.getStringExtra("sharUrl");

        if (!TextUtils.isEmpty(sharUrl)) {
//            showMyQRCode("http://gyxz.exmmw.cn/a3/rj_sp1/xndwdk.apk");
            showMyQRCode(sharUrl);
        }else {
            Toast.makeText(this, "二维码展示失败", Toast.LENGTH_SHORT).show();
        }

    }

    private void showMyQRCode(String userInfo) {

        if (TextUtils.isEmpty(userInfo)) {
            Toast.makeText(QrCodeActivity.this, "生成二维码有误", Toast.LENGTH_SHORT).show();
            return;
        }
        mBitmap = CodeUtils.createImage(userInfo, 500, 500, BitmapFactory.decodeResource(getResources(), R.drawable.appicon));
        imageContent.setImageBitmap(mBitmap);

    }


    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.top_bar_finish_ll:
                finish();

                break;
            case R.id.image_share:
                Log.i(TAG, "onClick: 分享我的二维码");

                break;

        }

    }



    @Override
    public boolean onLongClick(View v) {

        if (mBitmap != null) {
            saveImage(mBitmap);
        }

        return false;
    }

    public void saveImage(Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory(), "GMJY");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
//            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), fileName, null);

            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getPath())));
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
