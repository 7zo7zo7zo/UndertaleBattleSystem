import java.awt.*;

public class Entity {

    protected Game game;

    protected float x;
    protected float y;

    protected int width;
    protected int height;

    protected float angle;

    protected int speed;

    protected int offset;

    protected Rectangle hitbox;

    public Entity(Game game, float x, float y, int width, int height, int offset) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.offset = offset;

        hitbox = new Rectangle((int) x + offset, (int) y + offset, width - 2 * offset, height - 2 * offset);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getCenterX() {
        return x + width / 2;
    }

    public float getCenterY() {
        return y + height / 2;
    }

    public boolean collides(Entity e) {
        if (hitbox.intersects(e.hitbox)) {
            return true;
        }
        return false;
    }

    public void setAngle(float xTarget, float yTarget) {
        angle = (float) Math.atan2(yTarget - getCenterY(), xTarget - getCenterX());
    }

    public void linearMove() {
        x += (float) (speed * Math.cos(angle));
        y += (float) (speed * Math.sin(angle));
    }

    public void tick() {
        hitbox.setLocation((int) x + offset, (int) y + offset);
    }

    public void render(Graphics2D g2) {
        // g2.setColor(Color.YELLOW);
        // g2.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
}
