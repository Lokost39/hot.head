package hot.head.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitQuoter {

    @Bean(initMethod = "init")
    public InitQuoter getInitQuoter() {
        return this;
    }

    public void init() {
        System.out.println(InitQuoter.class);
    }

}
