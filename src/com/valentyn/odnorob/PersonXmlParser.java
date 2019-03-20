package com.valentyn.odnorob;

import com.valentyn.odnorob.Person;
import com.valentyn.odnorob.PersonParserHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PersonXmlParser {


    static PersonParserHandler handler = new PersonParserHandler();

    public ArrayList parseXml(InputStream inputStream) throws SAXException, IOException {

        ArrayList<Person> personList = new ArrayList<>();

            XMLReader parser = XMLReaderFactory.createXMLReader();

            parser.setContentHandler(handler);

            InputSource source = new InputSource(inputStream);

            parser.parse(source);

        System.out.println(handler.getPersonList());

        return personList;
    }
}
