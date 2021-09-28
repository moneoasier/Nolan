package com.example.pruebagafas;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Gafa> gafas= new ArrayList<>();
        TextView txt=findViewById(R.id.txt);

        try {
            String file ="InventarioGafas.csv";
            BufferedReader rd = new BufferedReader(new FileReader(file));

            String linea=null;
            String[] gafa;
            while ((linea=rd.readLine())!=null){
                Log.d("gafa","hola");
                gafa=linea.split(",");
                gafas.add(new Gafa(gafa[0],gafa[1],Integer.parseInt(gafa[2])));

            }
            txt.setText(gafas.get(0).toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public final List<String[]> readCsv(Context context) {
        List<String[]> questionList = new ArrayList<String[]>();
        AssetManager assetManager = context.getAssets();

        try {
            InputStream csvStream = assetManager.open(CSV_PATH);
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
            CSVReader csvReader = new CSVReader(csvStreamReader);
            String[] line;

            // throw away the header
            csvReader.readNext();

            while ((line = csvReader.readNext()) != null) {
                questionList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionList;
    }

}