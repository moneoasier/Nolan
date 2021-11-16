package com.example.nolanapk.clases;

import java.util.Objects;

public class Article {
    private int id;
    private int saleId; //order_id
    private String name;
    private int gafaId;
    private double unitPrice;
    private int quantity;//product_uom_qty

    private double iva; // iva de un solo producto
    private double precioCantidad; // precio por la cantidad sin iva
    private double ivaCantidad; // el iva de la cantidad
    private double precioTotal; // precio total con iva
    private double precioIva;

    public Article(int gafaId,int id, int saleId, String name, double unitPrice, int quantity) {
        this.gafaId=gafaId;
        this.id = id;
        this.saleId = saleId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public void setPrecios(){

        this.iva = this.unitPrice*0.21;
        this.precioCantidad = this.unitPrice * (double)quantity;
        this.ivaCantidad = this.iva * (double)quantity;
        this.precioTotal = this.precioCantidad + this.ivaCantidad;
        this.precioIva = this.unitPrice + this.iva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getGafaId() {
        return gafaId;
    }

    public void setGafaId(int gafaId) {
        this.gafaId = gafaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && saleId == article.saleId && Double.compare(article.unitPrice, unitPrice) == 0 && quantity == article.quantity && Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, saleId, name, unitPrice, quantity);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", saleId=" + saleId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }
}
