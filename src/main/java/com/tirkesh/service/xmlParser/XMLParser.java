package com.tirkesh.service.xmlParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.tirkesh.service.services.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.tirkesh.service.timeConverter.TimeConverter;

public class XMLParser
{
    private final TimeConverter timeConverter = new TimeConverter();

    public List<Service> Parse(String path) throws ParserConfigurationException, SAXException, IOException
    {
        System.out.println("start parsing !!");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(path));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("Service");
        return visitChildNodes(nList);
    }

    public  List<Service> visitChildNodes(NodeList nList)
    {
        List<Service> services = new ArrayList<>();
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                String[] param = node.getTextContent().split(" ");
                if(param.length == 3){
                    String companyName = param[0];
                    Long timeFrom = timeConverter.toMillis(param[1]);
                    Long timeTo = timeConverter.toMillis(param[2]);
                    services.add(new Service(companyName, timeFrom, timeTo));
                }
            }
        }

        System.out.println("end parsing file !!");
        System.out.println("data => " + services);
        return services;
    }
}
