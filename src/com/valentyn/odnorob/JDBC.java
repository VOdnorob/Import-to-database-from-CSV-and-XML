package com.valentyn.odnorob;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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
        StringBuffer buffer = new StringBuffer();
        boolean proccesedFirst = false;
        String firstParam = null, secondParam = null;



        try {
            File xmlFile = new File("dane-osoby.xml");

            PersonXmlParser parser = new PersonXmlParser();

            ArrayList person = parser.parseXml(new FileInputStream(xmlFile));

            System.out.println(person);
                PreparedStatement create = db.prepareStatement("CREATE TABLE if not exists user " +
                        "(id int  not null auto_increment," +
                        "name varchar (100)," +
                        "surname varchar (100), primary key (ID))" +
                        "age int (50)" +
                        "city varchar (100)");
            create.executeUpdate();
                PreparedStatement writeToTable = db.prepareStatement("INSERT INTO user (personParserHandler.getPersonList()) VALUES(?,?,?,?)");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Function Complete");
        }


    }
}
