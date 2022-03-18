package com.example.attendance_system;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class dispayfacluties extends AppCompatActivity{
ListView myfacultieslist;
ArrayAdapter<String>arrayAdapterf;
faculty_Datahelper FHP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispayfacluties);
         myfacultieslist=(ListView)findViewById(R.id.showf);
        arrayAdapterf=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        myfacultieslist.setAdapter(arrayAdapterf);
        FHP=new faculty_Datahelper(getApplicationContext());
        Cursor cursor=FHP.veiw_faculties();
        while(!cursor.isAfterLast()){

            String data="user name:"+cursor.getString(0)+"  pass word :"+cursor.getString(1);
            arrayAdapterf.add(data);
            cursor.moveToNext();
        }
        Button btn=(Button)findViewById(R.id.backtomain);
        Button delete=(Button)findViewById(R.id.button);
        final EditText namef=(EditText)findViewById(R.id.editText) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(dispayfacluties.this,admin_page.class);
                startActivity(i);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String del=namef.getText().toString();
               FHP.delete_faculty(del);
                Toast.makeText(getApplicationContext(),del+" deleted",Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }}
