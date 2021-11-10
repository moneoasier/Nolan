package com.example.nolanapk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Sale;
import com.example.nolanapk.clases.Tabla;

import java.util.ArrayList;

public class Sales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tableOrders));
        for(Sale s:Connexion.sales)
        {
            ArrayList<String> elementos = new ArrayList<>();
            elementos.add(s.getName());
            elementos.add(s.getPartnerName());
            elementos.add(String.valueOf(s.getDate()));
            elementos.add(s.getTotalprice()+" €");
            elementos.add(Integer.toString(s.getId()));

            tabla.agregarFilaTabla(elementos,"see");
        }
    }



}