package LINNET.configuration;

import org.hibernate.cfg.Environment;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;

public class ConfigSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReaderENV = new BufferedReader(new FileReader("D:/linnet/webcore/src/main/java/LINNET/configuration/.env"));
        BufferedWriter bufferedWriterPROP = new BufferedWriter(
                new FileWriter("src/main/resources/application.properties"));

        LinkedList<String> Name = new LinkedList<>(Arrays.asList(
                "spring.application.name",
                "spring.datasource.url",
                "spring.datasource.username",
                "spring.datasource.password",
                "server.servlet.session.timeout",
                "server.servlet.session.cookie.name",
                "server.servlet.session.cookie.http-only"
        ));

        LinkedList<String> Key = new LinkedList<>();
        String line;
        while ((line=bufferedReaderENV.readLine())!=null){
            Key.add(line);
        }
        for (int i = 0; i < Key.size(); i++){
            bufferedWriterPROP.write(Name.get(i) + "=" + Key.get(i));
            bufferedWriterPROP.newLine();
        }

        bufferedReaderENV.close();
        bufferedWriterPROP.close();
    }
}
