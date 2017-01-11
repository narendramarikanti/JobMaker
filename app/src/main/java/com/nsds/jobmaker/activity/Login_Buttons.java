package com.nsds.jobmaker.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nsds.jobmaker.R;

public class Login_Buttons extends Activity {

    Button Login,Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__buttons);
        UI_Components();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Buttons.this, Login_Screen.class));
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                finish();

            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Buttons.this, Signup_Screen.class));
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                finish();
            }
        });
    }

    public  void UI_Components()
    {
        Login=(Button)findViewById(R.id.login);
        Signup=(Button)findViewById(R.id.signup);

    }
}
