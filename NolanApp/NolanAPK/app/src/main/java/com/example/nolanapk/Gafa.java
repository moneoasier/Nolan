package com.example.nolanapk;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

public class Gafa {
    private String id;
    private String nombre;
    private int precio;
    private List<String> tipo;
    private String material;

    public Gafa(String id, String nombre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        //this.tipo = tipo;
        //this.material = material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /*
     * public List<String> getTipo() { return tipo; }
     *
     * public void setTipo(List<String> tipo) { this.tipo = tipo; }
     *
     * public String getMaterial() { return material; }
     *
     * public void setMaterial(String material) { this.material = material; }
     */

    @Override
    public int hashCode() {
        return Objects.hash(id, material, nombre, precio, tipo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gafa other = (Gafa) obj;
        return Objects.equals(id, other.id) && Objects.equals(material, other.material)
                && Objects.equals(nombre, other.nombre) && precio == other.precio && Objects.equals(tipo, other.tipo);
    }

    @NonNull
    @Override
    public String toString() {
        return id + "," + nombre + "," + precio;
    }

}

