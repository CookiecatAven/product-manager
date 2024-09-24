package ch.csbe.productmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProductManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagerApplication.class, args);
    }

    @RestController
    @RequestMapping("playground")

    public static class PlaygroundController {

        @GetMapping("hello-world")
        public String helloWorld() {
            return "Hello Java Spring Boot";
        }
    }
}
