package com.example.nolanapk;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Purchase extends AppCompatActivity {

    Spinner spinp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase);

        spinp =findViewById(R.id.spin_partner);


    }
}
