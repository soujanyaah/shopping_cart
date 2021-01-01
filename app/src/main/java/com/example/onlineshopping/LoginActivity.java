package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button bnsignin, bnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bnsignin = findViewById(R.id.signin);
        bnsignup = findViewById(R.id.signup);

        bnsignup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( LoginActivity.this, RegisterActivity.class );
                Toast.makeText(getApplicationContext(),"GO TO SIGN UP",Toast.LENGTH_SHORT).show();
                startActivity(intent );
            }
        } );

        bnsignin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent( LoginActivity.this, HomePage.class );
                Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                startActivity(intent );
            }
        } );


    }
}