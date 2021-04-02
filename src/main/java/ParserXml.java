import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserXml
{
    public void Parse() throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(new File("Services.xml"));

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Get all employees
        NodeList nList = document.getElementsByTagName("Service");
        System.out.println("============================");

        List<Service> services = visitChildNodes(nList);
        System.out.println(services);
//            task-2 {
//        -parse string time to date time
//                -convert date time to millis time
//                -service sorter by millis
//    }
//        task-3 create prioroty checker //comparator by name and time

//        services.forEach(s->{
//            s.
//        });
    }

    public  List<Service> visitChildNodes(NodeList nList)
    {
        List<Service> services = new ArrayList<>();
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
                String[] param = node.getTextContent().split(" ");
                if(param.length == 3){
                    services.add(new Service(param[0],param[1],param[2]));
                }
            }
        }
        return services;
    }

}
