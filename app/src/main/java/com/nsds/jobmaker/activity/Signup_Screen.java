package com.nsds.jobmaker.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nsds.jobmaker.R;

public class Signup_Screen extends Activity {
    Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__screen);
        UI_Components();
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup_Screen.this,Registration_Screen.class));

            }
        });
    }
    public void UI_Components()
    {
        Signup=(Button)findViewById(R.id.signup);
    }
}
