package Ejemplo1.DOM.EscribirXML;

import org.w3c.dom.Attr;
import org.w3c.dom.Document; //IMPORTS!!!
import org.w3c.dom.Element;

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
public class EscribirXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        //Vinculamos la raiz al documento
        Element raiz = doc.createElement("root");
        doc.appendChild(raiz);

        raiz.appendChild(doc.createTextNode("\n")); //para q nos ponga en una linea diferente cada cosa
        Element element1 = doc.createElement("element1");//Definimos el elemento
        raiz.appendChild(element1);//Lo vinculamos a su padre
        raiz.appendChild(doc.createTextNode("\n"));//Salto de linea

        Attr atributo = doc.createAttribute("id");
        atributo.setValue("Valor del atributo");
        element1.setAttributeNode(atributo);//vinculamos el atributo al elemento

        Element element2 = doc.createElement("element2");
        element2.setTextContent("Contenido del elemento 2");
        raiz.appendChild(element2);
        raiz.appendChild(doc.createTextNode("\n"));

        //Montamos el XML
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource fuente = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("escribirConDOM.xml"));
        transformer.transform(fuente,result);
    }
}
