package com.example.nolanapk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Purchase extends AppCompatActivity {

    public Spinner spinp;
    TableLayout tabla;
    TextView txt;
    TextView pstotal;
    TextView piva;
    TextView ptotal;
    Double precio1 = 0.00;
    Double precioiva;
    Double precio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase);

        //Boton Nuevo Cliente --> NewPartner
        spinp =findViewById(R.id.spin_partner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Connexion.partners);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinp.setAdapter(adapter);

        pstotal = (TextView) findViewById(R.id.txt_Subtotal);
        piva = (TextView) findViewById(R.id.txt_iva);
        ptotal = (TextView) findViewById(R.id.txt_total);

        tabla = (TableLayout) findViewById(R.id.tableLayout);

        for (int j = 0; j < Inventario.compra.size(); j++) {

            TableRow row = new TableRow(getBaseContext());
            String[] cadena = {Inventario.compra.get(j).getId(), Integer.toString(Inventario.compra.get(j).getCantidad()), Double.toString(Inventario.compra.get(j).getPrecio()*Inventario.compra.get(j).getCantidad()), "x"};

            for (int i = 0; i < cadena.length; i++) {

                txt = new TextView(getBaseContext());
                txt.setText(cadena[i]);
                txt.setTextColor(Color.WHITE);

                switch(i) {
                    case 0:
                        //txt.setOnClickListener(DetailsOnClick());
                        break;
                    case 1:
                        break;
                    case 2:
                        precio1+=Double.parseDouble(cadena[i]);
                        break;
                    case 3:
                        //OnClick Eliminar
                        break;
                }

                row.addView(txt);
                pstotal.setText(precio1.toString());
                precioiva = precio1*0.21;
                double precioIvaRed=Math.round(precioiva*100.0)/100.0;
                piva.setText(Double.toString(precioIvaRed));
                precio2 = precio1+precioiva;
                ptotal.setText(Double.toString(Math.round(precio2*100.0)/100.0));

            }

            tabla.addView(row);
        }


    }

    public void tramitar(View v){
        Connexion.insertOrder(Connexion.sale_ID,Connexion.sale_Name,Login.user_id,Connexion.partners.get(spinp.getSelectedItemPosition()).getId(),precio1,precioiva,precio2);

    }

    /*public void DetailsOnClick(View v){
        Intent b = new Intent(Purchase.this, Detalles.class);

        String valor= v.getTag().toString();
        b.putExtra("gafa",findGafa(valor));
        startActivity(b);
    }

    /*public void DelCompraOnClick(String code){

    }*/
}