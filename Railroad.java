package mypckg;

public class Railroad extends Property {
    private int cost = 200;

    public Railroad(String name) { super(name, 200, 0); }
    public int rent(int owned) { return 25 * owned; }
    public int cost() { return cost; }
    public String toString() { return super.toString() + " (Railroad)"; }
}
