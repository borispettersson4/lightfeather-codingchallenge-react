import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Server Application API, Hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
