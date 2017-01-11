package com.nsds.jobmaker.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.nsds.jobmaker.R;

public class Signup_Screen extends Activity {
    Button Signup;
    RelativeLayout have_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__screen);
        UI_Components();
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup_Screen.this, Registration_Screen.class));
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);

            }
        });

        have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup_Screen.this, Login_Screen.class));
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                finish();
            }
        });
    }
    public void UI_Components()
    {
        Signup=(Button)findViewById(R.id.signup);
        have_account = (RelativeLayout) findViewById(R.id.have_acc);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
