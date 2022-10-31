import java.awt.*;

public abstract class Logic {
    protected Game game;

    public Logic(Game game) {
        this.game = game;
    }

    public abstract void tick();
    public abstract void render(Graphics2D g2);
}