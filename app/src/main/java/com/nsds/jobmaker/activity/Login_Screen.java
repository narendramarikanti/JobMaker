package com.nsds.jobmaker.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nsds.jobmaker.R;

public class Login_Screen extends Activity {
  Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        UI_Components();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Screen.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void UI_Components()
    {
        login_btn = (Button)findViewById(R.id.login_btn);
    }

}
