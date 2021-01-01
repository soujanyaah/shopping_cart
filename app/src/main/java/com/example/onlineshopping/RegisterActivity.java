package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button btnsignup, btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnsignin = findViewById(R.id.signinbtn);
        btnsignup = findViewById(R.id.signupbtn);

        btnsignup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( RegisterActivity.this, LoginActivity.class );
                Toast.makeText(getApplicationContext(),"REGISTERED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                startActivity(intent );
            }
        } );

        btnsignin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( RegisterActivity.this, LoginActivity.class );
                Toast.makeText(getApplicationContext(),"GO TO SIGN IN",Toast.LENGTH_SHORT).show();
                startActivity(intent );
            }
        } );

    }
}