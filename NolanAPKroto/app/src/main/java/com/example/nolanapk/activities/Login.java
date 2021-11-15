package com.example.nolanapk.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.User;

public class Login extends AppCompatActivity {

    EditText contra;
    EditText user;
    String userTxt;
    String contraTxt;
    public static Connexion con;
    boolean connectOk;
    public static int user_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        con = new Connexion();
        con.connect("users");
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
            Toast.makeText(Login.this, "Empty fields", Toast.LENGTH_SHORT).show();
        } else if (contraTxt.equals("")) {
            Toast.makeText(Login.this, "Enter a password", Toast.LENGTH_SHORT).show();
        } else if (userTxt.equals("")) {
            Toast.makeText(Login.this, "Enter a username", Toast.LENGTH_SHORT).show();
        } else {
            /*
              correctUser() Metodoari deitu eta datuak ondo badaude hurrengo Activity-ra eramango gaitu
             */
                if (connectOk){
                    if (correctUser()) {
                        Intent b = new Intent(Login.this, Inventario.class);
                        startActivity(b);
                        Login.con.connect("partners");
                        Login.con.connect("gafas");
                    }
                } else {
                    Toast.makeText(Login.this, "Conexion failed", Toast.LENGTH_SHORT).show();
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
                user_id = u.getId();
                return true;
            } else if(u.getPassword().equals(contraTxt) && !u.isActive()) {
                Toast.makeText(Login.this, "Disabled user", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                Toast.makeText(Login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                contra.setText("");
                return false;
            }
        }

        Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
        contra.setText("");
        user.setText("");

        return false;

    }
}