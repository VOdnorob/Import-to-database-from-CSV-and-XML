package com.valentyn.odnorob;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.sql.*;

/*
public class JDBC {


    private static Connection connection;
    private static Statement statement;

    public void connectionToDataBase() throws IOException, SAXException, SQLException {

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

            if (connection != null) {
                System.out.println("You made it, take control your database now!");

                try {
                    statement = connection.createStatement();
                    statement.executeUpdate("CREATE TABLE CUSTOMERS (" +
                            "ID int NOT NULL AUTO_INCREMENT primary key ," +
                            "NAME varchar(255) NOT NULL," +
                            "SURNAME varchar(255),\n" +
                            "AGE int (10) null,\n" +
                            "CITY varchar (50))");
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMERS (NAME, SURNAME, AGE, CITY) VALUES(? , ?, ? , ?)");
                    for (int i = 0; i < PersonXmlParser.handler.getPersonList().size(); i++) {
                        preparedStatement.setString(1, String.valueOf(PersonXmlParser.handler.getPersonList().get(i).getName()));
                        preparedStatement.setString(2, String.valueOf(PersonXmlParser.handler.getPersonList().get(i).getSurname()));
                        if (PersonXmlParser.handler.getPersonList().get(i).getAge() == null) {
                            preparedStatement.setNull(3, Types.INTEGER);
                        } else {
                            preparedStatement.setInt(3, PersonXmlParser.handler.getPersonList().get(i).getAge());
                        }
                        preparedStatement.setString(4, String.valueOf(PersonXmlParser.handler.getPersonList().get(i).getCity()));
                        preparedStatement.executeUpdate();
                    }


                    System.out.println("tut");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    System.out.println("Function Complete");
                }
            } else {
                System.out.println("Failed to make connection!");
            }


        } finally {
            System.out.println("ok");
        }

    }


}
*/
