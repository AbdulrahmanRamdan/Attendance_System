package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class addnewstudent extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_addnewstudent);
    final student st=new student(getApplicationContext());
    Button add=(Button)findViewById(R.id.addf);
    Button back=(Button)findViewById(R.id.backf);
    final EditText name_of_s=(EditText)findViewById(R.id.namef) ;
    final EditText id_of_s=(EditText)findViewById(R.id.ids) ;
    final Spinner spinner=(Spinner)findViewById(R.id.debspinner) ;
    back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent iii=new Intent(addnewstudent.this,admin_page.class);
        startActivity(iii);
      }
    });
    add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String name=name_of_s.getText().toString();
        String id=id_of_s.getText().toString();
        String dep=spinner.getSelectedItem().toString();
        st.create_student(name,id,dep);
        Toast.makeText(getApplicationContext(),"added sucessed",Toast.LENGTH_SHORT).show();
      }
    });
  }
  @Override
  public void onBackPressed() {
    super.onBackPressed();
    this.finish();
  }
}
