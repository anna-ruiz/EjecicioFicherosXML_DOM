package Ejemplo1.DOM.LeerXML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class LeerXML {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File fichero = new File("src/Ejemplo1/leerConDOM.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();


        Document doc = db.parse(fichero);

        doc.getDocumentElement().normalize();

        System.out.println("Elemento raíz: "+doc.getDocumentElement().getNodeName());
        NodeList listaEmpleados = doc.getElementsByTagName("empleado");

        for (int i = 0; i < listaEmpleados.getLength(); i++) {

            Node nodo = listaEmpleados.item(i);
            System.out.println("Elemento "+nodo.getNodeName());

            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) nodo;
                System.out.println("id: "+element.getAttribute("id"));
                System.out.println("Nombre: "+element.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Username: "+element.getElementsByTagName("username").item(0).getTextContent());
                System.out.println("Password: "+element.getElementsByTagName("password").item(0).getTextContent());


            }

        }
    }

}
