package hot.head.bean;

public class NewMyQuoter extends MyQuoter implements Quoter {
    public NewMyQuoter(String message) {
        super(message);
    }

    @Override
    public void sayQuoter() {
        System.out.println("NewMyQuoter sayQuoter");
    }

//    @Override
//    public void start() {
//        System.out.println("NewMyQuoter start");
//    }
}
