package hot.head;

import hot.head.bean.MyQuoter;
import hot.head.bean.Quoter;
import hot.head.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args){

        System.out.println("start");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuoter();
    }

}
