package TestingFrameworks.JUnit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LightTest {
    @Test
    public void whenSwitchOn_ThenIsOnReturnTrue() throws Exception {
        Light light = new Light();
        light.switchOn();
        assertEquals(true, light.isOn());
    }

    @Test
    public void whenSwitchOffAfterSwitchOn_ThenIsOnReturnFalse() throws Exception {
        Light light = new Light();
        light.switchOn();
        light.switchOff();
        assertEquals(false, light.isOn());
    }
}
