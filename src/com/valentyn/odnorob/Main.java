package com.valentyn.odnorob;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        JDBC jdbc = new JDBC();

        jdbc.createTable();
    }

}
