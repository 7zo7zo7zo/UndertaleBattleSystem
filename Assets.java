import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Assets {
    private Game game;

    private Counter counter;

    private int HP = 20;

    private DialogueBox dialogueBox;
    private final Soul soul;

    private Random random;
    private ArrayList<Entity> attacks;

    public Assets(Game game) {
        this.game = game;


        counter = new Counter();
        dialogueBox = new DialogueBox(game, 150, 150, 200, 200, 14);
        soul = new Soul(game, 242, 242, 16, 16, 4, "/resources/textures/Soul.png");
        random = new Random();
        attacks = new ArrayList<Entity>();
    }

    public void tick() {
        soul.tick();

        if (counter.check(20)) {
            attacks.add(new Attack1(game, random.nextInt(600) - 50, -50, 13, 14, 3, "/resources/textures/Fireball.png"));
            attacks.add(new Attack1(game, random.nextInt(600) - 50, -50, 12, 12, 3, "/resources/textures/FriendlinessPellet.png"));
        }

        for (int i = 0; i < attacks.size(); i++) {
            attacks.get(i).tick();
            if (soul.collides(attacks.get(i))) {
                HP -= 1;
            }
            if (attacks.get(i).getX() < -50 || attacks.get(i).getX() > 550 || attacks.get(i).getY() < -50 || attacks.get(i).getY() > 550) {
                attacks.set(i, null);
            }
        }
        attacks.removeAll(Collections.singleton(null));
        counter.tick();
    }

    public void render(Graphics2D g2) {
        dialogueBox.render(g2);
        soul.render(g2);

        for (int i = 0; i < attacks.size(); i++) {
            attacks.get(i).render(g2);
        }

        g2.setColor(Color.YELLOW);
        g2.drawString("HP: " + HP, 230, 400);
    }

    public Counter getCounter() {
        return counter;
    }

    public DialogueBox getDialogueBox() {
        return dialogueBox;
    }

    public Soul getSoul() {
        return soul;
    }
}
