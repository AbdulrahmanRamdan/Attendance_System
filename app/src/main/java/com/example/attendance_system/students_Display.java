package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class students_Display extends AppCompatActivity {
    ListView mystudentslist;
    ArrayAdapter<String> arrayAdapter;
    student st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students__display);

        mystudentslist=(ListView)findViewById(R.id.shows);
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        mystudentslist.setAdapter(arrayAdapter);
        st=new student(getApplicationContext());
        Cursor cursor=st.display_all_syudent();
        while(!cursor.isAfterLast()){

            String data="name :"+cursor.getString(0)+"  id :"+cursor.getString(1)+"   department :"+cursor.getString(2);
            arrayAdapter.add(data);
            cursor.moveToNext();
        }
        Button btn=(Button)findViewById(R.id.backs);
        Button delete=(Button)findViewById(R.id.editt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(students_Display.this,admin_page.class);
                startActivity(i);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(students_Display.this,update_delete.class);
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
