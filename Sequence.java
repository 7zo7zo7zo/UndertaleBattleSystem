import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Sequence extends Logic {
    protected ArrayList<Entity> attacks;

    protected boolean spawn;
    protected boolean done;

    public Sequence(Game game) {
        super(game);

        attacks = new ArrayList<Entity>();
        spawn = true;
        done = false;
    }

    public void tick() {
        if(attacks.size() > 0) {
            done = false;
            for (int i = 0; i < attacks.size(); i++) {
                attacks.get(i).tick();
                if (game.getAssets().getSoul().collides(attacks.get(i))) {
                    game.getAssets().setHP(game.getAssets().getHP() - 1);
                }
                if (attacks.get(i).getX() < -50 || attacks.get(i).getX() > 550 || attacks.get(i).getY() < -50 || attacks.get(i).getY() > 550) {
                    attacks.set(i, null);
                }
            }
            attacks.removeAll(Collections.singleton(null));
        }
        else done = true;
    }

    public void render(Graphics2D g2) {
        if(attacks.size() > 0) {
            for (int i = 0; i < attacks.size(); i++) {
                attacks.get(i).render(g2);
            }
        }
    }
}
