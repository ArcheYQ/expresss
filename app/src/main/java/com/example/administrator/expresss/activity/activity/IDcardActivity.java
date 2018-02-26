package com.example.administrator.expresss.activity.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import com.example.administrator.expresss.R;
import com.example.administrator.expresss.activity.util.IDUtil;
import com.imnjh.imagepicker.SImagePicker;
import com.imnjh.imagepicker.activity.PhotoPickerActivity;
import java.io.IOException;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class IDcardActivity extends BaseActivity {
    public static final int REQUEST_CODE_IMAGE = 200;
    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        if (getCcamra() && getStorage()) {
            SImagePicker
                    .from(IDcardActivity.this)
                    .maxCount(1)
                    .pickMode(SImagePicker.MODE_IMAGE)
                    .forResult(REQUEST_CODE_IMAGE);
        } else {
            Toast.makeText(mActivity, "请给予权限", Toast.LENGTH_SHORT).show();
        }
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE) {
                final ArrayList<String> pathList =
                        data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT_SELECTION);
                Log.i("1","pathBase64"+pathList.get(0));
                IDUtil.requestIData(IDUtil.imageToBase64(pathList.get(0)), new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        Log.i("2","Base64"+responseData);
                    }
                });
                Log.i("2","Base64"+IDUtil.imageToBase64(pathList.get(0)));
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }


