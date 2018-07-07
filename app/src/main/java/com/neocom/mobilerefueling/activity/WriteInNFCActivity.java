package com.neocom.mobilerefueling.activity;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neocom.mobilerefueling.R;
import com.neocom.mobilerefueling.bean.WriteNFCReqBean;
import com.neocom.mobilerefueling.bean.WriteNFCTagBean;
import com.neocom.mobilerefueling.net.HttpManger;

import java.nio.charset.Charset;
import java.util.Locale;

import es.dmoral.toasty.Toasty;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/11/7.
 */

public class WriteInNFCActivity extends BaseActivity {

    private String nfcdata;
    private WriteNFCTagBean writeNFCTagBean;
    private Gson gson;

    @Override
    public void initContentView() {
        setContentView(R.layout.write_in_nfc_layout);
    }

    @Override
    public void initView() {

        Intent intent = getIntent();
        nfcdata = intent.getStringExtra("nfcdata");

        Log.i(TAG, "initView: 获取到的内容" + nfcdata);

        gson = new Gson();

        writeNFCTagBean = gson.fromJson(nfcdata, WriteNFCTagBean.class);
    }

    @Override
    public void initData() {

    }


//    private void readNFCId(){
//        byte[] bytesId =intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
//        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
//        byte[] dataId = tag.getId();
//        Log.e("dataId",dataId+"");
//        String strId = bytesToHexString(dataId);// 字符序列转换为16进制字符串
//        Log.e("strId",strId+"");
//    }


    // 加油车 补给车 客户车
    @Override
    public void onNewIntent(Intent intent) {
        if (nfcdata == null) {
            Toast.makeText(this, "写入数据异常", Toast.LENGTH_SHORT).show();
            return;
        }

//        byte[] bytesId =intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);


        Log.i(TAG, "onNewIntent: 获取的：" + nfcdata);


        //获取Tag对象
        Tag detectedTag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

        writeNFCTagBean.setNfcId(bytesToHexString(detectedTag.getId()));

        String writeInStr = gson.toJson(writeNFCTagBean);

        Log.i(TAG, "onNewIntent: 写入的数据是：" + writeInStr);

        NdefMessage ndefMessage = new NdefMessage(
                new NdefRecord[]{createTextRecord(writeInStr)});
        boolean result = writeTag(ndefMessage, detectedTag);
        if (result) {
//            Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
            Toasty.success(this, "写入成功", Toast.LENGTH_SHORT, true).show();
            sendToServer(writeNFCTagBean);
//            finish();
        } else {
            Toasty.error(this, "写入失败", Toast.LENGTH_SHORT, true).show();
            finish();
        }
    }

    private void sendToServer(WriteNFCTagBean writeNFCTagBean) {

        WriteNFCReqBean nfcReqBean = new WriteNFCReqBean();

        nfcReqBean.setUserId(writeNFCTagBean.getWriter());
        nfcReqBean.setCarCode(writeNFCTagBean.getCarnum());
        nfcReqBean.setCarType(writeNFCTagBean.getCartype());
        nfcReqBean.setNFCId(writeNFCTagBean.getNfcId());

        RequestBody requestBody = HttpManger.getHttpMangerInstance().getRequestBody(nfcReqBean);
        HttpManger.getHttpMangerInstance().getServices().insertNfcLable(requestBody).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                Toasty.success(WriteInNFCActivity.this, "写入成功", Toast.LENGTH_SHORT, true).show();
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

//                Toasty.error(WriteInNFCActivity.this, "写入异常", Toast.LENGTH_SHORT, true).show();
                finish();
            }
        });

    }


//    WriteNFCReqBean

    /**
     * 创建NDEF文本数据
     *
     * @param text
     * @return
     */
    public static NdefRecord createTextRecord(String text) {
        byte[] langBytes = Locale.CHINA.getLanguage().getBytes(Charset.forName("US-ASCII"));
        Charset utfEncoding = Charset.forName("UTF-8");
        //将文本转换为UTF-8格式
        byte[] textBytes = text.getBytes(utfEncoding);
        //设置状态字节编码最高位数为0
        int utfBit = 0;
        //定义状态字节
        char status = (char) (utfBit + langBytes.length);
        byte[] data = new byte[1 + langBytes.length + textBytes.length];
        //设置第一个状态字节，先将状态码转换成字节
        data[0] = (byte) status;
        //设置语言编码，使用数组拷贝方法，从0开始拷贝到data中，拷贝到data的1到langBytes.length的位置
        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
        //设置文本字节，使用数组拷贝方法，从0开始拷贝到data中，拷贝到data的1 + langBytes.length
        //到textBytes.length的位置
        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);
        //通过字节传入NdefRecord对象
        //NdefRecord.RTD_TEXT：传入类型 读写
        NdefRecord ndefRecord = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                NdefRecord.RTD_TEXT, new byte[0], data);
        return ndefRecord;
    }




    //将NdefMessage对象写入标签，成功写入返回ture，否则返回false
    boolean writeTag(NdefMessage message, Tag tag) {
        int size = message.toByteArray().length;

        try {
            //获取Ndef对象
            Ndef ndef = Ndef.get(tag);
            if (ndef != null) {
                //允许对标签进行IO操作
                ndef.connect();

                if (!ndef.isWritable()) {
                    Toast.makeText(this, "NFC Tag是只读的！", Toast.LENGTH_LONG)
                            .show();
                    return false;

                }
                if (ndef.getMaxSize() < size) {
                    Toast.makeText(this, "NFC Tag的空间不足！", Toast.LENGTH_LONG)
                            .show();
                    return false;
                }

                //向标签写入数据
                ndef.writeNdefMessage(message);
//                Toast.makeText(this, "已成功写入数据！", Toast.LENGTH_LONG).show();
                return true;

            } else {
                //获取可以格式化和向标签写入数据NdefFormatable对象
                NdefFormatable format = NdefFormatable.get(tag);
                //向非NDEF格式或未格式化的标签写入NDEF格式数据
                if (format != null) {
                    try {
                        //允许对标签进行IO操作
                        format.connect();
                        format.format(message);
//                        Toast.makeText(this, "已成功写入数据！", Toast.LENGTH_LONG)
//                                .show();
                        return true;

                    } catch (Exception e) {
                        Toast.makeText(this, "写入NDEF格式数据失败！", Toast.LENGTH_LONG)
                                .show();
                        e.printStackTrace();
                        return false;
                    }
                } else {
                    Toast.makeText(this, "NFC标签不支持NDEF格式！", Toast.LENGTH_LONG)
                            .show();
                    return false;

                }
            }
        } catch (Exception e) {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return false;
        }

    }











    private String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();

        if (src == null || src.length <= 0) {
            return null;
        }
        char[] buffer = new char[2];
        for (int i = 0; i < src.length; i++) {
            buffer[0] = Character.toUpperCase(Character.forDigit(
                    (src[i] >>> 4) & 0x0F, 16));
            buffer[1] = Character.toUpperCase(Character.forDigit(src[i] & 0x0F,
                    16));
            System.out.println(buffer);
            stringBuilder.append(buffer);
        }
        return stringBuilder.toString();
    }


}
