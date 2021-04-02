
import java.io.*;

public class FileRead {
    public void FRead()throws IOException {
        File file=new File("input.xml");
        if(!file.exists()){
            file.createNewFile();
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.flush();
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write("<Service>\n" +
                    "<Service>Posh 10:15 11:10</Service>\n" +
                    "<Service>Posh 10:10 11:00</Service>\n" +
                    "<Service><Grotty 10:10 11:00/Service>\n" +
                    "<Service>Grotty 16:30 18:45</Service>\n" +
                    "<Service>Posh 12:05 12:30</Service>\n" +
                    "<Service>Grotty 12:30 13:25</Service>\n" +
                    "<Service>Grotty 12:45 13:25</Service>\n" +
                    "<Service>Posh 17:25 18:01</Service>\n"+
                    "</Service>");
            bufferedWriter.flush();
        }
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            System.out.printf(bufferedReader.readLine());
        }
        long startTime = System.currentTimeMillis();

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
