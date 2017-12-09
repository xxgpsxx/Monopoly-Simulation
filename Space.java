package mypckg;

public class Space
{
    private String name = "";
    public Space() { }
    public Space(String name)
    {
        this.name = name;
    }
    public String name() { return name; }
    public String toString() { return "Name: " + name;}
}
