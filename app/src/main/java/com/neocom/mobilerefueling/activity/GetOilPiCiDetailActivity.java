package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.allen.library.SuperTextView;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.FileCallback;
import com.lzy.okhttputils.cookie.store.PersistentCookieStore;
import com.lzy.okhttputils.model.HttpParams;
import com.lzy.okhttputils.request.BaseRequest;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.PiciDetailBean;
import com.neocom.mobilerefueling.globle.Constant;
import com.neocom.mobilerefueling.net.HttpManger;
import com.neocom.mobilerefueling.view.OrderConbindView;
import com.widget.jcdialog.DialogUtils;
import com.widget.jcdialog.listener.DialogUIListener;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/9/18.
 */

public class GetOilPiCiDetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.top_bar_finish_ll)
    LinearLayout topBarFinishLl;
    @BindView(R.id.top_bar_title_tv)
    TextView topBarTitleTv;
    @BindView(R.id.top_title_bar)
    LinearLayout topTitleBar;
    @BindView(R.id.batch_num)
    OrderConbindView batchNumView;
    @BindView(R.id.fuel_model_name)
    OrderConbindView fuelModelName;
    @BindView(R.id.standard_name)
    OrderConbindView standardName;
    @BindView(R.id.supply_name)
    OrderConbindView supplyName;
    @BindView(R.id.supply_tel)
    OrderConbindView supplyTel;
    @BindView(R.id.batch_report)
    OrderConbindView batchReport;
    @BindView(R.id.remark)
    OrderConbindView remark;
    //    @BindView(R.id.pro_content)
//    LinearLayout proContent;
//    @BindView(R.id.cancle_btn)
//    Button cancleBtn;
//    @BindView(R.id.ok_btn)
//    Button okBtn;
//    @BindView(R.id.progressbar_down)
//    CircleProgress progressbarDown;
//
    @BindView(R.id.loading_progress)
    ProgressBar loadingProgress;
    @BindView(R.id.desity_oil)
    SuperTextView desityOil;

    private String batchNum;
    private String fileUrlId;
    private List<PiciDetailBean.BringBean.FileListBean> fileList;

    String fileName;
    String filePath;

    @Override
    public void initContentView() {
        setContentView(R.layout.get_oil_pici_detail_layout);
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        batchNum = intent.getStringExtra("batchNum");

        if (batchNum == null) {
            Toast.makeText(this, "获取数据异常请重试", Toast.LENGTH_SHORT).show();
            finish();
        }
//        fileName = "zjbg.pdf";

        filePath = Environment.getExternalStorageDirectory() + "/temp";

        batchReport.setOnClickListener(this);
        topBarFinishLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        cancleBtn.setOnClickListener(this);
//        okBtn.setOnClickListener(this);

        initTitle();

        initOkHttpUtils();

        getDataFromServer();
    }

    private void initOkHttpUtils() {
        HttpParams params = new HttpParams();

        //必须调用初始化
        OkHttpUtils.init(getApplication());
        //以下都不是必须的，根据需要自行选择
        OkHttpUtils.getInstance()//
                .debug("OkHttpUtils")                                              //是否打开调试
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                 //全局的写入超时时间
                //                .setCookieStore(new MemoryCookieStore())                           //cookie使用内存缓存（app退出后，cookie消失）
                .setCookieStore(new PersistentCookieStore())                       //cookie持久化存储，如果cookie不过期，则一直有效
                //                .addCommonHeaders(headers)                                         //设置全局公共头
                .addCommonParams(params);                                          //设置全局公共参数

    }

    private void initTitle() {

        batchNumView.setTitle("批次号");
        fuelModelName.setTitle("油品型号");
        standardName.setTitle("国标");
        supplyName.setTitle("供应商");
        supplyTel.setTitle("供应商电话");
        batchReport.setTitle("质检报告");
        remark.setTitle("备注信息");

    }

    @Override
    public void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void getDataFromServer() {
        showLoadingDialog("加载中...");
        RequestId requestId = new RequestId();
        requestId.setBatchNum(batchNum);

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(requestId);

        HttpManger.getHttpMangerInstance().getServices().batchDetail(requestBody).enqueue(new Callback<PiciDetailBean>() {
            @Override
            public void onResponse(Call<PiciDetailBean> call, Response<PiciDetailBean> response) {
                disDialog();
                PiciDetailBean body = response.body();

                if (body != null) {
                    PiciDetailBean.BringBean bring = body.getBring();
                    if (bring != null) {
                        parseBringBean(bring);
                    } else {
                        String message = body.getMessage();

                        if (message != null) {
                            Toasty.info(GetOilPiCiDetailActivity.this, message, Toast.LENGTH_SHORT).show();
                            return;
                        }


                    }

                }


            }

            @Override
            public void onFailure(Call<PiciDetailBean> call, Throwable t) {
                disDialog();
                Toast.makeText(GetOilPiCiDetailActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: ==>" + t.getMessage());
            }
        });


    }

    //    PiciDetailBean.BringBean mBring;
    private void parseBringBean(PiciDetailBean.BringBean bring) {
//this.mBring=bring;
//        fileUrlId = bring.getId();


        batchNumView.setContet(bring.getBatchNum());
        fuelModelName.setContet(bring.getFuelModelName());
        standardName.setContet(bring.getStandardName());
        supplyName.setContet(bring.getSupplyName1());
        supplyTel.setContet(bring.getSupplyTel());
        desityOil.setRightString(bring.getFuelDensity());

        fileList = bring.getFileList();
        if (fileList != null && fileList.size() > 0) {
            fileUrlId = fileList.get(0).getId();
            batchReport.setContet(fileList.get(0).getFileOldname());
            fileName = fileList.get(0).getFileName();
        } else {
            batchReport.setContet("");
        }

        remark.setContet(bring.getRemark());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.batch_report:

                if (TextUtils.isEmpty(fileUrlId)) {

                    Toasty.info(GetOilPiCiDetailActivity.this, "暂无质检报告", Toast.LENGTH_SHORT).show();
                    return;

                }


                File file = new File(filePath + File.separator + fileName);

                String name = file.getName();

                String fileType = name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase();

                Log.i(TAG, "onClick: 存在：" + file.exists() + ";;" + filePath + fileName + "===" + fileType);


                if (fileType.equals("JPG") || fileType.equals("JPEG") || fileType.equals("jpg") || fileType.equals("jpeg") || fileType.equals("PNG") || fileType.equals("png")) {

                    String downFileUrl = Constant.BASE_URL + "/busi/interface/fileDownLoad/" + fileUrlId;

//                    extras.putString(ImagesDetailActivity.INTENT_IMAGE_URL_TAG, entity.getThumbnailUrl());

                    Intent intent = new Intent(GetOilPiCiDetailActivity.this, ImagesDetailActivity.class);
                    intent.putExtra(ImagesDetailActivity.INTENT_IMAGE_URL_TAG, downFileUrl);
                    startActivity(intent);

                }


                if (fileType.equals("pdf") || fileType.equals("PDF")) {


                    if (file.exists()) {
                        openPDF();
                    } else {

                        DialogUtils.showAlert(GetOilPiCiDetailActivity.this, "", "确定要下载质检报告么", "", "", "确定", "取消", false, new DialogUIListener() {
                            @Override
                            public void onPositive() {

                                //去下载 pdf 文件

                                GetDownPdfFile();


                            }

                            @Override
                            public void onNegative() {
// 取消 对话框

                            }

                        }).show();

                    }


                }


                break;


//            case R.id.cancle_btn:
////  取消 进度条
////                proContent.setVisibility(View.GONE);
//
//                break;

//            case R.id.ok_btn:
//
////             tiaozhuan    打开 文件
//
//                startActivity(new Intent(GetOilPiCiDetailActivity.this, PDFViewActivity.class));
//
//                break;


        }

    }

    private void GetDownPdfFile() {

//        http://localhost:8080/busi/interface/fileDownLoad/cdcbc4f6f3ec4cd8b1f017eb16843d53
//        okBtn.setVisibility(View.GONE);
        loadingProgress.setVisibility(View.VISIBLE);
//        proContent.setVisibility(View.VISIBLE);


        String downFileUrl = Constant.BASE_URL + "/busi/interface/fileDownLoad/" + fileUrlId;
//        String downFileUrl = "http://www.gov.cn/zhengce/pdfFile/2017_PDF.pdf";

//        OkHttpUtils.post(downFileUrl).tag(this).execute(new DownloadFileCallBack(Environment.getExternalStorageDirectory() +
//                "/temp", "zjbg.pdf"));
        OkHttpUtils.post(downFileUrl).tag(this).execute(new DownloadFileCallBack(filePath, fileName));


    }


    private class DownloadFileCallBack extends FileCallback {

        public DownloadFileCallBack(String destFileDir, String destFileName) {
            super(destFileDir, destFileName);
        }

        @Override
        public void onBefore(BaseRequest request) {
//            btnFileDownload.setText("正在下载中");
        }

        @Override
        public void onResponse(boolean isFromCache, File file, Request request, okhttp3.Response response) {
//            btnFileDownload.setText("下载完成");
//            show_pdf.setVisibility(View.VISIBLE);
            Toast.makeText(GetOilPiCiDetailActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
//            okBtn.setVisibility(View.VISIBLE);
            loadingProgress.setVisibility(View.GONE);


//            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();

//            if (fileType.equals("pdf")||fileType.equals("PDF")){
            openPDF();
//            }


        }

        @Override
        public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
            System.out.println("downloadProgress -- " + totalSize + "  " + currentSize + "  " + progress + "  " + networkSpeed);

            String downloadLength = Formatter.formatFileSize(getApplicationContext(),
                    currentSize);
            String totalLength = Formatter.formatFileSize(getApplicationContext(), totalSize);
//            tvDownloadSize.setText(downloadLength + "/" + totalLength);


            String netSpeed = Formatter.formatFileSize(getApplicationContext(), networkSpeed);
//            tvNetSpeed.setText(netSpeed + "/S");
//            tvProgress.setText((Math.round(progress * 10000) * 1.0f / 100) + "%");

//            progressbarDown.setValue(Float.valueOf((Math.round(progress * 10000) * 1.0f / 100) + "%"));

            Log.i(TAG, "downloadProgress: downloadLength，" + downloadLength + ",totalLength," + totalLength + ",netSpeed," + netSpeed);


        }

        @Override
        public void onError(boolean isFromCache, okhttp3.Call call, @Nullable okhttp3.Response response, @Nullable Exception e) {
            super.onError(isFromCache, call, response, e);
//            btnFileDownload.setText("下载出错");
            Log.i(TAG, "onError: 下载出错..");
            loadingProgress.setVisibility(View.GONE);
            Toasty.error(GetOilPiCiDetailActivity.this, "下载出错", Toast.LENGTH_SHORT).show();

//            proContent.setVisibility(View.GONE);
        }
    }


    public void openPDF() {

        if (TextUtils.isEmpty(fileName)) {
            Toast.makeText(GetOilPiCiDetailActivity.this, "打开文件失败", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent = new Intent(GetOilPiCiDetailActivity.this, PDFViewActivity.class);
        intent.putExtra("fileName", fileName);
        startActivity(intent);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        OkHttpUtils.getInstance().cancelTag(this);
    }


    public class RequestId {

        public String batchNum;

        public String getBatchNum() {
            return batchNum;
        }

        public void setBatchNum(String batchNum) {
            this.batchNum = batchNum;
        }

        @Override
        public String toString() {
            return "RequestId{" +
                    "batchNum='" + batchNum + '\'' +
                    '}';
        }
    }


}
