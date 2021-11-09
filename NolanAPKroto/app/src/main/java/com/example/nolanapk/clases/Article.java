package com.example.nolanapk.clases;

import java.util.Objects;

public class Article {
    private int id;
    private int saleId; //order_id
    private String name;
    private double unitPrice;
    private int quantity;//product_uom_qty

    public Article(int id, int saleId, String name, double unitPrice, int quantity) {
        this.id = id;
        this.saleId = saleId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
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
