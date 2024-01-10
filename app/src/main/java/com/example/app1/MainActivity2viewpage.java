package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2viewpage extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name;
    DBHelper DB;

    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2viewpage);
        DB=new DBHelper(this);
        name=new ArrayList<>();
        recyclerView=findViewById(R.id.recylerview);
        adapter=new MyAdapter(this,name);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor=DB.getData();
        if(cursor.getCount()==0){
            Toast.makeText(MainActivity2viewpage.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
            }
        }
    }
    }
