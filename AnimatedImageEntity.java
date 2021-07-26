import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class AnimatedImageEntity extends ImageEntity {

    protected int currentFrame = 0;

    protected BufferedImage[] frames;

    public AnimatedImageEntity(Game game, float x, float y, int width, int height, int offset, String path) {
        super(game, x, y, width, height, offset, path);

        frames = ImageLoader.loadImagesFromSpriteSheet(path, width, height);
    }

    public void render(Graphics2D g2) {
        image = frames[currentFrame];
        super.render(g2);
    }

    public void cycle() {
        if (currentFrame + 1 >= frames.length) {
            currentFrame = 0;
        } else {
            currentFrame++;
        }
    }
}
