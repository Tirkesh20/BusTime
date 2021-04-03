import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException, InterruptedException {
        ParserXml f = new ParserXml();
        ServiceFilter sorter = new ServiceFilter();
        List<Service> list = f.Parse(args[0]);
        List<Service> services = sorter.filter(list);
        System.out.println(services);

    }
}
