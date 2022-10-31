import java.util.Collections;

public class Sequence2 extends Sequence {

    float angle;

    public Sequence2(Game game) {
        super(game);
        angle = 0;
    }

    public void tick() {
        if(attacks.size() > 0) {
            done = false;
            for (int i = 0; i < attacks.size(); i++) {
                attacks.get(i).tick();
                if (game.getAssets().getSoul().collides(attacks.get(i))) {
                    game.getAssets().setHP(game.getAssets().getHP() - 1);
                }
                if (attacks.get(i).count > 1885) {
                    attacks.set(i, null);
                }
            }
            attacks.removeAll(Collections.singleton(null));
        }
        else done = true;

        angle += 0.1;
        if (game.getAssets().getCounter().check(10) && spawn) {
            attacks.add(new Attack2(game, 242, 243, 13, 14, 3, "/resources/textures/Fireball.png", angle));
        }
    }
}
