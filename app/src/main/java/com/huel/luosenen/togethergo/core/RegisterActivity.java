package com.huel.luosenen.togethergo.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.huel.luosenen.togethergo.R;
import com.huel.luosenen.togethergo.user.GoUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends Activity {

    private Button toRegister;
    private EditText account,password;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    public void init(){

        account = findViewById(R.id.register_account);
        password = findViewById(R.id.register_password);
        progressBar = findViewById(R.id.register_progressBar);
        toRegister = this.findViewById(R.id.register_to_register);
    }

    private void signUp() {
        String name = account.getText().toString().trim();
        String passwd = password.getText().toString().trim();
        final GoUser user = new GoUser();
        user.setUsername(name);
        user.setPassword(passwd);
        progressBar.setVisibility(View.VISIBLE);
        user.signUp(new SaveListener<GoUser>() {
            @Override
            public void done(GoUser user, BmobException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(),"注册失败"+e.toString(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
