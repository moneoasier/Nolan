package com.example.nolanapk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Partner;

public class Bezeroa extends AppCompatActivity {
    EditText name;
    EditText address;
    EditText cp;
    EditText city;
    EditText email;
    EditText phone;
    CheckBox company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bezeroa);

        name = findViewById(R.id.nametxt);
        address = findViewById(R.id.addresstxt);
        cp = findViewById(R.id.cptxt);
        city = findViewById(R.id.citytxt);
        email = findViewById(R.id.mailtxt);
        phone = findViewById(R.id.phonetxt);
        company = findViewById(R.id.companyck);
    }

    /*
        Submit botoia klikatzean listara gehitzen da eta Odoon aldatzen da ere
     */
    public void submit(View v) {

        String nametxt = name.getText().toString();
        String addresstxt = address.getText().toString();
        String cptxt = cp.getText().toString();
        String citytxt = city.getText().toString();
        String emailtxt = email.getText().toString();
        String phonetxt = phone.getText().toString();
        boolean companychbx = company.isChecked();



        if (check(nametxt, cptxt, citytxt, addresstxt, emailtxt, phonetxt) && checkemail()) {
            Partner p = new Partner(Connexion.partner_ID,nametxt, addresstxt, cptxt, citytxt, emailtxt, phonetxt, companychbx);
            Connexion.partners.add(p);
            Login.con.insertPartner(p);

            Toast.makeText(Bezeroa.this, "Bezeroa sortu da.", Toast.LENGTH_SHORT).show();

            Intent b = new Intent(Bezeroa.this, Purchase.class);
            startActivity(b);

        }

    }

    /*
        Datu guztiak ondo sartuta daude egiaztatzen du
     */

    public boolean check(String nametxt, String cptxt, String citytxt, String addresstxt, String emailtxt, String phonetxt) {

        if (nametxt.equals(" ") && citytxt.equals(" ") && addresstxt.equals(" ") && emailtxt.equals(" ") && phonetxt.equals(" ")) {

            Toast.makeText(Bezeroa.this, "Eremu guztiak bete behar dira.", Toast.LENGTH_SHORT).show();
            return false;

        } else if (nametxt.equals("") && citytxt.equals("") && addresstxt.equals("") && emailtxt.equals("") && phonetxt.equals("")) {

            Toast.makeText(Bezeroa.this, "Eremu guztiak bete behar dira.", Toast.LENGTH_SHORT).show();
            return false;

        } else if (!nametxt.matches("[a-zA-Z ]+")) {

            Toast.makeText(Bezeroa.this, "Izena eremua ondo bete behar da.", Toast.LENGTH_SHORT).show();
            return false;

        } else if (!citytxt.matches("[a-zA-Z ]+")) {

            Toast.makeText(Bezeroa.this, "Hiria eremua ondo bete behar da.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!(cptxt.length() == 5)) {

            Toast.makeText(Bezeroa.this, "CP-a 5 luzerako zenbakia izan behar du.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (addresstxt.equals(" ") || addresstxt.equals("")) {

            Toast.makeText(Bezeroa.this, "Helbide eremua bete behar da.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (phonetxt.equals(" ") || phonetxt.equals("")) {

            Toast.makeText(Bezeroa.this, "Telefono zenbaki eremua bete behar da.", Toast.LENGTH_SHORT).show();
            return false;

        } else if (phonetxt.length() != 9) {

            Toast.makeText(Bezeroa.this, "Telefono zenbakia 9 digito izan behar ditu.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }

    /*
        Emaila baliogarria den egiaztatzen du
     */
    public boolean checkemail() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "enter email address", Toast.LENGTH_SHORT).show();
            return false;

        } else {

            if (!email.getText().toString().trim().matches(emailPattern)) {

                Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }


}



