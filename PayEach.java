package mypckg;

public class PayEach extends Card
{
    private int amount = 0;
    public PayEach(int amount) { this.amount = amount; }
    public int amount() { return amount; }
    public String toString() { return "Pay Each Player: " + amount; }
}
