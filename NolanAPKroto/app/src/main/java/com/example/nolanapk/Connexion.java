package com.example.nolanapk;


import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Connexion {

    private static Connection connection;
    private static ArrayList<User> users=new ArrayList<>();
    public static ArrayList<Partner> partners=new ArrayList<>();
    public static ArrayList<Gafa> compra=new ArrayList<>();
    //private static ArrayList<User> users=new ArrayList<>();

    private final String user = "admin";
    private final String pass = "Admin123";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public static int sale_ID;
    public static int partner_ID;

    public Connexion() {
        String database = "Nolan";
        String host = "192.168.65.2";
        int port = 5432;
        url = String.format(this.url, host, port, database);
        connect();

       // System.out.println("connection status:" + status);
    }

    public void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    //System.out.println("connected:" + status);
                    selectUsers();
                    selectPartner();
                    selectID();
                } catch (Exception e) {
                    status = false;
                }
            }
        });
        thread.start();
        try {
            thread.join();
            status=true;
        } catch (Exception e) {
            status = false;

        }
    }

    public void selectUsers(){
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("SELECT email, password, active, id FROM app_users;");

                    while(rd.next()){
                        users.add(new User(rd.getString("email"),rd.getString("password"),rd.getBoolean("active"),rd.getInt("id")));
                        //System.out.println("Añadido");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread2.start();
        Thread.interrupted();
    }

    public void selectPartner(){
        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("select id,name,street,zip,city,email,phone,is_company from res_partner where signup_type like 'signup' order by id;");

                    while(rd.next()){
                        partners.add(new Partner(rd.getInt("id"),rd.getString("name"),rd.getString("street"),rd.getString("zip"),rd.getString("city"),rd.getString("email"),rd.getString("phone"),rd.getBoolean("is_company")));
                        //System.out.println("Añadido");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread3.start();
        Thread.interrupted();
    }

    /*public void selectGafa(){
        Thread thread4 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("select id,name,street,zip,city,email,phone,is_company from res_partner where signup_type like 'signup' order by id;");

                    while(rd.next()){
                        partners.add(new Partner(rd.getInt("id"),rd.getString("name"),rd.getString("street"),rd.getString("zip"),rd.getString("city"),rd.getString("email"),rd.getString("phone"),rd.getBoolean("is_company")));
                        //System.out.println("Añadido");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread4.start();
        Thread.interrupted();
    }*/

    public static void insertOrder(int u_id,int p_id,double p1, double p2, double p3){

        sale_ID++;
        final Semaphore available = new Semaphore(1, true);

        Thread thread5 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    available.acquire();

                    try {

                        Statement st;
                        ResultSet rd;

                        st=connection.createStatement();
                        rd=st.executeQuery("insert into sale_order(id,name,state,date_order,user_id,partner_id,partner_invoice_id,partner_shipping_id,pricelist_id,currency_id,invoice_status,amount_untaxed,amount_tax,amount_total,currency_rate,company_id,team_id,picking_policy,warehouse_id,effective_date,create_date,write_date)"
                                + "values ("+sale_ID+",'S000"+sale_ID+"','draft',now(),"+u_id+","+p_id+","+p_id+","+p_id+",1,1,'no',"+p1+","+p2+","+p3+",1,1,5,'direct',1,current_timestamp,now(),now());");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }finally {
                        available.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread6 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    available.acquire();

                    try {

                        Statement st;
                        ResultSet rd;

                        for (Gafa g: Connexion.compra) {
                            Log.d("QueOstiasEs.5",sale_ID+"   "+g.getId()+" / "+g.getNombre()+" / "+g.getPrecio()+" / "+g.getPrecioCantidad()+" / "+g.getIvaCantidad()+" / "+g.getPrecioTotal()+" / "+g.getNombre()+" / "+g.getCantidad());
                            st = connection.createStatement();
                            rd = st.executeQuery("insert into sale_order_line(order_id,name,\"sequence\",invoice_status,price_unit,price_subtotal,price_tax,price_total,price_reduce,price_reduce_taxinc,price_reduce_taxexcl,discount,product_id,product_uom_qty,product_uom,qty_delivered_method,qty_delivered,qty_delivered_manual,qty_to_invoice,qty_invoiced,untaxed_amount_invoiced,untaxed_amount_to_invoice,salesman_id,currency_id,company_id,order_partner_id,state,customer_lead,create_uid,create_date,write_uid,write_date)"
                                    + "values (" + sale_ID + ",'["+g.getId()+"]"+g.getNombre()+"',10,'no',"+g.getPrecio()+","+g.getPrecioCantidad()+","+g.getIvaCantidad()+","+g.getPrecioTotal()+","+g.getPrecio()+","+g.getPrecioIva()+","+g.getPrecio()+",0,1,"+g.getCantidad()+",1,'stock_move',0,0,"+g.getCantidad()+",0,0,"+g.getPrecio()+","+u_id+",1,1,"+p_id+",'draft',0,"+u_id+",now(),"+u_id+",now());");
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }finally {
                        available.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread5.setPriority(10);
        thread6.setPriority(1);
        thread5.start();
        thread6.start();

    }

    public static void insertPartner(Partner p) {

        Thread thread8 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st = connection.createStatement();
                    rd = st.executeQuery("insert into res_partner(id,name,street,zip,city,email,phone,is_company)"
                            + "values ("+partner_ID+",'" + p.getName() + "','" + p.getStreet() + "','" + p.getZip() + "','" + p.getCity() + "','" + p.getEmail() + "','" + p.getPhone() + "'," + p.isCompany()+ ");");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread8.start();
        Thread.interrupted();
    }

    public void selectID(){
        Thread thread7 = new Thread(new Runnable() {


            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("select max(id) as id from sale_order;");

                    while(rd.next()){
                        sale_ID = rd.getInt("id");

                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try{

                    Statement st2;
                    ResultSet rd2;

                    st2=connection.createStatement();
                    rd2=st2.executeQuery("select max(id) as id from res_partner;");

                    while(rd2.next()){
                        partner_ID = rd2.getInt("id");

                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }

        });
        thread7.start();
        Thread.interrupted();
    }

    public static User findUser(String email){

        for(User u:users){
            if (u.getEmail().equals(email)) {
                    return u;
            }
        }
        return null;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
