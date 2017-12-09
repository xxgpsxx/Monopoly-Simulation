package mypckg;

public class Property extends Space
{
    private String color = "";
    private int cost = 0;
    private int houses = 0;
    private int[] rent = new int[6];
    private int owner = 0;
    public Property() {}
    public Property(String name, String color, int cost, int houses, int[] rent)
    {
        super(name);
        this.color = color;
        this.cost = cost;
        this.houses = houses;
        this.rent = rent;
    }
    public String color() { return color; }
    public int cost() { return cost; }
    public int houses() { return houses; }
    public int[] rent() { return rent; }
    public int owner() { return owner; }
    public void setOwner(int owner) { this.owner = owner; }
    public void setHouses(int x) { houses = x; }
    public String toString() { return super.toString() + "\nCost: " + cost + "\nColor: " + color + "\nHouses: " + houses + "\nOwner: : Player " + owner; }
}
