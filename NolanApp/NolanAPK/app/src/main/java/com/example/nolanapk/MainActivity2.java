package com.example.nolanapk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    String code;
    TextView id;
    TextView txt;
    ImageView picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id=findViewById(R.id.code);
        txt=findViewById(R.id.text);
        code= getIntent().getStringExtra("gafa");

        picture = findViewById(R.id.img);

        fillData();
    }

    @SuppressLint("SetTextI18n")
    public void fillData(){
        String[] elements=code.split(",");
        id.setText(elements[0]+" - "+elements[4]);
        txt.setText(elements[1]+"\n\n"+"Stock: "+elements[3]+
                " - Price: "+elements[2]+" €");

        int img_res = getResources().getIdentifier("@drawable/"+elements[0].toLowerCase(), null, getPackageName());
        picture.setImageResource(img_res);



    }
}