package hot.head.inject.method;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "hot.head.inject.method")
public class ClassConfig {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ClassConfig.class);
        B b = context.getBean(A.class).getB();
        System.out.println(b);
    }
}
