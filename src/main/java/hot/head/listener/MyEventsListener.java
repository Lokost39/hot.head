package hot.head.listener;

import hot.head.listener.events.MyEvents;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventsListener implements ApplicationListener<MyEvents> {
    @Override
    public void onApplicationEvent(MyEvents event) {
        System.out.println(event.getMessage());
    }
}
