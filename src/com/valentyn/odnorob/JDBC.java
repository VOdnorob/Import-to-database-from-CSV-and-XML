package com.valentyn.odnorob;

import java.sql.*;

class JDBC {

    Connection connectionToDataBase() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root" ) ;



            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

     void createTable() throws SQLException {
        try {

            Connection connection = connectionToDataBase();
            PreparedStatement create = connection.prepareStatement("CREATE TABLE if not exists user " +
                    "(id int  not null auto_increment," +
                    "First_Name varchar (100)," +
                    "Last_Name varchar (100), primary key (ID))");
            create.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("Function Complete");
        }



    }
}
