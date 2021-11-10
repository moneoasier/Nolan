package com.example.nolanapk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Article;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Sale;
import com.example.nolanapk.clases.Tabla;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {

    ArrayList<Article> filteredArticles=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tableOrders));
        filterArticles();
        for(Article s: filteredArticles)
        {
            ArrayList<String> elementos = new ArrayList<>();
            elementos.add(s.getName());
            elementos.add(Integer.toString(s.getQuantity()));
            elementos.add(s.getUnitPrice()+" €");
            elementos.add("");
            tabla.agregarFilaTabla(elementos,"");
        }

    }

    public void filterArticles(){
        Log.d("Saleintent","" +getIntent().getStringExtra("saleId"));
        int id=Integer.parseInt(getIntent().getStringExtra("saleId"));
        filteredArticles.clear();
        for (Article a:Connexion.articles) {
            if(a.getSaleId()== id){
                filteredArticles.add(a);
            }
        }
    }
}