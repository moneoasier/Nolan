package com.example.nolanapk;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connexion {

    private static Connection connection;
    private static ArrayList<User> users=new ArrayList<>();
    public static ArrayList<Partner> partners=new ArrayList<>();
    //private static ArrayList<User> users=new ArrayList<>();

    private final String user = "admin";
    private final String pass = "Admin123";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public static int sale_ID = 0;
    public static String sale_Name = "0";
    public static int sale_Order_ID = 0;

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

    public static void insertOrder(int s_id,String s_name,int u_id,int p_id,double p1, double p2, double p3){
        Thread thread5 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("insert into sale_order(name,state,date_order,user_id,partner_id,partner_invoice_id,partner_shipping_id,pricelist_id,currency_id,invoice_status,amount_untaxed,amount_tax,amount_total,currency_rate,company_id,team_id,picking_policy,warehouse_id,effective_date)"
                            + "values ('"+s_name+"','draft',now(),"+u_id+","+p_id+","+p_id+","+p_id+",1,1,'no',"+p1+","+p2+","+p3+",1,1,5,'direct',1,current_timestamp);");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        Thread thread6 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("insert into sale_order(name,state,date_order,user_id,partner_id,partner_invoice_id,partner_shipping_id,pricelist_id,currency_id,invoice_status,amount_untaxed,amount_tax,amount_total,currency_rate,company_id,team_id,picking_policy,warehouse_id,effective_date)"
                            + "values ('"+s_name+"','draft',now(),"+u_id+","+p_id+","+p_id+","+p_id+",1,1,'no',"+p1+","+p2+","+p3+",1,1,5,'direct',1,current_timestamp);");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread5.start();
        Thread.interrupted();
        thread6.start();
        Thread.interrupted();
    }

    public static void insertOrderLine(int s_id,String s_name,int u_id,int p_id,double p1, double p2, double p3){

    }

    public void selectID(){
        Thread thread7 = new Thread(new Runnable() {


            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st=connection.createStatement();
                    rd=st.executeQuery("select sale_order.id,sale_order.name,sale_order_line.id from sale_order inner join sale_order_line on order_id = sale_order.id order by sale_order.id desc, sale_order_line.id desc limit 1;");

                    while(rd.next()){
                        sale_ID = rd.getInt("sale_order.id");
                        sale_Name = rd.getString("sale_order.name");
                        sale_Order_ID = rd.getInt("sale_order_line.id");

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
