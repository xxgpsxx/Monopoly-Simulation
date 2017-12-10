package mypckg;

public class Property extends Space
{
    private int cost = 0;
    private int owner = 0;
    public Property() { }
    public Property(String name, int cost, int owner)
    {
        super(name);
        this.owner = owner;
        this.cost = cost;
    }
    public int cost() { return cost; }
    public int owner() { return owner; }
    public String toString() { return super.toString() + "\nCost: " + cost + "\nOwner: " + owner; }
}
