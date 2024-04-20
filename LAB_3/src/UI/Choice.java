package UI;

import Logic.Opinions.Opinion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static Logic.Deserialization.readOpinionsFromFile;
import static Logic.Opinions.Opinion.LookForEmp;
import static Logic.Serialization.writeOpinionsToFile;

public class Choice {
    public static void choiceA() throws IOException, ClassNotFoundException {
        System.out.println("You chose option A.");
        Opinion novaOpinion= new Opinion();
        ArrayList<Opinion> readopinionsList=null;
        //readopinionsList=readOpinionsFromFile();
        
        Scanner reader=new Scanner(System.in);
        novaOpinion.setWholeOpinionFromConsole(novaOpinion,reader);
                
        readopinionsList.add(novaOpinion);
       // writeOpinionsToFile(readopinionsList);
     
    }
    public static void choiceB() throws IOException, ClassNotFoundException
    {
        System.out.println("You chose option B.");
        ArrayList<Opinion> readopinionsList=null;
        readopinionsList=readOpinionsFromFile();
        System.out.println("Give the ID of an opinion:");
        Scanner scanner= new Scanner(System.in);
        String LookFor=scanner.nextLine();

        for (Opinion element: readopinionsList) {
            if(LookFor.equals(element.getID()))
            {
                readopinionsList.remove(element);
                System.out.println("You removed an opinion.");
            }
        }
        writeOpinionsToFile(readopinionsList);
    }
    public static void choiceC() throws IOException, ClassNotFoundException
    {
        System.out.println("You chose option C.");
        ArrayList<Opinion> readopinionsList=null;
        readopinionsList=readOpinionsFromFile();
        System.out.println("Give the ID of Employee, which you want to check,:");
        Scanner scanner= new Scanner(System.in);
        String lookForName=scanner.nextLine();
        System.out.println("Give the month you want to check:");
        int month=scanner.nextInt();
        System.out.println("Give the year you want to check:");
        int year=scanner.nextInt();
        float sum=0;
        int licznik=0;

        ArrayList<Opinion> employeeList=LookForEmp(readopinionsList,lookForName);
        for (Opinion opinion:employeeList) {
            if(month==opinion.getDate().getMonth() && year==opinion.getDate().getYear())
            {
                if(opinion.getKind()=='p' || opinion.getKind()=='P')
                {
                    sum+=opinion.getWage();
                    licznik++;
                }
                if(opinion.getKind()=='n' || opinion.getKind()=='N')
                {
                    sum-= opinion.getWage();
                    licznik++;
                }

            }
        }
        float medium;
        medium=sum/licznik;
        System.out.println("Employee's ID:"+lookForName);
        System.out.println("Month:"+month+" Year:"+year);
        System.out.println("Average grade for the employee:"+medium);

    }
    public static void choiceD()
    {
        System.out.println("You chose option D. Bye bye");
        System.exit(0);
    }
    public static void choiceE() throws IOException, ClassNotFoundException {
        System.out.println("You chose option E.");
        ArrayList<Opinion> readopinionsList=null;
        readopinionsList=readOpinionsFromFile();

        Scanner scanner= new Scanner(System.in);
        boolean isGood=true;
        do
        {
            for (Opinion element: readopinionsList) {
                {
                    System.out.println("\nOpinion's ID:"+element.getID());
                    System.out.println("Employee's ID:"+element.getiDEmpl());
                    System.out.println("Date:"+element.getDate().getFormattedDate());
                    System.out.println("Positive/Negative:"+element.getKind());
                    System.out.println("Wage:"+element.getWage());
                    System.out.println("Comment: "+element.getComment());
                    System.out.println("");

                }
            }
        }while(isGood!=true);

    }

    public static void DecisionMaking(char decision) throws IOException, ClassNotFoundException {
        if (decision=='A' || decision=='a')
        {
            choiceA();
        }
        if (decision=='B' || decision=='b')
        {
            choiceB();
        }
        if (decision=='C' || decision=='c')
        {
            choiceC();
        }
        if (decision=='D' || decision=='d')
        {
           choiceD();
        }
        if (decision=='E' || decision=='e')
        {
            choiceE();
        }

    }
    public static void WhatsNext() throws IOException, ClassNotFoundException {
        System.out.println("\nNow what's next?");

        {
            System.out.println("A.Add a new opinion");
            System.out.println("B.Remove an opinion");
            System.out.println("C.Check the trends");
            System.out.println("D.Close the app");
            System.out.println("E.Show the opinions");
            Scanner scanner= new Scanner(System.in);
            char decision = scanner.next().charAt(0);
            System.out.println(decision);
            DecisionMaking(decision);
            
        }
    WhatsNext();

    }
}
