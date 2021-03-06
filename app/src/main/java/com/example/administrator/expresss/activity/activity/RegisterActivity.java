package com.example.administrator.expresss.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;
import com.example.administrator.expresss.R;
import com.example.administrator.expresss.activity.bean.Student;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import qiu.niorgai.StatusBarCompat;

public class RegisterActivity extends BaseActivity {
    FrameLayout frameLayout;
    @Bind(R.id.et_login_username)
    EditText etLoginUsername;
    @Bind(R.id.et_login_password)
    EditText etLoginPassword;
    @Bind(R.id.button_login)
    Button buttonLogin;
    @Bind(R.id.tv_login_register)
    TextView tvLoginRegister;
    @Bind(R.id.fl_login)
    FrameLayout flLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.translucentStatusBar(this);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initData();
        Glide.with(RegisterActivity.this)
                .load(R.drawable.login_bg)
                .dontAnimate()
                // 设置高斯模糊
//                .bitmapTransform(new BlurTransformation(this, 14,3))
                .into(new ViewTarget<View, GlideDrawable>(frameLayout) {
                    //括号里为需要加载的控件
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
                        this.view.setBackground(resource.getCurrent());
                    }
                });
    }

    private void initData() {
        frameLayout = (FrameLayout) findViewById(R.id.fl_login);
    }

    @OnClick({R.id.button_login, R.id.tv_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                loginUser();
                break;
            case R.id.tv_login_register:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
        }
    }

    private void loginUser() {
        Student student = new Student();
        student.setUsername(etLoginUsername.getText().toString());
        student.setPassword(etLoginPassword.getText().toString());
        student.login(new SaveListener<Student>() {
            @Override
            public void done(Student bmobUser, BmobException e) {
                if (e == null) {
                    //success;
                } else if (e.getErrorCode() == 9016) {
                    Toast.makeText(RegisterActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "请检查你的账号密码是否正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
