package com.huel.luosenen.togethergo.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.huel.luosenen.togethergo.R;
import com.huel.luosenen.togethergo.user.GoUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * 登录Activity
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private Button toRegister,toLogin;
    private EditText account,password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        if (GoUser.isLogin()) {
            GoUser user = GoUser.getCurrentUser(GoUser.class);
            String username = (String) GoUser.getObjectByKey("username");
            String university = (String) GoUser.getObjectByKey("university");
            String nick = (String) GoUser.getObjectByKey("nick");

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        } else {

        }
    }

    /**
     * 初始化控件
     */
    public void init(){
        toRegister = this.findViewById(R.id.login_to_register);
        toLogin = this.findViewById(R.id.login_to_login);
        toRegister.setOnClickListener(this);
        toLogin.setOnClickListener(this);
        account = findViewById(R.id.login_account);
        password = findViewById(R.id.login_password);
        progressBar = findViewById(R.id.login_progressBar);
    }

    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_to_register:
                loginByAccount(v);
                finish();
                break;
            case R.id.login_to_login:

                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
                finish();
                break;
        }
    }

    /**
     * 登录账号
     * @param view
     */
    private void loginByAccount(final View view) {
        String name = account.getText().toString().trim();
        String passwd = password.getText().toString().trim();
        progressBar.setVisibility(View.VISIBLE);
        GoUser.loginByAccount(name, passwd, new LogInListener<GoUser>() {
            @Override
            public void done(GoUser user, BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "登录成功：" + user.getUsername(), Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    Snackbar.make(view, "登录失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    return;
                }
            }
        });
    }
}
