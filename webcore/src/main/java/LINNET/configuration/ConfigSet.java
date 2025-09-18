package LINNET.configuration;

import org.hibernate.cfg.Environment;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Logger;

public class ConfigSet {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ConfigSet.class);
    Logger logger = Logger.getLogger(ConfigSet.class.getName());

    private BufferedReader bufferedReaderENV = new BufferedReader(new FileReader(
            "D:/linnet/webcore/src/main/java/LINNET/configuration/.env"
    ));
    private BufferedWriter bufferedWriterPROP = new BufferedWriter(
            new FileWriter("src/main/resources/application.properties"
            ));

    private LinkedList<String> Name = new LinkedList<>(Arrays.asList(
            "spring.application.name",
            "spring.datasource.url",
            "spring.datasource.username",
            "spring.datasource.password",
            "server.servlet.session.timeout",
            "server.servlet.session.cookie.name",
            "server.servlet.session.cookie.http-only"
    ));

    private LinkedList<String> Key = new LinkedList<>();

    public ConfigSet() throws IOException {
    }

    public void setCfg() throws IOException {
        String line;
        while ((line=bufferedReaderENV.readLine())!=null){
            Key.add(line);
        }
        for (int i = 0; i < Key.size(); i++){
            bufferedWriterPROP.write(Name.get(i) + "=" + Key.get(i));
            bufferedWriterPROP.newLine();
        }

        try {
            bufferedReaderENV.close();
            bufferedWriterPROP.close();
        }
        catch (Exception e){
            logger.info("ERROR WITH BOOTING CONFIG");
        }
    }

    public void clearCfg(){
        for (int i = 0; i < Key.size(); i++){
            try {
                bufferedWriterPROP.write(Name.get(i) + "=" + "");
            } catch (IOException e) {
                logger.info("ERROR WITH CLEARING CONFIG");
                throw new RuntimeException(e);
            }
            try {
                bufferedWriterPROP.newLine();
            } catch (IOException e) {
                logger.info("ERROR WITH CLEARING CONFIG");
                throw new RuntimeException(e);
            }

        }
        try {
            bufferedReaderENV.close();
            bufferedWriterPROP.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
