package mypckg;
import java.util.ArrayList;
public class Player
{
    private int number = 0;
    private int space = 0;
    private int money = 0;
    private ArrayList <Property> properties = new ArrayList<Property>();
    private Boolean jail = false;
    private Boolean bankrupt = false;
    public Player(int number, int money)
    {
        this.number = number;
        this.money = money;
    }
    public int addMoney(int x)
    {
        money += x;
        return money;
    }
    public int subMoney(int x)
    {
        money -= x;
        return money;
    }
    public int setSpace(int index)
    {
        space = index % 40;
        return space;
    }
    public int addSpace(int amount)
    {
        space = (space + amount) % 40;
        return space;
    }
    public int number() { return number; }
    public void toJail() { jail = true; }
    public void exitJail() { jail = false; }
    public Property addProperty(Property property)
    {
        properties.add(property);
        return property;
    }
    public Property subProperty(String name)
    {
        Property temp = new Property();
        for(int i = 0; i < properties.size(); i++)
        {
            if(properties.get(i).name() == name)
            {
                temp = properties.remove(i);
                return temp;
            }
        }
        return temp;
    }
}
