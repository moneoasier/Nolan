package com.example.nolanapk;
import java.util.Objects;

public class Gafa {

    private String id;
    private int pro_id;
    private String nombre;
    private int stock;
    private String category;
    private int cantidad = 1;

    private double precio; // precio producto
    private double iva; // iva de un solo producto
    private double precioCantidad; // precio por la cantidad sin iva
    private double ivaCantidad; // el iva de la cantidad
    private double precioTotal; // precio total con iva
    private double precioIva; // precio total de un producto con iva

    /**
     * Constructor
     */
    public Gafa(String id, String nombre, double precio, int stock,String category) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.category=category;

    }

    public void setPrecios(){

        this.iva = this.precio*0.21;
        this.precioCantidad = this.precio * (double)cantidad;
        this.ivaCantidad = this.iva * (double)cantidad;
        this.precioTotal = this.precioCantidad + this.ivaCantidad;
        this.precioIva = this.precio + this.iva;
    }

    /**
     * Metodos Setters/Getters
     */
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getIva() { return iva; }

    public void setIva(double iva) { this.iva = iva; }

    public double getPrecioCantidad() { return precioCantidad; }

    public void setPrecioCantidad(double precioCantidad) { this.precioCantidad = precioCantidad; }

    public double getIvaCantidad() { return ivaCantidad; }

    public void setIvaCantidad(double ivaCantidad) { this.ivaCantidad = ivaCantidad; }

    public double getPrecioTotal() { return precioTotal; }

    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    public double getPrecioIva() { return precioIva; }

    public void setPrecioIva(double precioIva) { this.precioIva = precioIva; }

    /**
     * Metodos ToString/Equals
     */
    @Override
    public String toString() {
        return id +","+nombre+","+precio+","+stock+","+category+","+cantidad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, id, nombre, precio, stock);
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
        return Objects.equals(category, other.category) && Objects.equals(id, other.id)
                && Objects.equals(nombre, other.nombre)
                && Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock;
    }

}
