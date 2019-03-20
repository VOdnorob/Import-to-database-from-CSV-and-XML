package com.valentyn.odnorob;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, SAXException, ParserConfigurationException {

        File xmlFile = new File("dane-osoby.xml");

        PersonXmlParser parser = new PersonXmlParser();

        parser.parseXml(new FileInputStream(xmlFile));

        JDBC jdbc = new JDBC();
        jdbc.connectionToDataBase();


    }

}
