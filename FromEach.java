package mypckg;

public class FromEach extends Card
{
    private int amount = 0;
    public FromEach(int amount) { this.amount = amount; }
    public int amount() { return amount; }
    public String toString() { return "Receive From Others: " + amount; }
}
