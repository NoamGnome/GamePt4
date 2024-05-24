import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements KeyListener, MouseListener {
    public Worm worm;
    private BufferedImage background;
    private boolean[] keys;
    public GameScreen() {
        try {
            background = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        worm = new Worm("src/wormR.png", "src/wormL.png");
        keys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.PINK);
        g.drawImage(background, 0, 0, null);
        g.drawImage(worm.getWorm(), worm.getX(), worm.getY(), null);
        if (keys[65]) {
            worm.fLeft();
            worm.moveLeft();
        }
        if (keys[68]) {
            worm.fRight();
            worm.moveRight();
        }
    }
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        keys[key] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
