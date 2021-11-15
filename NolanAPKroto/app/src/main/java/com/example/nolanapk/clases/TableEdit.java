package com.example.nolanapk.clases;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.nolanapk.R;
import com.example.nolanapk.activities.Inventario;
import com.example.nolanapk.activities.Login;
import com.example.nolanapk.activities.Orders;
import com.example.nolanapk.activities.Purchase;

import java.util.ArrayList;

public class TableEdit {
    private TableLayout tabla;          // Layout donde se pintará la tabla
    private ArrayList<TableRow> filas;  // Array de las filas de la tabla
    private Activity actividad;
    private Resources rs;
    private int FILAS, COLUMNAS;
    private ArrayAdapter<Gafa> adapter;// Filas y columnas de nuestra tabla


    /**
     * Constructor de la tabla
     * @param actividad Actividad donde va a estar la tabla
     * @param tabla TableLayout donde se pintará la tabla
     */
    public TableEdit(Activity actividad, TableLayout tabla)
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

    public void agregarFilaTabla(ArrayList<String> elementos, Context c)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        Spinner editableTxt=new Spinner(actividad);

        editableTxt.setGravity(Gravity.CENTER);
        editableTxt.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        editableTxt.setBackgroundResource(R.drawable.tabla_celda);

        fillSpinner(c,editableTxt,elementos.get(0));
        layoutCelda = new TableRow.LayoutParams(50, TableRow.LayoutParams.MATCH_PARENT);
        editableTxt.setLayoutParams(layoutCelda);
        fila.addView(editableTxt);

        for(int i = 1; i< elementos.size()-1; i++)
        {
            TextView texto= new TextView(actividad);
            texto.setText(String.valueOf(elementos.get(i)));
            texto.setGravity(Gravity.CENTER);
            texto.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            texto.setBackgroundResource(R.drawable.tabla_celda);

            layoutCelda = new TableRow.LayoutParams(50, TableRow.LayoutParams.MATCH_PARENT);
            texto.setLayoutParams(layoutCelda);
            fila.addView(texto);
        }
        Button btn = new Button(actividad.getBaseContext());
        btn.setLayoutParams(new TableRow.LayoutParams(50,TableRow.LayoutParams.MATCH_PARENT));
        btn.setBackgroundResource(R.drawable.tabla_celda);
        btn.setText("x");
        FILAS++;
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {

                int fila=FILAS;
                for (int i = 0; i < Connexion.articles.size(); i++) {

                    if (Connexion.articles.get(i).getId() == Integer.parseInt(elementos.get(elementos.size()-1))) {
                        tabla.removeViewAt(fila);
                        FILAS--;
                        Connexion.articles.remove(i);
                        Login.con.removeArticle(Connexion.articles.get(i).getId(),Connexion.articles.get(i).getSaleId());
                        break;
                    }
                }

            }
        });

        fila.addView(btn);

        tabla.addView(fila);
        filas.add(fila);

    }

    public void fillSpinner(Context c, Spinner spin, String name){
        adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_item, Inventario.allGafas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        for (Gafa g: Inventario.allGafas) {
            if(g.getNombre().equals(name)){
                int spinnerPosition = adapter.getPosition(g);
                spin.setSelection(spinnerPosition);
            }
        }

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
     * Devuelve el número de celdas de la tabla, la cabecera se cuenta como fila
     * @return Número de celdas totales de la tabla
     */
    public int getCeldasTotales()
    {
        return FILAS * COLUMNAS;
    }

    /**
     * Obtiene el ancho en píxeles de un texto en un String
     * @param texto Texto
     * @return Ancho en píxeles del texto
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

