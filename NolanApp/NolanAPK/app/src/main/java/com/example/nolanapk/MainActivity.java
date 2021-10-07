package com.example.nolanapk;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Aldagai globalen deklarazioa
    ImageView b1;
    ImageView b2;
    ImageView b3;
    ImageView b4;

    TextView pages;

    Spinner spin;

    int totalPages;
    int currentPage=1;
    int start=1;

    Button search;

    String selection="All";

    ArrayList<Gafa> allGafas = new ArrayList<>();
    ArrayList<Gafa> gafaFiltro = new ArrayList<>();

    @SuppressLint("CutPasteId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //Aplikazioa abiaraztean aldagaiei emandako balioak
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        pages=findViewById(R.id.npg);

        search=findViewById(R.id.search);

        spin=findViewById(R.id.filter);

        //Metodo hauei deitzen zaie aplikazioa abiaraztean
        readData();
        showData(start,allGafas);


    }

    //Metodo honek MainActivity2 irekitzen du ImageView bat klikatzean
    public void nextScreen(View v){

        Intent b = new Intent(MainActivity.this, MainActivity2.class);

        String valor= v.getTag().toString();
        //Balio bat gordetzen du MainActivity2-ra pasatzeko
        b.putExtra("gafa",findGafa(valor));
        startActivity(b);
    }

    //String bat hartzen du eta ArrayList allGafas-eko elementuekin konparatzen du, balio berdina duen elementua aurkitzean, elementu hori bueltatuko du
    public String findGafa(String name){
        for(Gafa g: allGafas){
            if(g.getId().toLowerCase().equals(name)){
                return g.toString();
            }
        }
        return null;
    }

    //next edo previous botoiak klikatzean atzera edo aurrera joaten da erregistroen zehar
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void btnChange(View v){
        switch (v.getId()) {
            case R.id.next:

                //goToNextPage true bada hurrengo 4 erregistroak erakusten ditu
                // aukeratutako balioaren arabera betaurreko guztiak edo filtratuak erakusten ditu
                if (goToNextPage()) {
                    start += 4;
                    if (selection.equals("All")){
                        showData(start,allGafas);
                    } else {
                        showData(start,gafaFiltro);
                    }

                    currentPage++;
                    pages.setText(currentPage +" / "+ totalPages);
                }
                break;

            //goToPreviousPage true bada aurreko 4 erregistroak erakusten ditu
            // aukeratutako balioaren arabera betaurreko guztiak edo filtratuak erakusten ditu
            case R.id.back:
                if (goToPreviousPage()) {
                    start -= 4;
                    if (selection.equals("All")){
                        showData(start,allGafas);
                    } else {
                        showData(start,gafaFiltro);
                    }
                    currentPage--;
                    pages.setText(currentPage +" / "+ totalPages);
                }
                break;

        }
    }

    public boolean goToNextPage(){

        return currentPage != totalPages;
    }

    public boolean goToPreviousPage(){
        return currentPage>1;
    }

    //gafas.csv fitxategiaren datuak irakurri eta ArrayList batean gordetzen ditu
    @SuppressLint("SetTextI18n")
    public void readData() {

        InputStream data = getResources().openRawResource(R.raw.gafas);
        BufferedReader rd = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8));
        String linea;
        String[] gafa;

        try {
            while ((linea = rd.readLine()) != null) {
                gafa = linea.split(",");
                allGafas.add(new Gafa(gafa[0], gafa[1], Double.parseDouble(gafa[2]),Integer.parseInt(gafa[3]),gafa[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        calculatePages(allGafas);
        pages.setText(currentPage +" / "+ totalPages);
    }

    //ArrayList bateko erregistro kopuruaren arabera, zenbat orri izango dituen aplikazioa kalkulatzen du
    public void calculatePages(ArrayList<Gafa> g){
        if(g.size()%4==0){
            totalPages=g.size()/4;
        } else {
            totalPages=(g.size()/4)+1;
        }
    }

    //zenbaki bat eta erakutsi nahi diren erregistroen ArrayList-a hartzen ditu eta hurrengo edo aurreko 4 erregistroak erakusten ditu
    public void showData(int start,ArrayList<Gafa> g) {
        start--;
        if (start < g.size()) {
            img(b1,start,g);
        }
        start++;
        if (start < g.size()) {
            b2.setVisibility(View.VISIBLE);
            img(b2,start,g);
        } else {
            b2.setVisibility(View.INVISIBLE);
        }
        start++;
        if (start < g.size()) {
            b3.setVisibility(View.VISIBLE);
            img(b3,start,g);
        } else {
            b3.setVisibility(View.INVISIBLE);
        }
        start++;
        if (start < g.size()) {
            b4.setVisibility(View.VISIBLE);
            img(b4,start,g);
        } else {
            b4.setVisibility(View.INVISIBLE);
        }
    }

    //ImageView, zenbakia eta ArrayList bat hartzen ditu eta irudi bat ipintzen dio ImageView-ra
    public void img(ImageView image, int position,ArrayList<Gafa> g){
        String img_value = "@drawable/"+g.get(position).getId().toLowerCase();
        image.setTag(g.get(position).getId().toLowerCase());
        int img_res = getResources().getIdentifier(img_value,null, getPackageName());
        image.setImageResource(img_res);
    }

    //SEARCH botoia klikatzean, aukeratutako filtroaren arabera erregistroak aldatzen ditu
    @SuppressLint("SetTextI18n")
    public void filterGafas(View v){
        start = 1;
        selection=spin.getSelectedItem().toString();
        if(!selection.equals("All")) {
            gafaFiltro.clear();

            for (Gafa g : allGafas) {
                if (selection.equals(g.getCategory())) {
                    gafaFiltro.add(g);
                }
            }
            calculatePages(gafaFiltro);
            showData(start, gafaFiltro);
        } else {
            calculatePages(allGafas);
            showData(start,allGafas);
        }
        currentPage=1;
        pages.setText(currentPage +" / "+ totalPages);
    }

}

