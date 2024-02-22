package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication //tiene dentro las anotaciones componentscan, enableautoconfig y config
//@ComponentScan(basePackages = "com.amigoscode") //to tell the package that have to look for
//@EnableAutoConfiguration
//@Configuration //to instantiate beans configurations
@RestController //indica que la clase es un controller y todos los metodos devolveran una respuesta JSON
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //    @GetMapping("/greet")
    //    public String greet(){
    //        return "Hello";
    //    }
    @GetMapping("/greet")
    public GreetResponse greet(@RequestParam(value = "name", required = false) String name){

        String greetMessage = name == null || name.isBlank() ? "Hello name is blank" : "Hello " + name;

        GreetResponse response = new GreetResponse(
                greetMessage,
                List.of("Java","Goland", "Javascript"),
                new Person("Alex", 28, 30000));
        return response;
    }

    //devuelve la peticion en formato jason
    record Person(String name, int age, double savings){

    }
    record GreetResponse(String greet,
                         List<String> favProgrammingLanguages,
                         Person person){

    }

    //lo mismo que record
//    class GreetResponse{
//        private final String greet;
//
//        GreetResponse(String greet){
//            this.greet = greet;
//        }
//        public String getGreet(){
//            return greet;
//        }
//    }
}
