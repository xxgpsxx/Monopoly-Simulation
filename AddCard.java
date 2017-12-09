package mypckg;

public class AddCard extends Card
{
    private int spaces = 0;
    public AddCard(int spaces)
    {
        this.spaces = spaces;
    }
    public int spaces() { return spaces; }
    public String toString() { return "Add Spaces: " + spaces; }
}
