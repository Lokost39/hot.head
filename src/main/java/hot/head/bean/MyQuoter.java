package hot.head.bean;

import hot.head.annotation.DeprecatedClass;
import hot.head.annotation.MyInjectRandomInt;
import hot.head.annotation.MyProfile;
import hot.head.annotation.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@MyProfile
//@DeprecatedClass(newImpl = NewMyQuoter.class)
public class MyQuoter implements Quoter {

//    @Autowired
//    Quoter myQuoter;

    @MyInjectRandomInt(min = 2, max = 7)
    private int ramdom;

    private String message;

    @PostConstruct
    public void init(){
        System.out.println("init() = " + ramdom);
    }

    @Override
    public void start(){
        System.out.println("============start()===============");
        System.out.println(message);
//        myQuoter.sayQuoter();
        System.out.println("============start()===============");
    }

    public MyQuoter(String message) {
        System.out.println("MyQuoter(String message) ramdom = " + ramdom);
        this.message = message;
    }

    public int getRamdom() {
        return ramdom;
    }

    @Override
    public void sayQuoter() {
        System.out.println(ramdom);
        System.out.println(message);
    }
}
