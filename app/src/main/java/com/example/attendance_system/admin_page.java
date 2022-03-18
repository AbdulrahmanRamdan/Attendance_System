package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        Button outbutton=(Button)findViewById(R.id.logoutbtn);
        Button addstbtn=(Button)findViewById(R.id.addstudentbutton);
        Button veiwtbtn=(Button)findViewById(R.id.button2);
        Button veiwtbtn2=(Button)findViewById(R.id.veiwfacolutybtn);
        Button up_del=(Button)findViewById(R.id.deldtn);
        Button add_fac=(Button)findViewById(R.id.attendancebtn4) ;
        addstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin_page.this,addnewstudent.class);
                startActivity(i);
            }
        });
        veiwtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin_page.this,students_Display.class);
                startActivity(i);
            }
        });
        up_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin_page.this,update_delete.class);
                startActivity(i);
            }
        });
        add_fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin_page.this,addnewfaculty.class);
                startActivity(i);
            }
        });
        veiwtbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(admin_page.this,dispayfacluties.class);
                startActivity(i);
            }
        });
        outbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(admin_page.this,MainActivity.class);
                startActivity(ii);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
