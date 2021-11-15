package com.example.nolanapk.clases;

import java.util.Date;
import java.util.Objects;

public class Sale {
    private int id;
    private String name;
    private String partnerName;
    private String state;
    private Date date; //effective_date
    private double totalprice;

    public Sale(int id, String name, String partnerName, String state, Date date, double totalprice) {
        this.id = id;
        this.name = name;
        this.partnerName = partnerName;
        this.state = state;
        this.date = date;
        this.totalprice = totalprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id && Double.compare(sale.totalprice, totalprice) == 0 && Objects.equals(name, sale.name) && Objects.equals(partnerName, sale.partnerName) && Objects.equals(state, sale.state) && Objects.equals(date, sale.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, partnerName, state, date, totalprice);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partnerName='" + partnerName + '\'' +
                ", state='" + state + '\'' +
                ", date=" + date +
                ", totalprice=" + totalprice +
                '}';
    }
}
