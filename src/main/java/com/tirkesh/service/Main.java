package com.tirkesh.service;

import com.tirkesh.service.services.Service;
import com.tirkesh.service.services.ServiceFilter;
import com.tirkesh.service.xmlParser.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        XMLParser f = new XMLParser();
        System.out.println("you enter arg ["+ args[0] + "]");
        String path = args[0];
        ServiceFilter sorter = new ServiceFilter();
        List<Service> list = f.Parse(path);
        List<Service> services = sorter.filter(list);

        List<Service> poshList = services.stream()
                .filter(s -> s.getCompanyName().equals("Posh"))
                .collect(Collectors.toList());
        List<Service> grottyList = services.stream()
                .filter(s -> s.getCompanyName().equals("Grotty"))
                .collect(Collectors.toList());
        String res = toString(poshList)
                .concat("\n")
                .concat(toString(grottyList))
                .concat("<EOF>");
        System.out.println("output of file => \n" + res);

        FileWrite fileWrite=new FileWrite();
        fileWrite.write(res);
        System.out.println(res);

        System.out.println("file path [ root::output.txt ]");
    }

    private static String toString(List<Service> list) {
        StringBuilder data = new StringBuilder();
        list.forEach(l -> data.append(l.toXml()));
        return data.toString();
    }
}
