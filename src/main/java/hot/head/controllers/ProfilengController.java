package hot.head.controllers;

public class ProfilengController implements ProfilengControllerMBean{
    private boolean enable = true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
