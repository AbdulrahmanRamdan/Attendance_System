package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addnewfaculty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnewfaculty);
        final faculty_Datahelper FHP=new faculty_Datahelper(getApplicationContext());
        Button add=(Button)findViewById(R.id.add12);
        Button back=(Button)findViewById(R.id.back11);
        final EditText user_name=(EditText)findViewById(R.id.nameff);
        final EditText pass_word=(EditText)findViewById(R.id.password);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=user_name.getText().toString();
                String pass=pass_word.getText().toString();
                FHP.add_faculty(pass,name);
                Toast.makeText(getApplicationContext(),"faculty added sucesssed",Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii=new Intent(addnewfaculty.this,admin_page.class);
                startActivity(iii);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
