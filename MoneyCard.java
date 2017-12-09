package mypckg;

public class MoneyCard extends Card
{
    private int amount = 0;
    public MoneyCard(int amount)
    {
        this.amount = amount;
    }
    public int amount() { return amount; }
    public String toString() { return "Amount: " + amount; }
}
