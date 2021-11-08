package com.example.nolanapk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.ConnectException;
import java.util.ArrayList;

public class Purchase extends AppCompatActivity {

    public Spinner spinp;
    TableLayout tabla;
    TextView txt;
    TextView pstotal;
    TextView piva;
    TextView ptotal;
    Double precio1 = 0.00;
    Double precioiva;
    Double precio2;
    public ArrayList<TableRow> rows;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase);

        //Boton Nuevo Cliente --> NewPartner
        spinp =findViewById(R.id.spin_partner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Connexion.partners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinp.setAdapter(adapter);

        pstotal = (TextView) findViewById(R.id.txt_Subtotal);
        piva = (TextView) findViewById(R.id.txt_iva);
        ptotal = (TextView) findViewById(R.id.txt_total);

        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        for(int i = 0; i < Connexion.compra.size(); i++)
        {
            ArrayList<String> elementos = new ArrayList<>();
            elementos.add(Connexion.compra.get(i).getId());
            elementos.add(Integer.toString(Connexion.compra.get(i).getCantidad()));
            elementos.add(Double.toString(Connexion.compra.get(i).getPrecio()*Connexion.compra.get(i).getCantidad()));

            tabla.agregarFilaTabla(elementos);
        }


    }

    public void tramitar(View v){
        Connexion.insertOrder(Login.user_id,Connexion.partners.get(spinp.getSelectedItemPosition()).getId(),precio1,precioiva,precio2);

    }

    public void bezeroberri(View v){
        Intent b = new Intent(Purchase.this, Bezeroa.class);
        startActivity(b);


    }


}