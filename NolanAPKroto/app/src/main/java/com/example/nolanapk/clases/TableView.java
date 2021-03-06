package com.example.nolanapk.clases;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.nolanapk.activities.Inventario;
import com.example.nolanapk.activities.Login;
import com.example.nolanapk.activities.Orders;
import com.example.nolanapk.activities.Purchase;
import com.example.nolanapk.R;
import com.example.nolanapk.activities.Sales;

import java.util.ArrayList;

/**
 * Created by francis on 14/10/14.
 * Esta clase representa una tabla
 */
public class TableView {
    // Variables de la clase

    private TableLayout tabla;          // Layout donde se pintarĂ¡ la tabla
    private ArrayList<TableRow> filas;  // Array de las filas de la tabla
    private Activity actividad;
    private Resources rs;
    private int FILAS, COLUMNAS;        // Filas y columnas de nuestra tabla

    /**
     * Constructor de la tabla
     * @param actividad Actividad donde va a estar la tabla
     * @param tabla TableLayout donde se pintarĂ¡ la tabla
     */
    public TableView(Activity actividad, TableLayout tabla)
    {
        this.actividad = actividad;
        this.tabla = tabla;
        rs = this.actividad.getResources();
        FILAS = COLUMNAS = 0;
        filas = new ArrayList<TableRow>();
    }

    /**
     * Agrega una fila a la tabla
     * @param elementos Elementos de la fila
     */

    public void agregarFilaTabla(ArrayList<String> elementos, String btnStr)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        for(int i = 0; i< elementos.size()-1; i++)
        {
            TextView texto = new TextView(actividad);
            texto.setText(String.valueOf(elementos.get(i)));
            texto.setGravity(Gravity.CENTER);
            texto.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            texto.setBackgroundResource(R.drawable.tabla_celda);
            switch(btnStr){
                case "x":
                    texto.setTextSize(14);
                    break;

                case "info":
                    texto.setTextSize(12);
                    break;
                    
            }

            layoutCelda = new TableRow.LayoutParams(50, TableRow.LayoutParams.MATCH_PARENT);
            texto.setLayoutParams(layoutCelda);
            fila.addView(texto);
        }
        Button btn = new Button(actividad.getBaseContext());
        btn.setLayoutParams(new TableRow.LayoutParams(50,TableRow.LayoutParams.MATCH_PARENT));
        btn.setBackgroundResource(R.drawable.tabla_celda);
        btn.setText(btnStr);
        FILAS++;
            btn.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {

                    switch (btnStr) {

                        case "x":

                            for (int i = 0; i < Connexion.compra.size(); i++) {
                                if (Connexion.compra.get(i).getId().equals(elementos.get(0))) {
                                    tabla.removeViewAt(i+1);
                                    FILAS--;
                                    Connexion.compra.remove(i);
                                    Purchase.calculateTotal();
                                    break;
                                }
                            }
                            break;

                        case "info":

                            Intent intent = new Intent(v.getContext(), Orders.class);
                            intent.putExtra("saleId", elementos.get(elementos.size() - 1));
                            intent.putExtra("saleCode", elementos.get(0));
                            actividad.startActivityForResult(intent, 0);

                            break;

                    }
                }
            });

        fila.addView(btn);

        tabla.addView(fila);
        filas.add(fila);

    }


    /**
     * Devuelve las filas de la tabla, la cabecera se cuenta como fila
     * @return Filas totales de la tabla
     */
    public int getFilas()
    {
        return FILAS;
    }

    /**
     * Devuelve las columnas de la tabla
     * @return Columnas totales de la tabla
     */
    public int getColumnas()
    {
        return COLUMNAS;
    }

    /**
     * Devuelve el nĂºmero de celdas de la tabla, la cabecera se cuenta como fila
     * @return NĂºmero de celdas totales de la tabla
     */
    public int getCeldasTotales()
    {
        return FILAS * COLUMNAS;
    }

    /**
     * Obtiene el ancho en pĂ­xeles de un texto en un String
     * @param texto Texto
     * @return Ancho en pĂ­xeles del texto
     */
    private int obtenerAnchoPixelesTexto(String texto)
    {
        Paint p = new Paint();
        Rect bounds = new Rect();
        p.setTextSize(50);

        p.getTextBounds(texto, 0, texto.length(), bounds);
        return bounds.width();
    }
}
