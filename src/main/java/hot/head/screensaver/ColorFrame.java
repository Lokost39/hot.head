package hot.head.screensaver;

import java.awt.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Random;

@Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame(){
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace(){
        Random random = new Random();
        setLocation(random.nextInt(800), random.nextInt(600));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor() ;

}
