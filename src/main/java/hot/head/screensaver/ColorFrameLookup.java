package hot.head.screensaver;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component("ColorFrameLookup")
public class ColorFrameLookup extends ColorFrame {
    @Override
    @Lookup
    protected Color getColor() {
        return null;
    }
}
