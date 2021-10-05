package com.example.nolanapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText contra;
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }
    public void nextScreen(View v){
        contra = (EditText) findViewById(R.id.password);
        user= (EditText) findViewById(R.id.username);
        if(contra.getText().toString().equals("Admin123")){
            Intent b = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(b);
            contra.setText("");
            user.setText("");
        }else{
            Toast.makeText(MainActivity3.this, "Password incorrect", Toast.LENGTH_SHORT).show();
            contra.setText("");
            user.setText("");
        }

    }
}