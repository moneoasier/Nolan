package com.example.nolanapk.clases;


import android.util.Log;

import com.example.nolanapk.activities.Inventario;
import com.example.nolanapk.activities.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Connexion {

    private static Connection connection;
    private static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Partner> partners = new ArrayList<>();
    public static ArrayList<Gafa> compra = new ArrayList<>();
    public static ArrayList<Sale> sales=new ArrayList<>();
    public static ArrayList<Article>articles = new ArrayList<>();
    //private static ArrayList<User> users=new ArrayList<>();

    private final String user = "admin";
    private final String pass = "Admin123";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    private int sale_ID;
    public static int partner_ID;

    public Connexion() {
        String database = "Nolan";
        String host = "192.168.65.2";
        int port = 5432;
        url = String.format(this.url, host, port, database);
        // System.out.println("connection status:" + status);
    }

    public void connect(String option) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    switch (option) {
                        case "users":
                            selectUsers();
                            break;

                        case "partners":
                            selectPartner();
                            break;

                        case "orders":
                            selectOrders();
                            selectArticles();
                            break;

                        case "gafas":
                            selectGafa();
                            break;

                        default:
                            break;
                    }

                } catch (Exception e) {
                    status = false;
                }
            }
        });
        thread.start();
        try {
            thread.join();
            status = true;
        } catch (Exception e) {
            status = false;

        }
    }

    public void selectUsers() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st = connection.createStatement();
                    rd = st.executeQuery("SELECT email, password, active, id FROM app_users;");

                    while (rd.next()) {
                        users.add(new User(rd.getString("email"), rd.getString("password"), rd.getBoolean("active"), rd.getInt("id")));
                        //System.out.println("Añadido");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.interrupted();
    }

    public void selectPartner() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Statement st;
                    ResultSet rd;

                    st = connection.createStatement();
                    rd = st.executeQuery("select id,name,street,zip,city,email,phone,is_company from res_partner where signup_type like 'signup' order by id;");

                    while (rd.next()) {
                        partners.add(new Partner(rd.getInt("id"), rd.getString("name"), rd.getString("street"), rd.getString("zip"),
                                rd.getString("city"), rd.getString("email"), rd.getString("phone"), rd.getBoolean("is_company")));
                        //System.out.println("Añadido");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.interrupted();
    }

    public void selectGafa() {

        try {

            Statement st;
            ResultSet rd;

            st = connection.createStatement();
            rd = st.executeQuery("select product_template.id as id,product_template.default_code as code, product_template.name as name, product_template.list_price as price,"+
                    "sum(quantity - reserved_quantity) as cantidad, product_category.name as category from stock_quant "
                    + "inner join product_template on product_template.id = stock_quant.product_id "
                    + "inner join product_category on product_category.id = product_template.categ_id "
                    + "where location_id = 8 "
                    + "group by product_template.name, product_template.list_price, product_id, product_template.default_code, product_category.name,product_template.id "
                    + "order by product_template.default_code;");

            while (rd.next()) {
                Inventario.allGafas.add(new Gafa(rd.getString("code"), rd.getInt("id"), rd.getString("name"), rd.getDouble("price"), rd.getInt("cantidad"), rd.getString("category")));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void insertOrder(int u_id, int p_id, double p1, double p2, double p3) {


        final Semaphore available = new Semaphore(1, true);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    available.acquire();

                    try {
                        Statement st;
                        ResultSet rd;

                        st = connection.createStatement();
                        rd = st.executeQuery("select max(id) as id from sale_order;");
                        while (rd.next()) {
                            sale_ID = rd.getInt("id");

                        }
                        Log.d("mecaguento", "" + sale_ID);
                        sale_ID++;

                        Statement st2;

                        st2 = connection.createStatement();
                        st2.executeQuery("insert into sale_order(id,name,state,date_order,user_id,partner_id,partner_invoice_id,partner_shipping_id,pricelist_id,currency_id,"+
                                "invoice_status,amount_untaxed,amount_tax,amount_total,currency_rate,company_id,team_id,picking_policy,warehouse_id,effective_date,create_date,write_date)"
                                + "values (" + sale_ID + ",'S000" + sale_ID + "','draft',now()," + u_id + "," + p_id + "," + p_id + "," + p_id + ",1,1,'no'," + p1 + "," + p2 + "," + p3 +
                                ",1,1,5,'direct',1,current_timestamp,now(),now());");


                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } finally {
                        available.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    available.acquire();

                    try {


                            Statement st = connection.createStatement();
                            String sql="insert into sale_order_line(order_id,name,\"sequence\",invoice_status,price_unit,price_subtotal,price_tax,price_total,price_reduce"+
                                        ",price_reduce_taxinc,price_reduce_taxexcl,discount,product_id,product_uom_qty,product_uom,qty_delivered_method,qty_delivered,"+
                                        "qty_delivered_manual,qty_to_invoice,qty_invoiced,untaxed_amount_invoiced,untaxed_amount_to_invoice,salesman_id,currency_id,company_id,"+
                                        "order_partner_id,state,customer_lead,create_uid,create_date,write_uid,write_date) values ";

                                for (Gafa g : Connexion.compra) {

                                    sql+="(" + sale_ID + ",'[" + g.getId() + "]" + g.getNombre() + "',10,'no'," + g.getPrecio() + "," + g.getPrecioCantidad() +
                                            "," + g.getIvaCantidad() + "," + g.getPrecioTotal() + "," + g.getPrecio() + "," + g.getPrecioIva() + "," + g.getPrecio() +
                                            ",0,"+g.getPro_id()+"," + g.getCantidad() + ",1,'stock_move',0,0," + g.getCantidad() + ",0,0," + g.getPrecio() + "," + u_id +
                                            ",1,1," + p_id + ",'draft',0," + u_id + ",now()," + u_id + ",now())";

                                    if(Connexion.compra.indexOf(g)+1==Connexion.compra.size()){
                                        sql+=";";
                                    } else {
                                        sql+=",";
                                    }

                                }
                        st.executeQuery(sql);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } finally {
                        available.release();
                        Connexion.compra.clear();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setPriority(10);
        thread2.setPriority(1);
        thread.start();
        thread2.start();

    }

    public void insertPartner(Partner p) {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Statement st2;
                    ResultSet rd2;

                    st2 = connection.createStatement();
                    rd2 = st2.executeQuery("select max(id) as id from res_partner;");

                    while (rd2.next()) {
                        partner_ID = rd2.getInt("id");

                    }
                    partner_ID++;

                    Statement st = connection.createStatement();
                    st.executeQuery("insert into res_partner(id,name,street,zip,city,email,phone,is_company,create_date,display_name,lang,active,type,color,partner_share,commercial_partner_id,create_uid,write_uid,write_date,signup_type)"
                            + "values (" + partner_ID + ",'" + p.getName() + "','" + p.getStreet() + "','" + p.getZip() + "','" + p.getCity() + "','" + p.getEmail() + "','" + p.getPhone() + "'," + p.isCompany() + ",now(),'" + p.getName() + "','es-ES',true,'contact',0,true," + partner_ID + "," + Login.user_id + "," + Login.user_id + ",now(),'signup');");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.interrupted();
    }

    public void selectOrders(){
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement st;
                    ResultSet rd;

                    st = connection.createStatement();
                    rd = st.executeQuery("select sale_order.id,sale_order.name as ordername,state,effective_date,res_partner.name as partner,amount_total "+
                                                "from sale_order inner join res_partner on partner_id = res_partner.id order by id;");

                    while (rd.next()) {

                        sales.add(new Sale(rd.getInt("id"),rd.getString("ordername"),rd.getString("partner")
                                ,rd.getString("state"),rd.getDate("effective_date"),rd.getDouble("amount_total")));
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.interrupted();
    }

    public void selectArticles(){
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement st;
                    ResultSet rd;

                    st = connection.createStatement();
                    rd = st.executeQuery("select sale_order_line.id as id,order_id,product_template.name as name,price_unit,product_uom_qty "+
                            "from sale_order_line inner join product_template on product_id = product_template.id order by sale_order_line.id;");

                    while (rd.next()) {

                        articles.add(new Article(rd.getInt("id"),rd.getInt("order_id"),rd.getString("name"),rd.getDouble("price_unit")
                        ,rd.getInt("product_uom_qty")));
                    }


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.interrupted();
    }

    public static User findUser(String email) {

        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public void removeArticle(int article_id, int sale_id){

                try {
                    Statement st;

                    st = connection.createStatement();
                    st.executeQuery("select drop_product("+article_id+","+sale_id+");");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}