package hot.head.config;

import hot.head.bean.MyQuoter;
import hot.head.bean.Quoter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hot.head.*")
public class MyConfig {
    @Bean
    public Quoter quoter(){
        return new MyQuoter("message");
    }

//    @Bean
//    public InjectMyRamdomIntAnnotationBeanPostProcessor injectMyRamdomIntAnnotationBeanPostProcessor(){
//        return new InjectMyRamdomIntAnnotationBeanPostProcessor();
//    }
}
