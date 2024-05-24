import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Worm {
    private BufferedImage right;
    private BufferedImage left;
    private double x;
    private double y;
    private boolean fRight;
    private double speed = .01;
    public Worm(String right, String left) {
        fRight = true;
        x = 400;
        y = 290;
        try {
            this.right = ImageIO.read(new File(right));
            this.left = ImageIO.read(new File(left));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getX() {
        return (int) x;
    }
    public int getY() {
        return (int) y;
    }
    public void fRight() {
        fRight = true;
    }
    public void fLeft() {
        fRight = false;
    }
    public void moveRight() {
        if (x + speed <= 750) {
            x += speed;
        }
    }
    public void moveLeft() {
        if (x - speed >= 0) {
            x-= speed;
        }
    }
    public BufferedImage getWorm() {
        if (fRight) {
            return right;
        } else {
            return left;
        }
    }
    public Rectangle wormRect() {
        int wormW = getWorm().getWidth();
        int wormH = getWorm().getHeight();
        Rectangle r = new Rectangle((int) x, (int) y, wormW, wormH);
        return r;
    }
}
