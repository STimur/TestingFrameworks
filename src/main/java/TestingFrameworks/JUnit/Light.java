package TestingFrameworks.JUnit;

public class Light {
    private boolean on;

    public boolean isOn() {
        return on;
    }

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }
}
