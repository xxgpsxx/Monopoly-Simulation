package mypckg;

public class JailCard extends Card
{
    private Boolean jail = false;

    public JailCard(Boolean jail)
    {
        this.jail = jail;
    }
    public Boolean jail() { return jail; }
    public String toString() { return "Jail: " + jail; }
}
