package machine;
import java.util.Scanner;


public class CoffeeMachine {
    public static int cash = 550, waterTank = 400, milkTank = 540, beansTank = 120, cupsTank = 9;
    public static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {


        while (true) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");

            switch (sc.nextLine()) {
                case ("buy"):
                    chooseDialog();
                    break;
                case ("fill"):
                    fill();
                    break;
                case ("take"):
                    System.out.printf("I gave you $%d\n", cash);
                    cash = 0;
                    break;
                case ("remaining"):
                    printState();
                    break;
                case ("exit"):
                    System.exit (0);
                    break;

            }
            System.out.println();
        }

    }

    public static void  printState() {
            System.out.println("The coffee machine has:");
            System.out.printf("%d ml of water\n", waterTank);
            System.out.printf("%d ml of milk\n", milkTank);
            System.out.printf("%d g of coffee beans\n", beansTank);
            System.out.printf("%d disposable cups\n", cupsTank);
            System.out.printf("$%d of money\n", cash);
    }

    public static void chooseDialog() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (sc.nextLine()) {
            case ("1"):
                buy(250,0,16,4);
                break;
            case ("2"):
                buy(350, 75, 20, 7);
                break;
            case ("3"):
                buy(200, 100, 12, 6);
                break;
            case ("back"):
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        waterTank += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkTank += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beansTank += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cupsTank += sc.nextInt();
    }

    public static void buy(int water, int milk, int beans, int price) {

        if (waterTank - water < 0) {
            System.out.println("Sorry, not enough water!");
            return;
        } else if (milkTank - milk < 0) {
            System.out.println("Sorry, not enough milk!");
            return;
        } else if (beansTank - beans < 0) {
            System.out.println("Sorry, not enough coffee!");
            return;
        } else if (cupsTank == 0) {
            System.out.println("Sorry, not enough cups!");
            return;
        }

        waterTank -= water;
        milkTank -= milk;
        beansTank -= beans;
        cupsTank--;
        cash += price;
        System.out.println("I have enough resources, making you a coffee!");


    }


}