package com.neocom.mobilerefueling.downServices;

import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;


import com.neocom.mobilerefueling.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadTask extends AsyncTask<String, Integer, Integer> {

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;
    private static final String TAG = "DownloadTask";


    private DownloadListener listener;

    private boolean isCanceled = false;

    private boolean isPaused = false;

    private int lastProgress;

    private String mDownloadUrl = "";

    public DownloadTask(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;

        mDownloadUrl = params[0];

        try {
            long downloadedLength = 0; // 记录已下载的文件长度
            String downloadUrl = params[0];
//            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String normalUrl = downloadUrl.substring(0, downloadUrl.lastIndexOf("/"));
            String fileName = normalUrl.substring(normalUrl.lastIndexOf("/"));


            LogUtils.i("normalUrl==" + normalUrl + ";fileName;" + fileName);

//            String fileName = "/newApp.apk";
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);

            Log.i(TAG, "doInBackground: " + file.getAbsolutePath() + ";;" + file.getName() + ";;" + ";==>;" + directory + fileName);

            if (file.exists()) {
                downloadedLength = file.length();
            }


            long contentLength = getContentLength(downloadUrl);
            Log.i(TAG, "doInBackground: ==文件长度===" + downloadedLength + ";;服务端文件长度;" + contentLength);
            if (contentLength == 0) {

                LogUtils.i("下载失败==============" + contentLength);

                return TYPE_FAILED;
            } else if (downloadedLength >= contentLength) {
                // 已下载字节和文件总字节相等，说明已经下载完成了

                LogUtils.i("下载成功==============" + contentLength);

                return TYPE_SUCCESS;
            } else {

                LogUtils.i("下载成功=else=====一次啊========" + downloadedLength);

            }
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    // 断点下载，指定从哪个字节开始下载
                    .addHeader("RANGE", "bytes=" + downloadedLength + "-")
                    .url(downloadUrl)
                    .build();
            Response response = client.newCall(request).execute();
            if (response != null) {

//                String header = response.header("Content-Range");
//
//                LogUtils.i("======头信息==========" + header);

                is = response.body().byteStream();
                savedFile = new RandomAccessFile(file, "rw");
                savedFile.seek(downloadedLength); // 跳过已下载的字节
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                while ((len = is.read(b)) != -1) {
                    if (isCanceled) {
                        return TYPE_CANCELED;
                    } else if (isPaused) {
                        return TYPE_PAUSED;
                    } else {
                        total += len;

//                        LogUtils.i("每次下载长度: ====" + total);

                        savedFile.write(b, 0, len);
                        // 计算已下载的百分比
                        int progress = (int) ((total + downloadedLength) * 100 / contentLength);
                        if (progress >= 100) {
                            progress = 100;
                        }
                        publishProgress(progress);
                    }
                }


//                String fileName1 = "/newApp.apk";
//                String directory1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
//
//                File file1 = new File(directory1 + fileName1);
//
//                if (file1.exists()) {
//                    LogUtils.i("=====下载完成 文件大小======" + file1.length());
//
//                }


                LogUtils.i("   下载完成............  ");
                response.body().close();
                LogUtils.i("------body 后 执行----");

                return TYPE_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();


            if (!TextUtils.isEmpty(mDownloadUrl)) {

                String normalUrl = mDownloadUrl.substring(0, mDownloadUrl.lastIndexOf("/"));
                String fileName = normalUrl.substring(normalUrl.lastIndexOf("/"));


                LogUtils.i("normalUrl==" + normalUrl + ";fileName;" + fileName);

//            String fileName = "/newApp.apk";
                String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();


                File file1 = new File(directory + fileName);

                if (file1.exists()) {
                    LogUtils.i("=====下载完成 Exception======" + file1.length());

                }


            }


        } finally {

            LogUtils.i("-===finally= start===");

            try {
                if (is != null) {
                    is.close();
                }
                if (savedFile != null) {
                    savedFile.close();
                }
                if (isCanceled && file != null) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            LogUtils.i("-===finally==end==");
        }

        LogUtils.i("-===finally==fetail==");

        return TYPE_FAILED;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if (progress > lastProgress) {
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status) {
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case TYPE_FAILED:
                listener.onFailed();
                break;
            case TYPE_PAUSED:
                listener.onPaused();
                break;
            case TYPE_CANCELED:
                listener.onCanceled();
            default:
                break;
        }
    }

    public void pauseDownload() {
        isPaused = true;
    }


    public void cancelDownload() {
        isCanceled = true;
    }

    private long getContentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response response = client.newCall(request).execute();
        if (response != null && response.isSuccessful()) {
            long contentLength = response.body().contentLength();
            response.close();

            Log.i(TAG, "getContentLength: 服务端总长度 " + contentLength);

            return contentLength;
        }
        return 0;
    }

}