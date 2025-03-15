package de.felixschick.smarthomerestapi.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;

public class XMLValueExtractor {

    public static String getValueFromXML(String xmlContent, String expression) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlContent.getBytes("ISO-8859-1")));

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            NodeList nodeList = (NodeList) xPath.evaluate(expression, document, XPathConstants.NODESET);

            if (nodeList.getLength() > 0) {
                return nodeList.item(0).getNodeValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}