package mypckg;

public class Railroad extends Property
{
    public Railroad(String name, String color, int cost, int houses, int[] rent)
    {
        super(name, color, cost, houses, rent);
    }
    public void setHouses(int x) { super.setHouses(super.houses()); }
}
