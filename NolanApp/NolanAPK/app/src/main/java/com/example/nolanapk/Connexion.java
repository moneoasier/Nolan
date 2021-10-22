package com.example.nolanapk;


import android.util.Log;

import androidx.annotation.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class Connexion {

    private Connection connection;
    public static ArrayList<User> users=new ArrayList<>();

    private final String host = "192.168.65.2";
    private final String database = "Nolan";
    private final int port = 5432;
    private final String user = "admin";
    private final String pass = "Admin123";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public Connexion() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();

        System.out.println("connection status:" + status);
    }

    private void connect() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                    selectUsers();
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
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
                    rd=st.executeQuery("SELECT email, password, active FROM app_users;");

                    while(rd.next()){
                        users.add(new User(rd.getString("email"),rd.getString("password"),rd.getBoolean("active")));
                        System.out.println("Añadido");
                    }

                    for(User u: users){
                        System.out.println(u.toString());
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread2.start();
    }

    public Connection getExtraConnection(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
    public static class User{
        private String email;
        private String password;
        private boolean active;

        public User(String email, String password, boolean active) {
            this.email = email;
            this.password = password;
            this.active = active;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return active == user.active && Objects.equals(email, user.email) && Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email, password, active);
        }

        @Override
        public String toString() {
            return "User{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", active=" + active +
                    '}';
        }
    }


}
