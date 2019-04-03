package hot.head.bean.deprecation;

import hot.head.annotation.DeprecatedClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@DeprecatedClass(newImpl = NewClass.class)
public class OldClass implements hot.head.bean.deprecation.DeprecatedClass {
    //    private OldClass() {
//    }
//
//    @Bean
//    public OldClass getOldClass(){
//        return new OldClass();
//    }
    @Override
    public void test1() {
        System.out.println("test 1");
    }

    @Override
    public void test2() {
        System.out.println("test 2");
    }

    public static void main(String[] args) throws Exception {
        List list = new ArrayList();
        list.add("val1"); //1
        list.add(1, "val3"); //3
               list.add(2, "val2"); //2

              System.out.println(list);      }


}
