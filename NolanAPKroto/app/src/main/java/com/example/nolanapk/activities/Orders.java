package com.example.nolanapk.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nolanapk.R;
import com.example.nolanapk.clases.Article;
import com.example.nolanapk.clases.Connexion;
import com.example.nolanapk.clases.Partner;
import com.example.nolanapk.clases.Sale;
import com.example.nolanapk.clases.TableEdit;
import com.example.nolanapk.clases.TableView;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {

    ArrayList<Article> filteredArticles = new ArrayList<>();
    ArrayAdapter<Partner> adapter;
    Spinner spin;
    TextView date;
    TextView total;
    TextView state;
    Button del_sale;
    int id;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        spin = findViewById(R.id.spin_partner);

        date = findViewById(R.id.order_date);

        state=findViewById(R.id.txt_state);

        del_sale=findViewById(R.id.btn_del);

        id = Integer.parseInt(getIntent().getStringExtra("saleId"));

        total = findViewById(R.id.total);

        TextView orderId = findViewById(R.id.saleName);
        orderId.setText("Sale: " + getIntent().getStringExtra("saleCode"));
        TableEdit tabla = new TableEdit(this, findViewById(R.id.tableOrders));
        fillSpinner();
        fillDate();
        filterArticles();
        for (Article s : filteredArticles) {
            ArrayList<String> elementos = new ArrayList<>();
            elementos.add(s.getName());
            elementos.add(Integer.toString(s.getQuantity()));
            elementos.add(s.getUnitPrice() + " €");
            elementos.add(Integer.toString(s.getId()));
            tabla.agregarFilaTabla(elementos,this);
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
                state.setText(String.format("%s", s.getState().toUpperCase()));
                total.setText(String.format("%s €", s.getTotalprice()));
            }
        }

        if(state.getText().toString().equals("DRAFT")){
            del_sale.setVisibility(View.VISIBLE);
        } else {
            del_sale.setVisibility(View.INVISIBLE);
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

    public void delSale(View v){
        int idBorrar=id;
        Intent intent = new Intent(v.getContext(), Inventario.class);
        startActivity(intent);
        Login.con.removeSale(idBorrar);
        Toast.makeText(this,"The sale has been deleted",Toast.LENGTH_SHORT).show();

    }
}