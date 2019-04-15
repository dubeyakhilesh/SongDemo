package com.example.songs.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.songs.R;

/**
 * Created by Akhilesh on 13 April 2019.
 * @CompanyName: None
 * @ProjectName: Songs Demo Android App
 * @Project Version: 1.0
 * @PageName: AppManager.java
 * @Module Name: utility
 * @Description : AppManager class
 * @Author: Akhilesh Dubey
 *
 */

public class AppManager {

    /*--Method to show toast message--*/
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    /*--Method to hide soft key board--*/
    public static void hideSoftKeyboard(Context context,  View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    /*--Method to check internet--*/
    public static boolean isConnectingToInternet(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    /*--Set progress dialog--*/
    public static ProgressDialog initProgress(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.progress_message));
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    /*--Method to validate string--*/
    public static boolean isValidString(String string) {
        if (string != null && string.length() > 0 && !string.equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

}







