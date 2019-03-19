package com.valentyn.odnorob;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Stack;

public class PersonParserHandler extends DefaultHandler {

    private ArrayList personList = new ArrayList();

    private Stack elementStack = new Stack();

    private Stack objectStack = new Stack();

    public void startDocument() throws SAXException {

    }

    public void endDocument() throws SAXException {

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);

        Person person = new Person();
        this.objectStack.push(person);

    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (value.length() == 0) {
            return;
        }
        if ("name".equalsIgnoreCase(currentElement())) {
            Person person = (Person) this.objectStack.peek();
            person.setName(value);
        } else if ("surname".equalsIgnoreCase(currentElement())) {
            Person person = (Person) this.objectStack.peek();
            person.setSurname(value);
        } else if ("age".equalsIgnoreCase(currentElement())) {
            Person person = (Person) this.objectStack.peek();
            person.setSurname(value);
        } else if ("city".equalsIgnoreCase(currentElement())){
            Person person = new Person();
            person.setCity(value);
        }


    }

    private String currentElement(){
        return (String) this.elementStack.peek();
    }

    public ArrayList getPersonList(){
        return personList;
    }
}
