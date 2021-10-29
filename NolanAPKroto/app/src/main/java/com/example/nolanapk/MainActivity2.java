package com.example.nolanapk;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    String code;
    TextView id;
    TextView txt;
    ImageView picture;
    String[] elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id=findViewById(R.id.code);
        txt=findViewById(R.id.text);
        code= getIntent().getStringExtra("gafa");
        elements=code.split(",");

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
        MainActivity.compra.add(new Gafa(elements[0],elements[1],Double.parseDouble(elements[2]),Integer.parseInt(elements[3]),elements[4]));

    }

}