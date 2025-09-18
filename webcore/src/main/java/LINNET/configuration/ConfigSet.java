package LINNET.configuration;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConfigSet {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("application.properties"));
        Scanner scanner = new Scanner(System.in);

        String jsonString = """
                {"config":
                    {
                    "name" : "webcore",
                    "url" : "jdbc:postgresql://localhost:5432/testdb",
                    "username" : "postgres",
                    "password" : "0011",
                    "timeout" :"1800",
                    "cookie.name" : "MYSESSIONID",
                    "session.cookie.http-only" : "true"
                    }
                }
                """;
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject);
    }
}
