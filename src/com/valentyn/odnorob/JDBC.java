package com.valentyn.odnorob;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class JDBC {

    Connection db = null;

    public void connectionToDataBase() {
        Connection db = null;
        try {


            Class.forName("com.mysql.jdbc.Driver");

            db = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");


        } catch (ClassNotFoundException e) {
            System.out.println("Error creating class:" + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (SQLException e) {
                System.out.println("Can`t close connection");
            }
        }


    }

    void createTable() throws SQLException {
        try {

            PreparedStatement create = db.prepareStatement("CREATE TABLE if not exists user " +
                    "(id int  not null auto_increment," +
                    "First_Name varchar (100)," +
                    "Last_Name varchar (100), primary key (ID))");
            create.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Function Complete");
        }


    }
}
