import java.awt.*;

public class Assets {
    private Game game;

    private Counter counter;

    private int HP = 20;

    private DialogueBox dialogueBox;
    private Soul soul;

    private int seqNum;
    private Sequence currSeq;

    private Sequence1 seq1;
    private Sequence2 seq2;

    public Assets(Game game) {
        this.game = game;

        counter = new Counter(4000);
        dialogueBox = new DialogueBox(game, 150, 150, 200, 200, 14);
        soul = new Soul(game, 242, 242, 16, 16, 4, "/resources/textures/Soul.png");

        seq1 = new Sequence1(game);
        seq2 = new Sequence2(game);

        seqNum = 1;
        currSeq = seq1;
    }

    public void tick() {
        if(seqNum == 1) {
            currSeq = seq1;

            if(counter.tally > 500) {
                if(currSeq.done) {
                    currSeq.spawn = true;
                    currSeq.done = false;
                    counter.reset();
                    seqNum = 2;
                }
                else {
                    currSeq.spawn = false;
                }
            }

        }
        else if(seqNum == 2) {
            currSeq = seq2;

            if(counter.tally > 2000) {
                if(currSeq.done) {
                    currSeq.spawn = true;
                    currSeq.done = false;
                    counter.reset();
                    seqNum = 1;
                }
                else {
                    currSeq.spawn = false;
                }
            }
        }

        soul.tick();
        currSeq.tick();

        counter.tick();
    }

    public void render(Graphics2D g2) {
        dialogueBox.render(g2);
        soul.render(g2);

        currSeq.render(g2);

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

    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
}
