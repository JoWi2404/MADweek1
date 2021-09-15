package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

import model.data;
import model.detail;

public class List extends AppCompatActivity {


    private RecyclerView recyclerView;
    public static ArrayList<detail>detail1 = data.detail1;
    private adapter adapter1;
    private FloatingActionButton addbutton;
    private TextView message;

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();
        initView();
        setupRecyclerView();
        setListener();
       // Toast.makeText(getApplicationContext(), info.getName(), Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void tonA(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1) {
//            if (resultCode == 200) {
//                Intent intent = getIntent();
//                detail newdetail = intent.getParcelableExtra("newdetail");
//               // Toast.makeText(getApplicationContext(), newdetail.getName(), Toast.LENGTH_SHORT).show();
//                info.add(newdetail);
//                adapter1.notifyDataSetChanged();
//                if (info != null){
//                    message.setVisibility(View.GONE);
//                }else{
//                    message.setVisibility(View.VISIBLE);
//                }
//            }
//        }
//    }

    private void getintentdata(){
        Intent intent = getIntent();
    }

    private void setListener() {
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("condition", "add");
             //   startActivityForResult(intent, 1);
                startActivity(intent);
            }
        });
    }

    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter1);
    }

    private void initView() {
        addbutton = findViewById(R.id.addbutton);
        adapter1 = new adapter(detail1);
        recyclerView = findViewById(R.id.recyclerView);
        message = findViewById(R.id.message);
        if (detail1.size() != 0){
                    message.setVisibility(View.GONE);
                }else{
                    message.setVisibility(View.VISIBLE);
               }
    }
}