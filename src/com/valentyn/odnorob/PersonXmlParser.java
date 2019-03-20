package com.valentyn.odnorob;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PersonXmlParser {

   static PersonParserHandler handler = new PersonParserHandler();
    public ArrayList parseXml(InputStream inputStream) throws SAXException, IOException {

        ArrayList<Person> personList = new ArrayList<Person>();

            XMLReader parser = XMLReaderFactory.createXMLReader();

            PersonParserHandler handler = new PersonParserHandler();


            parser.setContentHandler(handler);

            InputSource source = new InputSource(inputStream);

            parser.parse(source);

        System.out.println(handler.getPersonList());

        return personList;
    }
}
