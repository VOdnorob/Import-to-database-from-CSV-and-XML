package com.valentyn.odnorob;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

class JDBC {

    private Connection connection;
    Statement statement;

    public void connectionToDataBase() throws IOException, SAXException {
        File xmlFile = new File("dane-osoby.xml");

        PersonXmlParser parser = new PersonXmlParser();

        ArrayList person = parser.parseXml(new FileInputStream(xmlFile));


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }


        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        try {
            statement = connection.createStatement();
            /*statement.executeUpdate("CREATE TABLE CUSTOMERS (" +
                    "ID int NOT NULL AUTO_INCREMENT primary key ," +
                    "NAME varchar(255) NOT NULL," +
                    "SURNAME varchar(255),\n" +
                    "AGE int,\n" +
                    "    CITY varchar (50))");
*/


            PreparedStatement writeToTable = connection.prepareStatement("INSERT INTO CUSTOMERS (NAME, SURNAME, AGE, CITY) VALUES('?', '?', '?' , '?')");
            for (int i = 0; i < PersonXmlParser.handler.getPersonList().size(); i ++){

            }
         //   writeToTable.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Function Complete");
        }

    }

}
