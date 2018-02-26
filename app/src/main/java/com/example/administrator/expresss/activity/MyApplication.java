package com.example.administrator.expresss.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.expresss.R;
import com.example.administrator.expresss.activity.activity.IDcardActivity;
import com.example.administrator.expresss.activity.other.GlideImageLoader;
import com.imnjh.imagepicker.PickerConfig;
import com.imnjh.imagepicker.SImagePicker;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.loader.ImageLoader;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.zxy.tiny.Tiny;

import java.io.File;

import cn.bmob.v3.Bmob;


/**
 * Created by Administrator on 2017/12/3.
 */

public class MyApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,"567a56deb6f8f8e1c55f71f4dc84158f");
        mContext=getApplicationContext();
        Tiny.getInstance().init(this);
        SImagePicker.init(new PickerConfig.Builder().setAppContext(this)
                .setImageLoader(new GlideImageLoader())
                .setToolbaseColor(Color.parseColor("#108de8"))
                .build());
    }

}
