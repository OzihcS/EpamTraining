package ua.nure.piontkovskyi.SummaryTask3.parsers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.piontkovskyi.SummaryTask3.util.XML;
import ua.nure.piontkovskyi.SummaryTask3.entity.Bank;
import ua.nure.piontkovskyi.SummaryTask3.entity.Deposits;
import ua.nure.piontkovskyi.SummaryTask3.entity.Type;

/**
 * Parser for SAX parser.
 */
public class MySAXParser extends DefaultHandler {

    private String xmlFileName;
    private String currentElement;
    private Bank bank;
    private Deposits deposits;

    public Deposits getDeposits() {
        return deposits;
    }

    public MySAXParser(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    /**
     * Parses XML document
     * @param validate If true validate XML document against XML schema. With this
     *                 parameter it's possible make parser validating.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void parse(boolean validate) throws ParserConfigurationException,
            SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        if (validate) {
            factory.setFeature("http://xml.org/sax/features/validation", true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);
        }
        factory.newSAXParser().parse(xmlFileName,this);
    }


    /**
     *  Content handler implementation
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        currentElement = localName;
        if (XML.DEPOSITS.isEqual(currentElement)) {
            deposits = new Deposits();
            return;
        }
        if (XML.BANK.isEqual(currentElement)) {
            bank = new Bank();
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String elementText = new String(ch, start, length).trim();
        if (elementText.isEmpty()) {
            return;
        }
        if (XML.NAME.isEqual(currentElement)) {
            bank.setName(elementText);
            return;
        }
        if (XML.COUNTRY.isEqual(currentElement)) {
            bank.setCountry(elementText);
            return;
        }
        if (XML.DEPOSITOR.isEqual(currentElement)) {
            bank.setDepositorName(elementText);
            return;
        }

        if (XML.TYPE.isEqual(currentElement)) {
            bank.setType(Type.getTypeByName(elementText));
        }

        if (XML.ACCOUNT_ID.isEqual(currentElement)) {
            bank.setAccountId(Long.parseLong(elementText));
            return;
        }
        if (XML.AMOUNT_ON_DEPOSIT.isEqual(currentElement)) {
            bank.setAmountOnDeposit(Double.parseDouble(elementText));
            return;
        }
        if (XML.PROFITABILITY.isEqual(currentElement)) {
            bank.setProfitability(Double.parseDouble(elementText));
            return;
        }
        if (XML.TIME_CONSTRAINTS.isEqual(currentElement)) {
            bank.setTimeConstraint(Integer.parseInt(elementText));
            return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (XML.BANK.isEqual(localName)) {
            deposits.add(bank);
            return;
        }
    }
}