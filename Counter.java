public class Counter {
    int tally = 0;
    int max = 0;

    public Counter(int max) {
        this.max = max;
    }

    public void tick() {
        tally++;
        if(tally >= max) tally = 0;
    }

    public boolean check(int delay) {
        return tally % delay == 0;
    }
    public void reset() {
        tally = 0;
    }
}
