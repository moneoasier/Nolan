package com.example.nolanapk;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connexion {

    private Connection connection;
    private static ArrayList<User> users=new ArrayList<>();
    private static ArrayList<Partner> partners=new ArrayList<>();
    //private static ArrayList<User> users=new ArrayList<>();

    private final String user = "admin";
    private final String pass = "Admin123";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

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
