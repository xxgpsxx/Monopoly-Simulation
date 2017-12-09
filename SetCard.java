package mypckg;

public class SetCard extends Card
{
    private int index = 0;
    public SetCard(int index)
    {
        this.index = index;
    }
    public int index() { return index; }
    public String toString() { return "Set Location to: " + index; }
}
