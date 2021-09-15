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
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import model.data;
import model.detail;

public class MainActivity extends AppCompatActivity {

    private EditText input_name, input_age, input_address;
    private Toolbar judul;
    private Button save;
    private ImageView back, profile;
    private detail current;
    loading load = new loading(MainActivity.this);
    public static ArrayList<detail> detail1 = data.detail1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initView();
        if(detail1 == null){
            detail1 = new ArrayList<>();
        }

        intent = getIntent();
        int index = intent.getIntExtra("index",-1);
        String condition = intent.getStringExtra("condition");
        input_name.addTextChangedListener(TW_newData);
        input_age.addTextChangedListener(TW_newData);
        input_address.addTextChangedListener(TW_newData);

        if(condition.equalsIgnoreCase("edit")){
            judul.setTitle("Edit User");
            current = detail1.get(index);
            input_name.setText(current.getName());
            input_age.setText(String.valueOf(current.getAge()));
            input_address.setText(current.getAddress());
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = input_name.getText().toString().trim();
                    String age1 = input_age.getText().toString().trim();
                    int age = Integer.parseInt(age1);
                    String address = input_address.getText().toString().trim();
                    detail temp = new detail(name, age, address);
                    detail1.set(index,temp);
                    intent = new Intent(MainActivity.this,List.class);
                    load.startLoadingDialog();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            load.dismiss();
                            startActivity(intent);
                            finish();
                        }
                    },1000);
                }
            });
        } else {
            setListener();
        }



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
                detail1.add(temp);
                Intent intent = new Intent(MainActivity.this,List.class);
              //intent.putExtra("detailbaru", temp);
                load.startLoadingDialog();
            //  setResult(200, intent);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        load.dismiss();
                        startActivity(intent);
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
        save = findViewById(R.id.save);
        back = findViewById(R.id.back);
        judul = findViewById(R.id.judul);
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