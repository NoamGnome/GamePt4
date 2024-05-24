import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public GameFrame() {
        JFrame f = new JFrame("meh");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 500);

        GameScreen s = new GameScreen();
        f.add(s);
        f.setVisible(true);
    }
}
