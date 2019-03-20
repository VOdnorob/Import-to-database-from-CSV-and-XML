package com.valentyn.odnorob;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Stack;

public class PersonParserHandler extends DefaultHandler {

    private ArrayList<Person> personList = new ArrayList<>();

    private Stack<String> elementStack = new Stack<>();

    private Stack<Person> objectStackPerson = new Stack<>();

    private Stack<Contact> objectStackContacts = new Stack<>();


    public void startDocument() throws SAXException {

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);
        if ("person".equalsIgnoreCase(qName)) {
            Person person = new Person();
            this.objectStackPerson.push(person);
        }

        if ("phone".equalsIgnoreCase(currentElement())) {
            Contact contact = new Contact();
            this.objectStackContacts.push(contact);
        } else if ("email".equalsIgnoreCase(currentElement())) {
            Contact contact = new Contact();
            this.objectStackContacts.push(contact);

        } else if ("icq".equalsIgnoreCase(currentElement())) {
            Contact contact = new Contact();
            this.objectStackContacts.push(contact);
        } else if ("jabber".equalsIgnoreCase(currentElement())) {
            Contact contact = new Contact();
            this.objectStackContacts.push(contact);
        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if ("person".equals(qName)) {
            Person object = this.objectStackPerson.pop();
            this.personList.add(object);
        }

        if ("contact".equalsIgnoreCase(qName)) {
            Person peek = this.objectStackPerson.peek();
            this.objectStackContacts.forEach(m -> peek.getContact().add(m));
            this.objectStackContacts.clear();
        }

    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if (value.length() == 0) {
            return;
        }


        if ("name".equalsIgnoreCase(currentElement())) {
            Person person = this.objectStackPerson.peek();
            person.setName(value);
        } else if ("surname".equalsIgnoreCase(currentElement())) {
            Person person = this.objectStackPerson.peek();
            person.setSurname(value);
        } else if ("age".equalsIgnoreCase(currentElement())) {
            Person person = this.objectStackPerson.peek();
            person.setAge(Integer.valueOf(value));
        } else if ("city".equalsIgnoreCase(currentElement())) {
            Person person = this.objectStackPerson.peek();
            person.setCity(value);

        } else if ("phone".equalsIgnoreCase(currentElement())) {
            Contact contact = this.objectStackContacts.peek();
            contact.setType(2);
            contact.setValue(value);

        } else if ("email".equalsIgnoreCase(currentElement())) {
            Contact contact = this.objectStackContacts.peek();
            contact.setType(1);
            contact.setValue(value);

        } else if ("icq".equalsIgnoreCase(currentElement())) {
            Contact contact = this.objectStackContacts.peek();
            contact.setType(3);
            contact.setValue(value);

        } else if ("jabber".equalsIgnoreCase(currentElement())) {
            Contact contact = this.objectStackContacts.peek();
            contact.setType(4);
            contact.setValue(value);
        }
    }

    private String currentElement() {
        return this.elementStack.peek();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

}
