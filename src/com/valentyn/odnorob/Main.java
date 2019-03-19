package com.valentyn.odnorob;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, SAXException, ParserConfigurationException {

        JDBC jdbc = new JDBC();
        jdbc.connectionToDataBase();
        jdbc.createTable();

    }

}
