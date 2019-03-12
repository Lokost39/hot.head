package hot.head.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "hot.head.screensaver")
public class ClassConfig {
    @Bean
//    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value = "prototype")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClassConfig.class);
        while (true){
            Thread.sleep(200);
            context.getBean(ColorFrame.class).showOnRandomPlace();
        }
    }
}
