package org.example;


import java.sql.Connection;
import java.sql.DriverManager;

public class mySqlConnect {

    Connection mConnection = null;
    public mySqlConnect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Registering the jdbc Driver for MySQL;
            mConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/karuna_library","root", "Karuna@123");
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public Connection getmConnection() {
        return mConnection;
    }

    public void setmConnection(Connection mConnection) {
        this.mConnection = mConnection;
    }
}
