package com.nbb.aaa.chess_tacticts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivty extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;
    Button register;
    static DataBaseManagerUser dbmu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activty);

        username = findViewById(R.id.ETuser);
        password = findViewById(R.id.ETpassword);
        register = findViewById(R.id.btnSignUp);
        register.setOnClickListener(this);
        dbmu = new DataBaseManagerUser(this);

    }

    @Override
    public void onClick(View v) {
        if(v == register)
        {
            User user = new User(username.getText().toString(),password.getText().toString());
            dbmu.open();
            dbmu.insert(user);
            Intent intent = new Intent (this,SignIn.class);
            startActivity(intent);
            Toast.makeText(this, "register completed ", Toast.LENGTH_SHORT).show();
        }
    }
}
