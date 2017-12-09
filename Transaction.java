package mypckg;

public class Transaction extends Space
{
    private int amount = 0;
    public Transaction(String name, int amount)
    {
        super(name);
        this.amount = amount;
    }
    public int amount() { return amount; }
    public String toString() { return super.toString() + "\nAmount: " + amount; }
}
