package com.example.nolanapk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Detalles extends AppCompatActivity {

    String code;
    TextView id;
    TextView txt;
    ImageView picture;
    String[] elements;
    EditText quant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);

        id=findViewById(R.id.code);
        txt=findViewById(R.id.text);
        code= getIntent().getStringExtra("gafa");
        elements=code.split(",");
        quant= findViewById(R.id.Qty_txt);
        picture = findViewById(R.id.img);

        fillData();
    }
    /**
     * Metodo honek produktuen informazioa ipintzen du: argazkia, izena, Stock-ean dagoen kantitatea eta prezioa
     */
    @SuppressLint("SetTextI18n")
    public void fillData(){

        id.setText(elements[0]+" - "+elements[4]);
        txt.setText(elements[1]+"\n\n"+"Stock: "+elements[3]+
                " - Price: "+elements[2]+" €");

        int img_res = getResources().getIdentifier("@drawable/"+elements[0].toLowerCase(), null, getPackageName());
        picture.setImageResource(img_res);

    }

    public void addProduct(View v) {
        String c = quant.getText().toString();
        if(c.isEmpty()||c.equals("0")){
            Toast.makeText(Detalles.this,"Insert Quantity",Toast.LENGTH_SHORT).show();
        }else{
            Gafa gafax = new Gafa(elements[0],elements[1],Double.parseDouble(elements[2]),Integer.parseInt(elements[3]),elements[4]);
            gafax.setCantidad(Integer.parseInt(c));
            Inventario.compra.add(gafax);
            //Log.d("Gafa",Inventario.compra.get(Inventario.compra.size()-1).toString());
        }


    }

}