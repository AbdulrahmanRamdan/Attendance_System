package com.example.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String username_of_admin = "admin";
        final String password_of_admin = "admin1234";

        Button login_Button = (Button) findViewById(R.id.logindtn);
        Button reg_b=(Button)findViewById(R.id.register);
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = (Spinner) findViewById(R.id.login_spinner);
                EditText user_name_text = (EditText) findViewById(R.id.usertext);
                EditText pass_word_text = (EditText) findViewById(R.id.pass_word);
                String usernametext = user_name_text.getText().toString();
                String passwordtext = pass_word_text.getText().toString();
                if (spinner.getSelectedItem().toString().equals("admin")) {
                    if (usernametext.equals(username_of_admin) && passwordtext.equals(password_of_admin)) {
                        Toast.makeText(getApplicationContext(), "admin signed succesed", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,admin_page.class);
                        startActivity(i);
                    }
                    else Toast.makeText(getApplicationContext(), "login failed checked your data and try again", Toast.LENGTH_SHORT).show();
                } else if (spinner.getSelectedItem().toString().equals("faculty")) {
                    faculty_Datahelper FHP = new faculty_Datahelper(getApplicationContext());
                    String name = user_name_text.getText().toString();
                    String password = pass_word_text.getText().toString();
                    String pass = FHP.get_pass_word(name);
                    if (pass.equals(password)) {
                        Toast.makeText(getApplicationContext(), "facoluty signed succesed", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity.this, faculty_page.class);
                        startActivity(i);
                       }
                }else {
                    Toast.makeText(getApplicationContext(), "login failed checked your data and try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
        reg_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = (Spinner) findViewById(R.id.login_spinner);
                EditText user_name_text = (EditText) findViewById(R.id.usertext);
                EditText pass_word_text = (EditText) findViewById(R.id.pass_word);
                String usernametext = user_name_text.getText().toString();
                String passwordtext = pass_word_text.getText().toString();
                if (spinner.getSelectedItem().toString().equals("admin")) {
                    if (usernametext.equals(username_of_admin) && passwordtext.equals(password_of_admin)) {
                        Toast.makeText(getApplicationContext(), "admin signed succesed", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,admin_register.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(getApplicationContext(), "login failed checked your data and try again", Toast.LENGTH_SHORT).show();
                    }}else {
                    Toast.makeText(getApplicationContext(), "login failed checked your data and try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
