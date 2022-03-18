package com.example.attendance_system;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class faculty_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_page);
        Button addst=(Button)findViewById(R.id.addStb);
        Button veiwst=(Button)findViewById(R.id.VeiwSb);
        Button upst=(Button)findViewById(R.id.upsb);
        Button out=(Button)findViewById(R.id.logoutbtn);
        addst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(faculty_page.this,addnewstudent.class);
                startActivity(i);
            }
        });
        veiwst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(faculty_page.this,students_Display.class);
                startActivity(i);
            }
        });
        upst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(faculty_page.this,update_delete.class);
                startActivity(i);
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(faculty_page.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
