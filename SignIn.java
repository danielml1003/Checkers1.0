package com.nbb.aaa.chess_tacticts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText password;
    Button signin;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.ETuser);
        password = findViewById(R.id.ETpassword);
        signin = findViewById(R.id.btnSignIn);
        register = findViewById(R.id.btnSignUp);
        register.setOnClickListener(this);
        signin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == register)
        {
            Intent intent = new Intent (this,SignupActivty.class);
            startActivity(intent);
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
        if(v == signin)
        {
            User u = new User(username.getText().toString(),password.getText().toString());
            if(SignupActivty.dbmu.isExist(u) == true)
            {
                Intent intent = new Intent (this,Lvl_Exrcise.class);
                Toast.makeText(this, "sign in completed", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

        }

    }


}
