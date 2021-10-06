package com.example.nolanapk;

import static android.graphics.Color.rgb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView b1;
    ImageView b2;
    ImageView b3;
    ImageView b4;

    TextView pages;

    int totalPages;
    int currentPage=1;
    int start=1;

    ArrayList<Gafa> gafas = new ArrayList<>();

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        pages=findViewById(R.id.npg);

        readData();
        showData(start);

    }

    public void nextScreen(View v){
        Intent b = new Intent(MainActivity.this, MainActivity2.class);

        String valor= v.getTag().toString();
        b.putExtra("gafa",findGafa(valor));
        startActivity(b);
    }

    public String findGafa(String name){
        for(Gafa g: gafas){
            if(g.getId().toLowerCase().equals(name)){
                return g.toString();
            }
        }
        return null;
    }

    public void btnChange(View v){
        switch (v.getId()) {
            case R.id.next:
                if (goToNextPage()) {
                    start += 4;
                    showData(start);
                    currentPage++;
                    pages.setText(currentPage +" / "+ totalPages);
                }
                break;

            case R.id.back:
                if (start > 1) {
                    start -= 4;
                    showData(start);
                    currentPage--;
                    pages.setText(currentPage +" / "+ totalPages);
                }
                break;

        }
    }

    public boolean goToNextPage(){
        return currentPage != totalPages;
    }

    public void readData() {

        InputStream data = getResources().openRawResource(R.raw.gafas);
        BufferedReader rd = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
        String linea = null;
        String[] gafa;

        try {
            while ((linea = rd.readLine()) != null) {
                gafa = linea.split(",");
                gafas.add(new Gafa(gafa[0], gafa[1], Double.parseDouble(gafa[2]),Integer.parseInt(gafa[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        calculatePages();
        pages.setText(currentPage +" / "+ totalPages);
    }
    public void calculatePages(){
        if(gafas.size()%4==0){
            totalPages=gafas.size()/4;
        } else {
            totalPages=(gafas.size()/4)+1;
        }
    }

    public void showData(int start) {
        start--;
        if (start < gafas.size()) {
            img(b1,start);
        }
        start++;
        if (start < gafas.size()) {
            b2.setVisibility(View.VISIBLE);
            img(b2,start);
        } else {
            b2.setVisibility(View.INVISIBLE);
        }
        start++;
        if (start < gafas.size()) {
            b2.setVisibility(View.VISIBLE);
            img(b3,start);
        } else {
            b3.setVisibility(View.INVISIBLE);
        }
        start++;
        if (start < gafas.size()) {
            b2.setVisibility(View.VISIBLE);
            img(b4,start);
        } else {
            b4.setVisibility(View.INVISIBLE);
        }
    }

    public void img(ImageView image, int position){
        String img_value = "@drawable/"+gafas.get(position).getId().toLowerCase();
        image.setTag(gafas.get(position).getId().toLowerCase());
        int img_res = getResources().getIdentifier(img_value,null, getPackageName());

        //Drawable res = getResources().getDrawable(img_res);
        //image.setImageDrawable(res);
        image.setImageResource(img_res);
    }

}

