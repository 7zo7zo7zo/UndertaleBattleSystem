public class Soul extends ImageEntity {

    public Soul(Game game, float x, float y, int width, int height, int offset, String path) {
        super(game, x, y, width, height, offset, path);
        speed = 2;
    }

    public void tick() {
        super.tick();
        if (game.getInput().up) {
            y -= speed;
            hitbox.setLocation((int) x + offset, (int) y + offset);
            if (!collides(game.getAssets().getDialogueBox())) {
                y += speed;
            }
        }
        if (game.getInput().down) {
            y += speed;
            hitbox.setLocation((int) x + offset, (int) y + offset);
            if (!collides(game.getAssets().getDialogueBox())) {
                y -= speed;
            }
        }
        if (game.getInput().left) {
            x -= speed;
            hitbox.setLocation((int) x + offset, (int) y + offset);
            if (!collides(game.getAssets().getDialogueBox())) {
                x += speed;
            }
        }
        if (game.getInput().right) {
            x += speed;
            hitbox.setLocation((int) x + offset, (int) y + offset);
            if (!collides(game.getAssets().getDialogueBox())) {
                x -= speed;
            }
        }
        super.tick();
    }
}
