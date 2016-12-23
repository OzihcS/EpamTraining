package ua.nure.piontkovskyi.SummaryTask3;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;
import ua.nure.piontkovskyi.SummaryTask3.entity.Deposits;
import ua.nure.piontkovskyi.SummaryTask3.parsers.MyDOMParser;
import ua.nure.piontkovskyi.SummaryTask3.parsers.MySAXParser;
import ua.nure.piontkovskyi.SummaryTask3.parsers.MyStAXParser;
import ua.nure.piontkovskyi.SummaryTask3.util.Sorter;

/**
 * Entry point.
 */
public class Main {

    public static void getOutput(String xmlFileName) throws ParserConfigurationException,
            SAXException, IOException, TransformerException, XMLStreamException {

        System.out.println("Input ==> " + xmlFileName);
        MyDOMParser domParser = new MyDOMParser(xmlFileName);
        domParser.parse(true);

        Deposits deposits = domParser.getDeposits();
        System.out.println(System.lineSeparator() + "Parsed XML file: "
                + System.lineSeparator() + deposits);
        deposits = Sorter.sortByProfitability(deposits);
        MyDOMParser.saveToXML(deposits, "output.dom.xml");

        MySAXParser saxParser = new MySAXParser(xmlFileName);
        saxParser.parse(true);
        deposits = saxParser.getDeposits();
        deposits = Sorter.sortByTimeConstraints(deposits);
        MyDOMParser.saveToXML(deposits, "output.sax.xml");

        MyStAXParser staxParser = new MyStAXParser(xmlFileName);
        staxParser.parse();
        deposits = staxParser.getDeposits();
        deposits = Sorter.sortByAmount(deposits);
        MyDOMParser.saveToXML(deposits, "output.stax.xml");
    }

    public static void main(String[] args) {
        try {
            getOutput(args[0]);
        } catch (ParserConfigurationException | SAXException | IOException
                | TransformerException | XMLStreamException e) {
            System.err.println("Incorrent XML file: " + args[0] + " "
                    + e.getMessage());
        }

    }
}