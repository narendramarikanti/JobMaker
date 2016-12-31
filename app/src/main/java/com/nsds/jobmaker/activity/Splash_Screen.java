package com.nsds.jobmaker.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.nsds.jobmaker.R;


public class Splash_Screen extends Activity {
    private static int SCREEN_DURATION = 2000;
    private LinearLayout btnLinearLayout;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        mActivity = this;
//        btnLinearLayout = (LinearLayout) findViewById(R.id.btn_layout);
   //     btnLinearLayout.setVisibility(View.GONE);




        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SCREEN_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       // if (Utility.isConnectingToInternet()) {
     //                       btnLinearLayout.setVisibility(View.GONE);

                                startActivity(new Intent(Splash_Screen.this, Login_Buttons.class));
                                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                                finish();
//                            else {
//                                startActivity(new Intent(Splash_Screen.this, HomeActivity.class));
//                                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
//                                finish();
//                            }
//                        } else {
//                            Utility.showInternetAlert(mActivity);
//                            btnLinearLayout.setVisibility(View.VISIBLE);
//                        }

                    }
                });
            }
        }).start();

    }


//    public void refreshButton(View view) {
//        if (Utility.isConnectingToInternet()) {
//            btnLinearLayout.setVisibility(View.GONE);
//            if (Utility.getSharedPreferences(mActivity, Constant.MEMBERID).equalsIgnoreCase("")) {
//                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
//                finish();
//
//            } else {
//                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
//                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
//                finish();
//            }
//        } else {
//            Utility.showInternetAlert(mActivity);
//            btnLinearLayout.setVisibility(View.VISIBLE);
//        }
//    }
}
