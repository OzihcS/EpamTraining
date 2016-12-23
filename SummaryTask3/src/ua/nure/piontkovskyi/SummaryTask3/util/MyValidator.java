package ua.nure.piontkovskyi.SummaryTask3.util;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Class that validates XML documents against XSD schema.
 */
public class MyValidator {

    /**
     * Method which validate XML file against XSD schema.
     * @param xsd SXD schema.
     * @param xml XML document.
     * @return true if xml is valid and false if isn't valid.
     */
    public static boolean validateXMLSchema(String xsd, String xml) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsd));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xml)));
        } catch (IOException | SAXException e) {
            System.out.println("Invalid XML file " + e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("output.dom.xml validates against input.xsd ==> "
                        + validateXMLSchema("output.xsd", "output.dom.xml"));
        System.out.println("output.sax.xml validates against input.xsd ==> "
                        + validateXMLSchema("output.xsd", "output.sax.xml"));
        System.out.println("output.stax.xml validates against input.xsd ==> "
                        + validateXMLSchema("output.xsd", "output.stax.xml"));
    }
}
