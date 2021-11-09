package com.example.nolanapk.clases;

import java.util.Objects;

public class Partner {
    private int id;
    private String name;
    private String street;
    private String zip;
    private String city;
    private String email;
    private String phone;
    private boolean company;

    public Partner(int id, String name, String street, String zip, String city, String email, String phone, boolean company) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    public Partner(String name, String street, String zip, String city, String email, String phone, boolean company) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getZip() { return zip; }

    public void setZip(String zip) { this.zip = zip; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public boolean isCompany() { return company; }

    public void setCompany(boolean company) { this.company = company; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partner partner = (Partner) o;
        return id == partner.id && company == partner.company && Objects.equals(name, partner.name) && Objects.equals(street, partner.street) && Objects.equals(zip, partner.zip) && Objects.equals(city, partner.city) && Objects.equals(email, partner.email) && Objects.equals(phone, partner.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, zip, city, email, phone, company);
    }

    @Override
    public String toString() {
        return name;
    }

}
