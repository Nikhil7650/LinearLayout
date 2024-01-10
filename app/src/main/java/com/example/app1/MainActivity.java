package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button butadd;
    private Button butview;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.maintxt);
        editText=findViewById(R.id.enttxt);
        butadd=findViewById(R.id.addbut);
        butview=findViewById(R.id.viewbut);
        DB=new DBHelper(this);
        butview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity2viewpage.class);
                String Buttontxt=butview.getText().toString();
                intent.putExtra("Buttontext",Buttontxt);
                startActivity(intent);


            }
        });
        butadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametxt=editText.getText().toString();
                Boolean checkinsertdata=DB.insertuserdata(nametxt);
                if(checkinsertdata==true){
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Please Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}