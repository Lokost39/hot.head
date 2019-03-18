package hot.head.listener.events;

import org.springframework.context.ApplicationEvent;

public class MyEvents extends ApplicationEvent {
    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvents(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
