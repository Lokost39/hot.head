package hot.head.listener;

import hot.head.listener.events.MyEvents;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventsListener implements ApplicationListener<MyEvents> {
    @Override
    public void onApplicationEvent(MyEvents event) {
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(event.getMessage());
    }
}
