package com.example.attendance_system;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class update_delete extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        final student st=new student(getApplicationContext());
        Button upd=(Button)findViewById(R.id.addf);
        Button del=(Button)findViewById(R.id.backf);
        final EditText nameu=(EditText)findViewById(R.id.namef);
        final EditText nameu1=(EditText)findViewById(R.id.oldnameee);
        final EditText idt=(EditText)findViewById(R.id.ids);
        final Spinner spinner=(Spinner)findViewById(R.id.debspinner);
        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2,id,dep,nam1;
                name2=nameu.getText().toString();
                nam1=nameu1.getText().toString();
                id=idt.getText().toString();
                dep=spinner.getSelectedItem().toString();
                st.update_student(nam1,name2,id,dep);
                Toast.makeText(getApplicationContext(),"update finished",Toast.LENGTH_SHORT).show();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam1=nameu1.getText().toString();
                st.delete_student(nam1);
                Toast.makeText(getApplicationContext(),"delete finished",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }}
