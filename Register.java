package com.example.rater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    userpojo p;
    dbHelper d;
    EditText password,username,number,confirmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        p=new userpojo();
        d=new dbHelper(Register.this);
        password=findViewById(R.id.password);
        username=findViewById(R.id.username);
        confirmpass=findViewById(R.id.confirmpass);
        number=findViewById(R.id.number);
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean flag=true;
                if(username.getText().toString().equals("")){
                    username.setError("REquired");
                    flag=false;
                }
                if(password.getText().toString().equals("")){
                    password.setError("REquired");
                    flag=false;
                }
                if(number.getText().toString().equals("")){
                    number.setError("REquired");
                    flag=false;
                }
                if(!password.getText().toString().equals(confirmpass.getText().toString())){
                    confirmpass.setError("Must be same");
                    flag=false;
                }
                if(flag) {
                    p.setNumber(number.getText().toString());

                    p.setPassword(password.getText().toString());
                    p.setUsername(username.getText().toString());

                    if(d.insertdata(p)){
                        Toast.makeText(Register.this, "User Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Login.class));
                    }else{

                        Toast.makeText(Register.this, "Cant use same name", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }
}
