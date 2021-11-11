package com.example.nolanapk.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Article;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Partner;
import com.example.nolanapk.clases.Sale;
import com.example.nolanapk.clases.Tabla;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {

    ArrayList<Article> filteredArticles = new ArrayList<>();
    ArrayAdapter<Partner> adapter;
    Spinner spin;
    TextView date;
    TextView total;
    int id;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        spin = findViewById(R.id.spin_partner);

        date = findViewById(R.id.order_date);

        id = Integer.parseInt(getIntent().getStringExtra("saleId"));

        total = findViewById(R.id.total);

        TextView orderId = findViewById(R.id.saleName);
        orderId.setText("Sale: " + getIntent().getStringExtra("saleCode"));
        Tabla tabla = new Tabla(this, (TableLayout) findViewById(R.id.tableOrders));
        fillSpinner();
        fillDate();
        filterArticles();
        for (Article s : filteredArticles) {
            ArrayList<String> elementos = new ArrayList<>();
            elementos.add(s.getName());
            elementos.add(Integer.toString(s.getQuantity()));
            elementos.add(s.getUnitPrice() + " €");
            elementos.add(Integer.toString(s.getId()));

            tabla.agregarFilaTabla(elementos, "delete");
        }

    }

    public void filterArticles() {

        filteredArticles.clear();
        for (Article a : Connexion.articles) {
            if (a.getSaleId() == id) {
                filteredArticles.add(a);
            }
        }
    }

    public void fillSpinner() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Connexion.partners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    public void fillDate() {
        for (Sale s : Connexion.sales) {
            if (id == s.getId()) {
                date.setText(s.getDate().toString());
                Partner p = orderPartner(s.getPartnerName());
                int spinnerPosition = adapter.getPosition(p);
                spin.setSelection(spinnerPosition);
                total.setText("Order total: " + s.getTotalprice() + " €");
            }
        }
    }

    public Partner orderPartner(String partner) {
        for (Partner p : Connexion.partners) {
            if (p.getName().equals(partner)) {
                return p;
            }
        }
        return null;
    }
}