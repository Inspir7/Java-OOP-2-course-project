package com.company;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLFile {

    public static final String xmlFilePath = "C:\\Users\\Presiyana\\IdeaProjects\\XMLFilesProject\\xmlfile.xml";

    public static void createXMLFile() {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance(); // xml -> DOM Obj tree
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder(); // create xml
            Document document = documentBuilder.newDocument();

            // root element - people
            Element root = document.createElement("people"); // interface Element (HTML/XML)
            document.appendChild(root);

            // child element - person1
            Element employee = document.createElement("person");
            root.appendChild(employee);

          // set an attribute to а person element
            Attr attr = document.createAttribute("id"); // interface Attr
            attr.setValue("1");
            employee.setAttributeNode(attr); // adds a new attribute node

            // firstname element1
            Element firstName1 = document.createElement("name");
            firstName1.appendChild(document.createTextNode("John"));
            employee.appendChild(firstName1);

            // address element1
            Element address1 = document.createElement("address");
            address1.appendChild(document.createTextNode("USA"));
            employee.appendChild(address1);

            // child element - person2
            Element employee2 = document.createElement("person");
            root.appendChild(employee2);

            // set an attribute to а person element
            Attr attr2 = document.createAttribute("id");
            attr2.setValue("2");
            employee2.setAttributeNode(attr2);

            // firstname element2
            Element firstName2 = document.createElement("name");
            firstName2.appendChild(document.createTextNode("Presi"));
            employee2.appendChild(firstName2);

            // address element2
            Element address2 = document.createElement("address");
            address2.appendChild(document.createTextNode("Bulgaria"));
            employee2.appendChild(address2);

            // child element - person3
            Element employee3 = document.createElement("person");
            root.appendChild(employee3);

            // set an attribute to а person element
            Attr attr3 = document.createAttribute("id");
            attr3.setValue("3");
            employee3.setAttributeNode(attr3);

            // firstname element3
            Element firstName3 = document.createElement("name");
            firstName3.appendChild(document.createTextNode("John"));
            employee3.appendChild(firstName3);

            // address element3
            Element address3 = document.createElement("address");
            address3.appendChild(document.createTextNode("UK"));
            employee3.appendChild(address3);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(); // transform a source tree into a result tree
            DOMSource domSource = new DOMSource(document); // DOM S. - holder, dokato nastupi krainata transformaciq ->
            StreamResult streamResult = new StreamResult(new File(xmlFilePath)); // rezultata ot deistvieto (DOM ob. se zapisva
                                                                                 // vuv faila posr SR

            transformer.transform(domSource, streamResult); // zapis na DOM ob v izhodniq potok - file

        } catch (ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
        }
    }
}