package com.company;

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

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element - people
            Element root = document.createElement("people");
            document.appendChild(root);

            // child element - person
            Element employee = document.createElement("person");
            root.appendChild(employee);

          /*  // set an attribute to а person element
            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            employee.setAttributeNode(attr);*/

            // firstname element1
            Element firstName1 = document.createElement("name");
            firstName1.appendChild(document.createTextNode("James"));
            employee.appendChild(firstName1);

            // address element1
            Element address1 = document.createElement("address");
            address1.appendChild(document.createTextNode("USA"));
            employee.appendChild(address1);

            // firstname element2
            Element firstName2 = document.createElement("name");
            firstName2.appendChild(document.createTextNode("Presi"));
            employee.appendChild(firstName2);

            // address element2
            Element address2 = document.createElement("address");
            address2.appendChild(document.createTextNode("Bulgaria"));
            employee.appendChild(address2);

            // create the xml file

            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
