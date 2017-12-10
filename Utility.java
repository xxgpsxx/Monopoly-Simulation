package mypckg;

public class Utility extends Property
{
    private int cost = 150;
    public Utility(String name) { super(name, 150, 0); }
    public int cost() { return cost; }
    public int rent(int roll, int owned)
    {
        if(owned == 1)
            return roll * 4;
        else
            return roll * 10;
    }
    public String toString() { return super.toString() + " (Utility)"; }

}
