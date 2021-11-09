package com.example.nolanapk.clases;
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
    public Gafa(String id,int pro_id, String nombre, double precio, int stock,String category) {
        this.id = id;
        this.pro_id=pro_id;
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

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.setPrecios();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecioCantidad() {
        return precioCantidad;
    }

    public void setPrecioCantidad(double precioCantidad) {
        this.precioCantidad = precioCantidad;
    }

    public double getIvaCantidad() {
        return ivaCantidad;
    }

    public void setIvaCantidad(double ivaCantidad) {
        this.ivaCantidad = ivaCantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(double precioIva) {
        this.precioIva = precioIva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gafa gafa = (Gafa) o;
        return pro_id == gafa.pro_id && stock == gafa.stock && cantidad == gafa.cantidad && Double.compare(gafa.precio, precio) == 0 && Double.compare(gafa.iva, iva) == 0 && Double.compare(gafa.precioCantidad, precioCantidad) == 0 && Double.compare(gafa.ivaCantidad, ivaCantidad) == 0 && Double.compare(gafa.precioTotal, precioTotal) == 0 && Double.compare(gafa.precioIva, precioIva) == 0 && Objects.equals(id, gafa.id) && Objects.equals(nombre, gafa.nombre) && Objects.equals(category, gafa.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pro_id, nombre, stock, category, cantidad, precio, iva, precioCantidad, ivaCantidad, precioTotal, precioIva);
    }

    @Override
    public String toString() {
        return "Gafa{" +
                "id='" + id + '\'' +
                ", pro_id=" + pro_id +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", iva=" + iva +
                ", precioCantidad=" + precioCantidad +
                ", ivaCantidad=" + ivaCantidad +
                ", precioTotal=" + precioTotal +
                ", precioIva=" + precioIva +
                '}';
    }
}
