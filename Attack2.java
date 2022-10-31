public class Attack2 extends AnimatedImageEntity {

    int count;

    public Attack2(Game game, float x, float y, int width, int height, int offset, String path, float angle) {
        super(game, x, y, width, height, offset, path);
        this.angle = angle;
        speed = 2;
        count = 0;
    }
    public void tick() {
        angle += 0.01;
        linearMove();
        if (game.getAssets().getCounter().check(10)) {
            cycle();
        }
        super.tick();
        count++;
    }
}
