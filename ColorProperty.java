package mypckg;

public class ColorProperty extends Property
{
    private String color = "";
    private int houses = 0;
    private int[] rent = new int[6];
    private int owner = 0;
    public ColorProperty() {}
    public ColorProperty(String name, String color, int cost, int[] rent)
    {
        super(name, cost, 0);
        this.color = color;
        this.rent = rent;
    }
    public String color() { return color; }
    public int houses() { return houses; }
    public int[] rent() { return rent; }
    public int owner() { return owner; }
    public void setOwner(int owner) { this.owner = owner; }
    public void setHouses(int x) { houses = x; }
    public String toString() { return super.toString() + "\nColor: " + color + "\nHouses: " + houses + "\nOwner: : Player " + owner; }
}
