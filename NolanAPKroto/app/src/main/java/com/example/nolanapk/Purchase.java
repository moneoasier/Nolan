package com.example.nolanapk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Purchase extends AppCompatActivity {

    public Spinner spinp;
    static TextView pstotal;
    static TextView piva;
    static TextView ptotal;
    static Double total;
    static Double iva;
    static Double totaliva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase);

        //Boton Nuevo Cliente --> NewPartner
        spinp =findViewById(R.id.spin_partner);
        ArrayAdapter<Partner> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Connexion.partners);
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
            elementos.add(Double.toString(Connexion.compra.get(i).getPrecioCantidad()));

            tabla.agregarFilaTabla(elementos);
        }

       calculateTotal();

    }

    public void tramitar(View v){
        if(Connexion.compra.size()>0) {
            Connexion.insertOrder(Login.user_id, Connexion.partners.get(spinp.getSelectedItemPosition()).getId(), total, iva, totaliva);
        } else {
            Toast.makeText(Purchase.this,"No items selected!",Toast.LENGTH_SHORT).show();
        }

    }

    public void bezeroberri(View v){
        Intent b = new Intent(Purchase.this, Bezeroa.class);
        startActivity(b);


    }

    @SuppressLint("SetTextI18n")
    public static void calculateTotal(){
        total=0.00;
        iva=0.00;
        totaliva=0.00;
        if(Connexion.compra.size()>0){
            for (Gafa g:
                    Connexion.compra) {
                totaliva+= g.getPrecioCantidad();
                iva+=g.getIvaCantidad();
                total+=g.getPrecioTotal();

            }
        }

        ptotal.setText(Double.toString(Math.round(total*100.0)/100.0));
        piva.setText(Double.toString(Math.round(iva*100.0)/100.0));
        pstotal.setText(Double.toString(Math.round(totaliva*100.0)/100.0));
    }


}