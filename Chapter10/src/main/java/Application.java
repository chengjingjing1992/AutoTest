import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //这个类托管给springboot
@ComponentScan("com.course")//扫描这个包下的
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
