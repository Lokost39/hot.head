package hot.head.annotation.controllers;

public class ProfilengController implements ProfilengControllerMBean{
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
