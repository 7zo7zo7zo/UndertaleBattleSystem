public class Attack1 extends AnimatedImageEntity {

    public Attack1(Game game, float x, float y, int width, int height, int offset, String path) {
        super(game, x, y, width, height, offset, path);

        setAngle(game.getAssets().getSoul().getCenterX(), game.getAssets().getSoul().getCenterY());
        speed = 5;
    }

    public void tick() {
        linearMove();
        if (game.getAssets().getCounter().check(10)) {
            cycle();
        }
        super.tick();
    }
}
