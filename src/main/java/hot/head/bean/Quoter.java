package hot.head.bean;

import hot.head.annotation.PostProxy;

public interface Quoter {
    public void sayQuoter();
    @PostProxy
    public void start();
}
