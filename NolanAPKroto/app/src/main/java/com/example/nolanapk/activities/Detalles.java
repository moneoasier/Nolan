package com.example.nolanapk.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Gafa;

public class Detalles extends AppCompatActivity {

    String code;
    TextView id;
    TextView txt;
    ImageView picture;
    EditText quant;
    Gafa gafa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);

        id = findViewById(R.id.code);
        txt = findViewById(R.id.text);
        code = getIntent().getStringExtra("gafa");
        quant = findViewById(R.id.Qty_txt);
        picture = findViewById(R.id.img);

        fillData();
    }

    /**
     * Metodo honek produktuen informazioa ipintzen du: argazkia, izena, Stock-ean dagoen kantitatea eta prezioa
     */
    @SuppressLint("SetTextI18n")
    public void fillData() {
        findGafa();
        id.setText(gafa.getId() + " - " + gafa.getCategory());
        txt.setText(gafa.getNombre() + "\n\n" + "Stock: " + gafa.getStock() +
                " - Price: " + gafa.getPrecio() + " €");

        int img_res = getResources().getIdentifier("@drawable/" + gafa.getId().toLowerCase(), null, getPackageName());
        picture.setImageResource(img_res);

    }

    public void findGafa(){
        for(Gafa g:Inventario.allGafas){
            if(g.getId().equals(code)){
                gafa=g;
                break;
            }
        }
    }

    public void addProduct(View v) {
        String c = quant.getText().toString();
        if (c.isEmpty() || c.equals("0")) {
            Toast.makeText(Detalles.this, "Insert Quantity", Toast.LENGTH_SHORT).show();
        } else if (!checkquanty()) {
            Toast.makeText(Detalles.this, "Ez dago stock nahikorik", Toast.LENGTH_SHORT).show();

        } else {
            if (!inCompra()) {
                gafa.setCantidad(Integer.parseInt(quant.getText().toString()));
                Connexion.compra.add(gafa);
            }

            Toast.makeText(Detalles.this, "Product Added", Toast.LENGTH_LONG).show();
            //Log.d("Gafa",Inventario.compra.get(Inventario.compra.size()-1).toString());
        }


    }

    public boolean inCompra() {
        for (Gafa g : Connexion.compra) {
            if (g.getId().equals(gafa.getId())) {
                g.setCantidad(g.getCantidad() + Integer.parseInt(quant.getText().toString()));
                g.setPrecios();
                return true;
            }
        }
        return false;
    }

    public void btnBuy(View v) {
        Intent b = new Intent(Detalles.this, Purchase.class);
        startActivity(b);
    }

    public boolean checkquanty() {
        if (Integer.parseInt(quant.getText().toString()) > gafa.getStock()) {
            return false;
        }
        return true;
    }

}