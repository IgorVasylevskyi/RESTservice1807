package Exchange;

import Exchange.connection.Connection;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.text.ParseException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException, JSONException, ParseException {
        Connection.connection();
        SpringApplication.run(Main.class, args);
    }
}
