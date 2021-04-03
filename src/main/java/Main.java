import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException, InterruptedException {
//        ParserXml f=new ParserXml();
            TimeConverter timeConverter=new TimeConverter();
            timeConverter.toMillis();
        System.out.println(timeConverter.milliToLocal(timeConverter.toMillis()));
        System.out.println(timeConverter.toMillis());

    }
}
