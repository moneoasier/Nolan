package com.example.nolanapk.clases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nolanapk.R;
import com.example.nolanapk.activities.Inventario;
import com.example.nolanapk.activities.Login;
import com.example.nolanapk.activities.Orders;
import com.google.type.Color;

import java.util.ArrayList;

public class TableEdit {
    private final TableLayout tabla;          // Layout donde se pintará la tabla
    private final ArrayList<TableRow> filas;  // Array de las filas de la tabla
    private final Activity actividad;
    private int FILAS;
    private int stock;
    private Article updateArticle;

    /**
     * Constructor de la tabla
     * @param actividad Actividad donde va a estar la tabla
     * @param tabla TableLayout donde se pintará la tabla
     */
    public TableEdit(Activity actividad, TableLayout tabla)
    {
        this.actividad = actividad;
        this.tabla = tabla;
        Resources rs = this.actividad.getResources();
        FILAS = 0;
        filas = new ArrayList<>();
    }

    /**
     * Agrega una fila a la tabla
     * @param elementos Elementos de la fila
     */

    public void agregarFilaTabla(ArrayList<String> elementos, Context c,ArrayList<Article> filterArticles)
    {
        TableRow.LayoutParams layoutCelda;
        TableRow.LayoutParams layoutFila = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow fila = new TableRow(actividad);
        fila.setLayoutParams(layoutFila);

        //Taularen lehenengo zutabea - Spinner
        Spinner editableTxt=new Spinner(actividad);

        editableTxt.setGravity(Gravity.CENTER);
        editableTxt.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        editableTxt.setBackgroundResource(R.drawable.tabla_celda);

        fillSpinner(c,editableTxt,elementos.get(0));
        layoutCelda = new TableRow.LayoutParams(50, TableRow.LayoutParams.MATCH_PARENT);
        editableTxt.setLayoutParams(layoutCelda);
        fila.addView(editableTxt);

        //Taularen bigarren zutabea - EditText
        EditText eTexto=new EditText(actividad);
        eTexto.setText(String.valueOf(elementos.get(1)));

        eTexto.setGravity(Gravity.CENTER);
        eTexto.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        eTexto.setBackgroundResource(R.drawable.tabla_celda);
        eTexto.setInputType(InputType.TYPE_CLASS_NUMBER);
        eTexto.setFilters(new InputFilter[] {new InputFilterMinMax(1,stock)});
        eTexto.setHint(elementos.get(1));

        layoutCelda = new TableRow.LayoutParams(50, TableRow.LayoutParams.MATCH_PARENT);
        eTexto.setLayoutParams(layoutCelda);
        fila.addView(eTexto);

        //Taularen hirugarren zutabea - TextView
        TextView texto= new TextView(actividad);
        texto.setText(String.valueOf(elementos.get(2)));

        texto.setGravity(Gravity.CENTER);
        texto.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        texto.setBackgroundResource(R.drawable.tabla_celda);

        layoutCelda = new TableRow.LayoutParams(50, TableRow.LayoutParams.MATCH_PARENT);
        texto.setLayoutParams(layoutCelda);
        fila.addView(texto);

        //Taularen laugarren zutabea - Button
        Button btn = new Button(actividad.getBaseContext());
        btn.setLayoutParams(new TableRow.LayoutParams(50,TableRow.LayoutParams.MATCH_PARENT));
        btn.setText("x");
        FILAS++;
        btn.setOnClickListener(v -> {
            int fila1 =FILAS;

            if(isEditable()) {
                for (int i = 0; i < Connexion.articles.size(); i++) {

                    if (Connexion.articles.get(i).getId() == Integer.parseInt(elementos.get(elementos.size() - 1))) {
                        tabla.removeViewAt(fila1);
                        FILAS--;
                        Connexion.articles.remove(i);
                        Login.con.removeArticle(Connexion.articles.get(i).getId(), Connexion.articles.get(i).getSaleId());
                        Toast.makeText(c, "Product erased", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }

                Intent intent = new Intent(v.getContext(), Inventario.class);
                actividad.startActivityForResult(intent, 0);
            }
        });

        fila.addView(btn);

        Button btn2 = new Button(actividad.getBaseContext());
        btn2.setLayoutParams(new TableRow.LayoutParams(50,TableRow.LayoutParams.MATCH_PARENT));
        btn2.setBackgroundResource(R.drawable.tabla_celda);
        btn2.setText("!");
        FILAS++;
        btn2.setOnClickListener(v -> {
            if(isEditable()) {
                if (elementos.get(0).equals(Inventario.allGafas.get(editableTxt.getSelectedItemPosition()).getNombre())) {

                    if (qtyIsDif(filterArticles, elementos.get(0), eTexto)) {
                        updateArticle = findArticle(filterArticles, elementos.get(0));
                        updateArticle.setQuantity(Integer.parseInt(eTexto.getText().toString()));
                        updateArticle.setPrecios();
                        Login.con.updateProductQuantity(updateArticle);
                        Toast.makeText(c, "Quantity updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(c, "Nothing to update", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    updateArticle = findArticle(filterArticles, elementos.get(0));
                    Gafa gafanueva = newArticle(Inventario.allGafas.get(editableTxt.getSelectedItemPosition()).getPro_id());
                    updateArticle.setGafaId(gafanueva.getPro_id());
                    updateArticle.setName("[" + gafanueva.getId() + "] " + gafanueva.getNombre());
                    updateArticle.setQuantity(Integer.parseInt(eTexto.getText().toString()));
                    updateArticle.setUnitPrice(gafanueva.getPrecio());
                    updateArticle.setPrecios();
                    Login.con.updateProduct(updateArticle);
                    Toast.makeText(c, "Product updated", Toast.LENGTH_SHORT).show();
                }
                Connexion.sales.clear();
                Connexion.articles.clear();
                Intent intent = new Intent(v.getContext(), Inventario.class);
                actividad.startActivityForResult(intent, 0);
            }
        });

        fila.addView(btn2);

        tabla.addView(fila);
        filas.add(fila);

    }

    public void fillSpinner(Context c, Spinner spin, String name){
        ArrayAdapter<Gafa> adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_item, Inventario.allGafas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        for (Gafa g: Inventario.allGafas) {
            if(g.getNombre().equals(name)){
                stock= g.getStock();
                int spinnerPosition = adapter.getPosition(g);
                spin.setSelection(spinnerPosition);
            }
        }

    }

    public boolean qtyIsDif(ArrayList<Article> articles, String articleName, EditText txt){
        for(Article a:articles){
            if(a.getName().equals(articleName)){
               if(a.getQuantity()!=Integer.parseInt(txt.getText().toString())){
                   return true;
               }
            }
        }
        return false;
    }

    public Article findArticle(ArrayList<Article> articles, String articleName){
        for(Article a:articles){
            if(a.getName().equals(articleName)){
                return a;
            }
        }
        return null;
    }

    public Gafa newArticle(int id){
        for(Gafa g:Inventario.allGafas){
            if(g.getPro_id()==id){
                return g;
            }
        }
        return null;
    }

    public static boolean isEditable(){
        for (Sale s:Connexion.sales){
            if(s.getId()==Orders.orderID){
                if(s.getState().matches("draft")){
                    return true;
                }
            }
        }
        return false;
    }
}

