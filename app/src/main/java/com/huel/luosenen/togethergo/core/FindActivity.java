package com.huel.luosenen.togethergo.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huel.luosenen.togethergo.R;
import com.huel.luosenen.togethergo.user.GoUser;

import cn.bmob.v3.exception.BmobException;

/**
 * 找回密码Activity
 */
public class FindActivity extends Activity {
    private EditText account,email;
    private Button find;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_account);
        account = findViewById(R.id.find_account);
        find = findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
