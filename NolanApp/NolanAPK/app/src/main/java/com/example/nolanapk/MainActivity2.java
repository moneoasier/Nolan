package com.example.nolanapk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MainActivity2 extends AppCompatActivity {

    String code;
    TextView id;
    TextView txt;
    TextView precio;
    TextView stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id=findViewById(R.id.code);
        txt=findViewById(R.id.text);
        precio=findViewById(R.id.precio);
        stock=findViewById(R.id.stock);
        code= getIntent().getStringExtra("gafa");

        fillData();
    }

    @SuppressLint("SetTextI18n")
    public void fillData(){
        String[] elements=code.split(",");

        id.setText(elements[0]);
        txt.setText(elements[1]);
        precio.setText(elements[2]+" €");
        stock.setText("STOCK: "+elements[3]);

    }
}