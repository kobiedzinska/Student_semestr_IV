package UI;

import java.io.IOException;
import java.util.Scanner;
import static UI.Choice.DecisionMaking;
import static UI.Choice.WhatsNext;

public class User {
    public static void Start() throws IOException, ClassNotFoundException {
        System.out.println("Hello, what do you want to do today?\nYou can:");
        System.out.println("A. Add a new opinion");
        System.out.println("B. Remove an opinion");
        System.out.println("C. Check trends of the employee");
        System.out.println("D. Close the app");
        System.out.println("E. Show the opinions");

        Scanner scanner= new Scanner(System.in);
        char decision = scanner.next().charAt(0);
        System.out.println(decision);
        DecisionMaking(decision);
        WhatsNext();
    }
}
