import java.util.Random;

public class Sequence1 extends Sequence {
    Random random;

    public Sequence1(Game game) {
        super(game);
        random = new Random();
    }

    public void tick() {
        super.tick();
        if(game.getAssets().getCounter().check(20) && spawn) {
            attacks.add(new Attack1(game, random.nextInt(600) - 50, -50, 13, 14, 3, "/resources/textures/Fireball.png"));
            attacks.add(new Attack1(game, random.nextInt(600) - 50, -50, 12, 12, 3, "/resources/textures/FriendlinessPellet.png"));
        }
    }
}
