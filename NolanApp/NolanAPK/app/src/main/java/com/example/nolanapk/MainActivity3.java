package com.example.nolanapk;

import static com.example.nolanapk.Connexion.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    EditText contra;
    EditText user;
    String userTxt;
    String contraTxt;
    Connexion con;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        con = new Connexion();
    }

    /**
     * OnClick Login Button --> nextScreen()
     */
    public void nextScreen(View v) {
        contra = (EditText) findViewById(R.id.password);
        user = (EditText) findViewById(R.id.username);

        userTxt=user.getText().toString();
        contraTxt=contra.getText().toString();

        /**
         * Erabiltzaile edo Pasahitza betetzen ez direnean abisu batzuk agertuko dira
         */
        if (contraTxt.equals("") && userTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Empty fields", Toast.LENGTH_SHORT).show();
        } else if (contraTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter a password", Toast.LENGTH_SHORT).show();
        } else if (userTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter a username", Toast.LENGTH_SHORT).show();
        } else {
            /**
             * correctUser() Metodoari deitu eta datuak ondo badaude hurrengo Activity-ra eramango gaitu
             */
            if (correctUser()) {
                Intent b = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(b);
            }
        }

    }

    /**
     * Metodo honetan CSV bat irakurriz Erabiltzailea eta Pasahitza ondo dagoen komprobatzen da
     */
    public boolean correctUser() {
        Statement st;
        ResultSet rd = null;
        String linea;
        /** InputStream data = getResources().openRawResource(R.raw.users);
         BufferedReader rd = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
         String linea = null;
         String[] users;*/
        try {
            st = (Statement) con.getExtraConnection().createStatement().executeQuery("SELECT * FROM app_users");
            rd=st.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            while (rd.next()) {
                if (rd.getString("email").equals(userTxt)) {
                    if (rd.getString("password").equals(contraTxt)) {
                        return true;
                    } else {
                        Toast.makeText(MainActivity3.this, "Password incorrect", Toast.LENGTH_SHORT).show();
                        contra.setText("");
                        return false;
                    }

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Toast.makeText(MainActivity3.this, "User not found", Toast.LENGTH_SHORT).show();
        contra.setText("");
        user.setText("");

        return false;

    }
}