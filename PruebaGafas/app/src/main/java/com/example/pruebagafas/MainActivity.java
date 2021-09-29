package com.example.pruebagafas;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Gafa> gafas = new ArrayList<>();
    LinearLayout lay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay=findViewById(R.id.l);

        readData();
        showData();

    }

    public void readData() {

        InputStream data = getResources().openRawResource(R.raw.gafas);
        BufferedReader rd = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
        String linea = null;
        String[] gafa;

        try {
            while ((linea = rd.readLine()) != null) {
                gafa = linea.split(",");
                gafas.add(new Gafa(gafa[0], gafa[1], Integer.parseInt(gafa[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void showData(){
        for (Gafa g : gafas) {
            Button btn = new Button(this);
            btn.setText(g.getId());
            lay.addView(btn);
        }
    }

}