import java.awt.*;

public class DialogueBox extends Entity {

    protected BasicStroke stroke;

    public DialogueBox(Game game, float x, float y, int width, int height, int offset) {
        super(game, x, y, width, height, offset);

        stroke = new BasicStroke(6);
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setStroke(stroke);
        g2.drawRect((int) x, (int) y, width, height);
        super.render(g2);
    }
}
