package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import model.detail;

public class MainActivity extends AppCompatActivity {

    private EditText input_name, input_age, input_address;
    private Button save;
    private ImageView back;
    loading load = new loading(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initView();
        input_name.addTextChangedListener(TW_newData);
        input_age.addTextChangedListener(TW_newData);
        input_address.addTextChangedListener(TW_newData);
        save = findViewById(R.id.save);
        setListener();
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setListener() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input_name.getText().toString().trim();
                String age1 = input_age.getText().toString().trim();
                int age = Integer.parseInt(age1);
                String address = input_address.getText().toString().trim();
                detail temp = new detail(name, age, address);
                Intent intent = new Intent();
                intent.putExtra("detailbaru", temp);
                load.startLoadingDialog();
                setResult(200, intent);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        load.dismiss();
                        finish();
                    }
                }, 1000);
            }
        });
    }

    private void initView() {
        input_name = findViewById(R.id.input_name);
        input_age = findViewById(R.id.input_age);
        input_address = findViewById(R.id.input_address);

    }

    private TextWatcher TW_newData = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String name = input_name.getText().toString().trim();
            String age = input_age.getText().toString().trim();
            String address = input_address.getText().toString().trim();

            if (!name.isEmpty() && name.length() < 21) {
                if (!age.isEmpty() && !address.isEmpty()) {
                    save.setEnabled(true);
                } else {
                    save.setEnabled(false);
                }
            } else {
                save.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}