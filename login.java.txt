package com.example.rater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    dbHelper d;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        d=new dbHelper(Login.this);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(d.checklogin(username.getText().toString(),password.getText().toString())){
                    getSharedPreferences("pref",MODE_PRIVATE).edit().putString("username",username.getText().toString()).apply();
                    startActivity(new Intent(getApplicationContext(),Employees.class));
                }else{
                    Toast.makeText(Login.this, "false", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }

}
