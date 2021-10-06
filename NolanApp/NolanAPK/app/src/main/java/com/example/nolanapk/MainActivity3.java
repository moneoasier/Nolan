package com.example.nolanapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity3 extends AppCompatActivity {
    EditText contra;
    EditText user;
    String userTxt;
    String contraTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    public void nextScreen(View v) {
        contra = (EditText) findViewById(R.id.password);
        user = (EditText) findViewById(R.id.username);
        userTxt=user.getText().toString();
        contraTxt=contra.getText().toString();
        if (contraTxt.equals("") && userTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Empty fields", Toast.LENGTH_SHORT).show();
        } else if (contraTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter a password", Toast.LENGTH_SHORT).show();
        } else if (userTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter a username", Toast.LENGTH_SHORT).show();
        } else {
            if (correctUser()) {
                Intent b = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(b);
            }
        }

    }

    public boolean correctUser() {
        InputStream data = getResources().openRawResource(R.raw.users);
        BufferedReader rd = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
        String linea = null;
        String[] users;
        try {
            while ((linea = rd.readLine()) != null) {
                users = linea.split(",");
                if (users[0].equals(userTxt)) {
                    if (users[1].equals(contraTxt)) {
                        return true;
                    } else {
                        Toast.makeText(MainActivity3.this, "Password incorrect", Toast.LENGTH_SHORT).show();
                        contra.setText("");
                        return false;
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        Toast.makeText(MainActivity3.this, "User not found", Toast.LENGTH_SHORT).show();
        contra.setText("");
        user.setText("");

        return false;

    }
}