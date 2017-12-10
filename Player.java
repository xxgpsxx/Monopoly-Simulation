package mypckg;
import java.util.ArrayList;
public class Player
{
    private int number = 0;
    private int space = 0;
    private int money = 1500;
    private ArrayList <Property> properties = new ArrayList <Property>();
    private int jail = 0;
    private Boolean freeJail = false;
    private Boolean bankrupt = false;
    public Player(int number)
    {
        this.number = number;
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
    public Boolean freeJail() { return freeJail; }
    public void setFreeJail(Boolean freeJail) { this.freeJail = freeJail; }
    public int jail() { return jail; }
    public int incJail(int x) { jail += x; return jail; }
    public int number() { return number; }
    public int space() { return space; }
    public int money() { return money; }
    public ArrayList <Property> properties() { return properties; }
    public void toJail() { jail = 1; }
    public void exitJail() { jail = 0; }
    public Property addProperty(Property property)
    {
        properties.add(property);
        return property;
    }
    public Space subProperty(String name)
    {
        Space temp = new Space();
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
