package hot.head.bean;

import hot.head.annotation.MyInjectRandomInt;

import javax.annotation.PostConstruct;

public class MyQuoter implements Quoter {

    @MyInjectRandomInt(min = 2, max = 7)
    private int ramdom;

    private String message;

    @PostConstruct
    public void init(){
        System.out.println("init() = " + ramdom);
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
