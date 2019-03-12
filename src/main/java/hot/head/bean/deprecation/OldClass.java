package hot.head.bean.deprecation;

import hot.head.annotation.DeprecatedClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
//@DeprecatedClass(newImpl = NewClass.class)
public class OldClass implements hot.head.bean.deprecation.DeprecatedClass {
    private OldClass() {
    }
    
    @Bean
    public OldClass getOldClass(){
        return new OldClass();
    }
    @Override
    public void test1(){
        System.out.println("test 1");
    }
    @Override
    public void test2(){
        System.out.println("test 2");
    }
}
