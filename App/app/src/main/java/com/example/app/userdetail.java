package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.data;
import model.detail;

public class userdetail extends AppCompatActivity {

    public static ArrayList<detail> detail1 = data.detail1;
    private ImageView kembali, edit, delete;
    private TextView fullname, umur, alamat;
    int index;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);
        getSupportActionBar().hide();
        initView();
        getdata();


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getBaseContext(), List.class);
                detail1.remove(index);
                startActivity(intent);
                finish();
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),List.class);
                startActivity(intent);
                finish();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("condition", "edit");
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        kembali = findViewById(R.id.kembali);
        edit = findViewById(R.id.edit);
        delete = findViewById(R.id.delete);
        fullname = findViewById(R.id.fullname);
        umur = findViewById(R.id.umur);
        alamat = findViewById(R.id.alamat);
    }

    private void getdata(){
        Intent intent = getIntent();
  //      detail user = intent.getParcelableExtra("detail");
//     fullname.setText(user.getName());
//        Toast.makeText(getApplicationContext(), user.getName(), Toast.LENGTH_SHORT).show();
//        umur.setText(String.valueOf(user.getAge()));
//        address.setText(user.getAddress());

        index = intent.getIntExtra("index", -1);
        if(index != -1){
            fullname.setText(detail1.get(index).getName());
            umur.setText(String.valueOf(detail1.get(index).getAge()));
            alamat.setText(detail1.get(index).getAddress());
        }

    }


}