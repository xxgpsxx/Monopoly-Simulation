package mypckg;

public class PropertyMoney extends Card
{
    private int house = 0;
    private int hotel = 0;
    public PropertyMoney(int house, int hotel)
    {
        this.house = house;
        this.hotel = hotel;
    }
    public int house() { return house; }
    public int hotel() { return hotel; }
}
