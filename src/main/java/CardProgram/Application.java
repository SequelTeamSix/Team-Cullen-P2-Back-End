package CardProgram;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        // I am making this mainly so I have something to run in the program and update
        // the DBeaver.
        System.out.println("Application has run. Check for updates.");

        SpringApplication.run(Application.class);

    }

}
