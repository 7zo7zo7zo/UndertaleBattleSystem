import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageEntity extends Entity {

    protected BufferedImage image;

    public ImageEntity(Game game, float x, float y, int width, int height, int offset, String path) {
        super(game, x, y, width, height, offset);
        image = ImageLoader.loadImage(path);
    }

    public void render(Graphics2D g2) {
        g2.drawImage(image, (int) x, (int) y, null);
        super.render(g2);
    }
}
