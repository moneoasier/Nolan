package com.example.nolanapk;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button btn;
    ArrayList<Gafa> gafas = new ArrayList<>();
    int start=1;
    ConstraintLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        l=findViewById(R.id.constraint);
        readData();
        showData(start);

        /*b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(b);
            }
        });*/

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //method for switch
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start+=4;
                showData(start);
            }
        });

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(start>1) {
                    start -= 4;
                    showData(start);
                }
            }
        });

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

    public void showData(int start) {
        start--;
        if (start < gafas.size()) {
            b1.setText(gafas.get(start).getNombre());
        } else {
            b1.setText("");
        }
        start++;
        if (start < gafas.size()) {
            b2.setText(gafas.get(start).getNombre());
        } else {
            b2.setText("");
        }
        start++;
        if (start < gafas.size()) {
            b3.setText(gafas.get(start).getNombre());
        } else {
            b3.setText("");
        }
        start++;
        if (start < gafas.size()) {
            b4.setText(gafas.get(start).getNombre());
        } else {
            b4.setText("");
        }
    }

}

