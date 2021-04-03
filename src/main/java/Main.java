import Services.Service;
import Services.ServiceFilter;
import Services.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        XMLParser f = new XMLParser();
        String path = "/home/bottle/Downloads/untitled/Services.xml";
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
                .concat(toString(grottyList)).concat("<EOF>");
        FileWrite fileWrite=new FileWrite();
        fileWrite.write(res);
        System.out.println(res);
    }

    private static String toString(List<Service> list) {
        StringBuilder data = new StringBuilder();
        list.forEach(l -> data.append(l.toString()));
        return data.toString();
    }
}
