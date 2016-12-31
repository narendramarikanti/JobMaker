package com.nsds.jobmaker.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utility {
    private static String ENTOURAGE_DATA = "JOBMAKER_DATA";

    public static boolean isConnectingToInternet() {
        InetAddress inetAddress = null;
        try {
            Future<InetAddress> future = Executors.newSingleThreadExecutor().submit(new Callable<InetAddress>() {
                @Override
                public InetAddress call() {
                    try {
                        return InetAddress.getByName("google.com");
                    } catch (UnknownHostException e) {
                        return null;
                    }
                }
            });
            inetAddress = future.get(2000, TimeUnit.MILLISECONDS);
            future.cancel(true);

        } catch (Exception e) {
        }
        return inetAddress != null && !inetAddress.equals("");
    }

    public static void setSharedPreference(Context context, String name, String value) {
        SharedPreferences settings = context.getSharedPreferences(ENTOURAGE_DATA, 0);
        SharedPreferences.Editor editor = settings.edit();
        // editor.clear();
        editor.putString(name, value);
        editor.commit();
    }

    public static String getSharedPreferences(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(ENTOURAGE_DATA, 0);
        return settings.getString(name, "");
    }

    public static void setBoolean(Context context, String name, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(ENTOURAGE_DATA, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String name) {
        SharedPreferences settings = context.getSharedPreferences(ENTOURAGE_DATA, 0);
        return settings.getBoolean(name, false);
    }

    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile (EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }


//    public static void showInternetAlert(Activity mActivity) {
//        new SweetAlertDialog(mActivity, SweetAlertDialog.ERROR_TYPE)
//                .setTitleText("Oops...")
//                .setContentText("No internet connection!\nTry again")
//                .show();
//    }
//
    public static void clearSharedPreference(Context context){
        SharedPreferences settings = context.getSharedPreferences(ENTOURAGE_DATA, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear().apply();

    }


}
