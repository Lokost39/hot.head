package hot.head;

import hot.head.bean.MyQuoter;
import hot.head.bean.Quoter;
import hot.head.bean.deprecation.DeprecatedClass;
import hot.head.bean.deprecation.OldClass;
import hot.head.config.MyConfig;
import hot.head.listener.events.MyEvents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("start");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuoter();

        DeprecatedClass deprecatedClass = context.getBean(DeprecatedClass.class);
        deprecatedClass.test1();
        deprecatedClass.test2();

        context.publishEvent(new MyEvents(new Object(), "Мой слушатель"));
        System.out.println("главный поток");

        String a = "Hello";
        String b = "Hello";

        System.out.println(a == b);

//        while (true){
//            Thread.sleep(200);
//            quoter.sayQuoter();
//        }

    }

}
