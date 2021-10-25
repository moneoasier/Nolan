package com.example.nolanapk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText contra;
    EditText user;
    String userTxt;
    String contraTxt;
    Connexion con;
    boolean connectOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        con = new Connexion();
        connectOk=con.isStatus();
    }

    /*
     * OnClick Login Button --> nextScreen()
     */
    public void nextScreen(View v) {
        contra = findViewById(R.id.password);
        user = findViewById(R.id.username);

        userTxt=user.getText().toString();
        contraTxt=contra.getText().toString();

        /*
          Erabiltzaile edo Pasahitza betetzen ez direnean abisu batzuk agertuko dira
         */
        if (contraTxt.equals("") && userTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Empty fields", Toast.LENGTH_SHORT).show();
        } else if (contraTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter a password", Toast.LENGTH_SHORT).show();
        } else if (userTxt.equals("")) {
            Toast.makeText(MainActivity3.this, "Enter a username", Toast.LENGTH_SHORT).show();
        } else {
            /*
              correctUser() Metodoari deitu eta datuak ondo badaude hurrengo Activity-ra eramango gaitu
             */
                if (connectOk){
                    if (correctUser()) {
                        Intent b = new Intent(MainActivity3.this, MainActivity.class);
                        startActivity(b);
                    }
                } else {
                    Toast.makeText(MainActivity3.this, "Conexion failed", Toast.LENGTH_SHORT).show();
                }
            }

    }

    /*
     * Metodo honetan CSV bat irakurriz Erabiltzailea eta Pasahitza ondo dagoen komprobatzen da
     */
    public boolean correctUser() {

        User u= Connexion.findUser(userTxt);

        if(u!=null){
            if(u.getPassword().equals(contraTxt) && u.isActive()) {
                return true;
            } else if(u.getPassword().equals(contraTxt) && !u.isActive()) {
                Toast.makeText(MainActivity3.this, "Disabled user", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                Toast.makeText(MainActivity3.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                contra.setText("");
                return false;
            }
        }

        Toast.makeText(MainActivity3.this, "User not found", Toast.LENGTH_SHORT).show();
        contra.setText("");
        user.setText("");

        return false;

    }
}