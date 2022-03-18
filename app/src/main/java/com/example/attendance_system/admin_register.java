package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);
        Button finish=(Button)findViewById(R.id.finish);
        final EditText nam=(EditText)findViewById(R.id.nameeditText) ;
        final EditText idd=(EditText)findViewById(R.id.ideditText2) ;
        final EditText phon=(EditText)findViewById(R.id.phoneeditText3) ;
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String name=nam.getText().toString();
             String id=idd.getText().toString();
             String phone=phon.getText().toString();
                Toast.makeText(getApplicationContext(),"name :"+name+"id:"+id+"phone:"+phone,Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
