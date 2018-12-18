package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SimpleController {
    /**
     *
     * @return
     */
    //只需要简单的配置  该页代码  及pom   浏览器访问 ：http://localhost:8080/  返回springboot helloWorld
//    pom.xml
//    <parent>
//        <groupId>org.springframework.boot</groupId>
//        <artifactId>spring-boot-starter-parent</artifactId>
//        <version>1.5.3.RELEASE</version>
//    </parent>
//    <dependencies>
//        <dependency>
//            <groupId>org.springframework.boot</groupId>
//            <artifactId>spring-boot-starter-web</artifactId>
//        </dependency>
//    </dependencies>

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "springboot helloWorld";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class,args);
    }

}
