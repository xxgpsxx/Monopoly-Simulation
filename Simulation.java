import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation
{
    ArrayList <Space> board = new ArrayList <Space>();
    ArrayList <Player> order = new ArrayList <Player>();
    ArrayList <Card> community = new ArrayList <Card>();
    ArrayList <Card> chance = new ArrayList <Card>();
    Scanner reader = new Scanner(System.in);
    public Simulation()
    {
        boardSetUp();
        game();
    }
    public void boardSetUp()
    {
        board.add(new Transaction("Go", 200));
        board.add(new ColorProperty("Mediteranean Avenue", "Brown", 60, new int[]{2, 10, 30 , 90, 160, 250}));
        board.add(new Community("Community Chest"));
        board.add(new ColorProperty("Baltic Avenue", "Brown", 60, new int[]{4, 20, 60, 180, 320, 450}));
        board.add(new Transaction("Income Tax", -200));
        board.add(new Railroad("Reading Railroad"));
        board.add(new ColorProperty("Oriental Avenue", "Light Blue", 100, new int[]{6, 30, 90, 270, 400, 550}));
        board.add(new Chance("Chance"));
        board.add(new ColorProperty("Vermont Avenue", "Light Blue", 100, new int[]{6, 30, 90, 270, 400, 550}));
        board.add(new ColorProperty("Connecticut Avenue", "Light Blue", 120, new int[]{8, 40, 100, 300, 450, 600}));
        board.add(new Jail("Jail"));
        board.add(new ColorProperty("St. Charles Place", "Pink", 140, new int[]{10, 50, 150, 450, 625, 750}));
        board.add(new Utility("Electric Company"));
        board.add(new ColorProperty("States Avenue", "Pink", 140, new int[]{10, 50, 150, 450, 625, 750}));
        board.add(new ColorProperty("Virginia Avenue", "Pink", 160, new int[]{12, 60, 180, 500, 700, 1000}));
        board.add(new Railroad(("Pennsylvania Railroad")));
        board.add(new ColorProperty("St. James Place", "Orange", 180, new int[]{140, 70, 200, 550, 750, 950}));
        board.add(new Community("Community Chest"));
        board.add(new ColorProperty("Tennessee Avenue", "Orange", 180, new int[]{14, 70, 200, 550, 750, 950}));
        board.add(new ColorProperty("New York Avenue", "Orange", 200, new int[]{16, 80, 220, 600, 800, 1000}));
        board.add(new Space("Free Parking"));
        board.add(new ColorProperty("Kentucky Avenue", "Red", 220, new int[]{18, 90, 250, 700, 875, 1050}));
        board.add(new Chance("Chance"));
        board.add(new ColorProperty("Indiana Avenue", "Red", 220, new int[]{18, 90, 250, 700, 875, 1050}));
        board.add(new ColorProperty("Illinois Avenue", "Red", 240, new int[]{20, 100, 300, 750, 925, 1100}));
        board.add(new Railroad("B. and O. Railroad"));
        board.add(new ColorProperty("Atlantic Avenue", "Yellow", 260, new int[]{22, 110, 330, 800, 975, 1150}));
        board.add(new ColorProperty("Ventnor Avenue", "Yellow", 260, new int[]{22, 110, 330, 800, 875, 1150}));
        board.add(new ColorProperty("Marvin Gardnes", "Yellow", 280, new int[]{24, 120, 360, 1025, 1200}));
        board.add(new GoToJail("Go To Jail"));
        board.add(new ColorProperty("Pacific Avenue", "Green", 300, new int[]{26, 130, 390, 900, 1100, 1275}));
        board.add(new ColorProperty("North Carolina Avenue", "Green", 300, new int[]{26, 390, 900, 1100, 1275}));
        board.add(new Community("Community Chest"));
        board.add(new ColorProperty("Pennsylvania Avenue", "Green", 320, new int[]{28, 150, 450, 1000, 1200, 1400}));
        board.add(new Railroad("Short Line"));
        board.add(new Chance("Chance"));
        board.add(new ColorProperty("Park Place", "Blue", 350, new int[]{35, 175, 500, 1100, 1300, 1500}));
        board.add(new Transaction("Luxury Tax",-100));
        board.add(new ColorProperty("Boardwalk", "Blue", 400, new int[]{50, 200, 600, 1400, 1700, 2000}));

        chance.add(new SetUtility());
        chance.add(new SetCard(5));
        chance.add(new SetCard(24));
        chance.add(new SetCard(11));
        chance.add(new AddCard(-3));
        chance.add(new SetRailRoad());
        chance.add(new JailCard(true));
        chance.add(new SetCard(-2));
        chance.add(new SetCard(39));
        chance.add(new SetCard(0));
        chance.add(new PropertyMoney(25, 100));
        chance.add(new MoneyCard(50));
        chance.add(new MoneyCard(15));
        chance.add(new MoneyCard(150));
        chance.add(new PayEach(50));
        chance.add(new JailCard(false));

        shuffle(chance);

        community.add(new JailCard(false));
        community.add(new MoneyCard(25));
        community.add(new JailCard(true));
        community.add(new MoneyCard(-100));
        community.add(new SetCard(0));
        community.add(new MoneyCard(20));
        community.add(new MoneyCard(10));
        community.add(new PropertyMoney(40, 115));
        community.add(new MoneyCard(10));
        community.add(new MoneyCard(100));
        community.add(new MoneyCard(50));
        community.add(new MoneyCard(200));
        community.add(new FromEach(10));
        community.add(new MoneyCard(100));
        community.add(new MoneyCard(-50));
        community.add(new MoneyCard(-50));

        shuffle(community);

        System.out.println("Number of Players: ");
        int players = reader.nextInt();
        for(int i = 0; i < players; i++)
            order.add(new Player(i + 1));

        shuffleTurns(order);

    }
    public void game()
    {
        while(true)
        {
            Player player = order.get(0);
            int number = player.number();
            String name = "Player " + number;

            if(player.jail() > 2)
            {
                System.out.println(name + " has paid 50 Dollars and has been let out of Jail!");
                player.subMoney(50);
                rollDice(player);
            }
            else if(player.jail() > 0) {
				inJail(player);
                player.incJail(1);
			}
            else
                rollDice(player);
            order.add(order.remove(0));
        }
    }
    public void rollDice(Player player)
    {
        int number = player.number();
        char option = 'a';
        int[] roll = roll();
        String name = "Player " + number;
        System.out.println(name);
        System.out.println("Press Enter to Role Dice");
        String temp = reader.nextLine();
        System.out.println(name + " Rolled a " + roll[0] + " and a " + roll[1]);
       	rolled(player, roll[0], roll[1]);
    }
    public void rolled(Player player, int x, int y)
    {
		int previous = player.space();
		player.addSpace(x + y);
		String name = "Player " + player.number();
		if((previous + x + y) % 39 != previous + x + y) {
			System.out.println(name + " has received 200 Dollars for passing Go!");
			player.addMoney(200);

			System.out.println(name + " now has " + player.money() + " Dollars!");
		}
        System.out.println(name + " landed on " + spaceName(player) + "!");
        if(space(player) instanceof Property && property(player).owner() == 0)
            landedProperty(player);
        else if(space(player) instanceof Property)
            System.out.println("You cannot buy that property");
        else if(space(player) instanceof Chance)
            landedChance(player);
        else if(space(player) instanceof Community)
            landedCommunity(player);
        else if(space(player) instanceof Transaction)
            landedTransaction(player);
        else if(space(player) instanceof GoToJail) {
			System.out.println(name + " has been sent to jail!");
			player.setSpace(10);
			player.toJail();
		}
	}
    public void inJail(Player player)
    {
		String name = "Player " + player.number();
		System.out.println(name + " is currently in jail!");
		System.out.println("Press Enter to roll for doubles");
		String temp = reader.nextLine();
		int[] roll = roll();
		System.out.println(name + " rolled a " + roll[0] + " and a " + roll[1] + "!");
		if(roll[0] == roll[1]) {
			System.out.println(name + " has exited jail!");
			player.exitJail();
			rolled(player, roll[0], roll[1]);
		}
		else
			System.out.println(name + " is staying in jail.");
	}
    public void landedProperty(Player player)
    {
        char option = 'a';
        String name = "Player " + player.number();
        System.out.println(((Property)(space(player))).cost());
        System.out.println("Would " + name + " like to buy " + spaceName(player) + " for " + ((Property) (space(player))).cost() + " Dollars?");
        while (true) {
            try {
                option = reader.nextLine().toLowerCase().charAt(0);
            }
            catch (Exception e) {
                System.out.println("Please enter 'y' or 'no'");
            }

            if (option == 'y' || option == 'n')
                break;
            else
                System.out.println("Please enter either 'y' or 'n'!");
        }
        if (option == 'y') {
            player.subMoney(property(player).cost());
            System.out.println(name + " bought " + space(player).name() + " for " + property(player).cost() + " Dollars");
            System.out.println(name + " has " + player.money() + " Dollars left");
        }
    }
    public void landedCommunity(Player player)
    {
        String name = "Player " + player.number();
        Card card = chance.get(0);
        chance.add(chance.remove(0));
        System.out.println(card);
        if(card instanceof MoneyCard)
        {
            int amount = ((MoneyCard)(card)).amount();
            if(amount < 0) {
                player.subMoney(amount);
                System.out.println(name + " lost " + amount + " Dollars and now has " + player.money() + " Dollars");
            }
            else {
                player.addMoney(amount);
                System.out.println(name + " gained " + amount + " Dollars and now has " + player.money() + " Dollars");
            }

        }
        else if(card instanceof JailCard)
        {
            if(((JailCard)(card)).jail()) {
				System.out.println(name + " has been moved to jail!");
                player.toJail();
			}
            else {
				System.out.println(name + " has received a get out of jail card!");
                player.setFreeJail(true);
			}
        }
    }
    public void landedChance(Player player)
    {
        String name = "Player " + player.number();
        Card card = chance.get(0);
        chance.add(chance.remove(0));
        System.out.println(card);
        if(card instanceof MoneyCard)
        {
            int amount = ((MoneyCard)(card)).amount();
            player.addMoney(amount);
            if(amount > 0)
                System.out.println(name + " gained " + amount + " Dollars and now has "  + player.money() + " Dollars");
            else
                System.out.println(name + " lost " + Math.abs(amount) + " Dollars and now has " + player.money() + " Dollars");
        }
        else if(card instanceof SetCard)
        {
            int index = ((SetCard)(card)).index();
            Space space = board.get(index);
            player.setSpace(index);
            System.out.println(name + " has been moved to " + space.name());
            if(space instanceof Property)
                landedProperty(player);
        }
        else if(card instanceof AddCard)
        {
            int amount = ((AddCard)(card)).spaces();
            player.addSpace(amount);
            Space space = board.get(player.space());
            System.out.println(name + " has been moved back " + amount + " spaces");
            System.out.println(name + " has landed on " + space.name());
            if(space instanceof Property)
                landedProperty(player);
        }
        else if(card instanceof JailCard)
        {
            if(((JailCard)(card)).jail())
                player.toJail();
            else
                player.setFreeJail(true);
        }
    }
    public void landedTransaction(Player player)
    {
        int amount = ((Transaction)(space(player))).amount();
        String name = "Player " + player.number();
        player.subMoney(Math.abs(amount));
        System.out.println(name + " has paid " + Math.abs(amount) + " Dollars because of " + space(player).name());
        System.out.println(name + " has " + player.money() + " Dollars left");
    }
    public Property property(Player player) { return (Property)(space(player)); }
    public Space space(Player player) { return board.get(player.space()); }
    public String spaceName(Player player) { return board.get(player.space()).name(); }
    public int[] roll(){ return new int[]{randint(1,6), randint(1,6)}; }
    public void shuffle(ArrayList <Card> list)
    {
        for(int i = 0; i < 1000; i++)
            list.add(list.remove(randint(0, list.size())));
    }
    public void shuffleTurns(ArrayList <Player> list)
    {
        for(int i = 0; i < 1000; i++)
            list.add(list.remove(randint(0, list.size())));
    }
    public void print(ArrayList <Card> list)
    {
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
    public int randint(int min, int max) { return (int)(Math.random() * (max - min)) + min; }
    public static void main(String args[])
    {
        Simulation app = new Simulation();
    }
}
