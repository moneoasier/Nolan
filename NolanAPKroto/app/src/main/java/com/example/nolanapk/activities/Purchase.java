package com.example.nolanapk.activities;

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

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Gafa;
import com.example.nolanapk.clases.Partner;
import com.example.nolanapk.clases.TableView;

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
        spinp =findViewById(R.id.spin_partner);
        ArrayAdapter<Partner> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Connexion.partners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinp.setAdapter(adapter);

        pstotal = findViewById(R.id.txt_subtotal);
        piva = findViewById(R.id.txt_iva);
        ptotal = findViewById(R.id.txt_total);

        TableView tabla = new TableView(this, findViewById(R.id.tabla));
        for(int i = 0; i < Connexion.compra.size(); i++)
        {
            ArrayList<String> elementos = new ArrayList<>();
            elementos.add(Connexion.compra.get(i).getId());
            elementos.add(Integer.toString(Connexion.compra.get(i).getCantidad()));
            elementos.add(Connexion.compra.get(i).getPrecioCantidad()+" €");
            elementos.add("");

            tabla.agregarFilaTabla(elementos,"x");
        }

       calculateTotal();

    }

    public void tramitar(View v){
        if(Connexion.compra.size()>0) {
            Login.con.insertOrder(Login.user_id, Connexion.partners.get(spinp.getSelectedItemPosition()).getId(), total, iva, totaliva);
            Toast.makeText(Purchase.this,"Purchase done!",Toast.LENGTH_SHORT).show();
            Intent b = new Intent(Purchase.this, Inventario.class);
            startActivity(b);

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
                total+= Math.round(g.getPrecioCantidad()*100.0)/100.0;
                iva+=Math.round(g.getIvaCantidad()*100.0)/100.0;
                totaliva+=Math.round(g.getPrecioTotal()*100.0)/100.0;

            }
        }

        ptotal.setText(Double.toString(totaliva));
        piva.setText(Double.toString(iva));
        pstotal.setText(Double.toString(total));
    }


}