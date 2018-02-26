package com.example.administrator.expresss.activity.util;

import android.media.Image;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.example.administrator.expresss.activity.api.ApiHttpUtils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/2/12.
 */

public class IDUtil {
    /**
     * 将图片转换成Base64编码的字符串
     * @param path
     * @return base64编码的字符串
     */
    public static String imageToBase64(String path){
        if(TextUtils.isEmpty(path)){
            return null;
        }
        InputStream is = null;
        byte[] data = null;
        String result = null;
        try{
            is = new FileInputStream(path);
            //创建一个字符流大小的数组。
            data = new byte[is.available()];
            //写入数组
            is.read(data);
            //用默认的编码格式进行编码
            result = Base64.encodeToString(data,Base64.DEFAULT);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(null !=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }
    public static void requestIData(String base,okhttp3.Callback callback) {
        String host = "https://dm-51.data.aliyun.com";
        String path = "/rest/160601/ocr/ocr_idcard.json";
        String appcode = "8f229380104af06b4ef80be7c8579b42";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder().add("image", base).add("configure", "{\\\"face\\\"}").build();
        Request request = new Request.Builder()
                .url( host+path+"-H "+appcode)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
