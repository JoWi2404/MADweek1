package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;

public class loading extends AppCompatActivity {

    private Activity activity;
    private AlertDialog dialog;

    loading(Activity myActivity) {
        activity = myActivity;
    }

    void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_loading, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    void dismiss() {
        dialog.dismiss();
    }
}