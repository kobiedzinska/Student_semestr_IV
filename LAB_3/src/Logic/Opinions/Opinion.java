package Logic.Opinions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static Logic.Opinions.Validation.*;

public class Opinion implements Serializable {
    private static final long serialVersionUID=4220403938614839426L;
    public Opinion(){
        this.date= new Date();
        this.ID=randomID();
    }
    private String iDEmpl;
    private Date date;
    private char kind;
    private short wage;
    private String comment;
    private String ID;

    public String getiDEmpl() {
        return iDEmpl;
    }

    public Date getDate() {
           return date;
    }

    public char getKind() {
        return kind;
    }

    public short getWage() {
        return wage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setiDEmpl(String iDEmpl)
    {
        this.iDEmpl=iDEmpl;
    }

    public void setDate(int day, int month, int year) {
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
    }
    public void setDateFromConsole(Scanner scanner) {
        System.out.println("Give day:");
        int day = scanner.nextInt();
        System.out.println("Give month:");
        int month = scanner.nextInt();
        System.out.println("Give year:");
        int year = scanner.nextInt();

        setDate(day,month,year);

    }
    public String getID()
    {
        return ID;
    }

    public void setKind(char kind) {
        this.kind = kind;
    }

    public void setWage(short wage) {
        this.wage = wage;
    }

    public void setWholeOpinionFromConsole(Opinion opinion, Scanner reader)
    {
        boolean isGood=true;
        do
        {
            System.out.println("Give an ID of employee:");
            opinion.setiDEmpl(reader.nextLine());
            isGood=isIDGood(opinion);
        }while(isGood!=true);

        do
        {
            System.out.println("Give the date:");
            opinion.setDateFromConsole(reader);
            isGood=isDateGood(opinion.getDate());
        }while(isGood!=true);

        do
        {
            System.out.println("Is it a positive or negative opinion? [P/N]:");
            opinion.setKind(reader.next().charAt(0));
            isGood=isCharGood(opinion);
        }while(isGood!=true);

        do
        {
            System.out.println("Give the wage of an opinion: [0,1,2]");
            opinion.setWage(reader.nextShort());
            isGood=isWageGood(opinion);
        }while(isGood!=true);

        System.out.println("Give the comment:");
        Scanner scanner= new Scanner(System.in);
        opinion.setComment(scanner.nextLine());
    }
    private String randomID()
    {
        String ID;
        String characters="ABCDEFPO";
        String numbers="0123456789";
        Random random= new Random();
        StringBuilder sB= new StringBuilder();

        for(int i=0; i<2;i++)
        {
            int a=random.nextInt(characters.length()-1);
            sB.append(characters.charAt(a));
        }
        for(int i=0; i<6; i++)
        {
            int b=random.nextInt(numbers.length()-1);
            sB.append(numbers.charAt(b));
        }
        ID=sB.toString();
        return ID;


    }
    public static ArrayList<Opinion> LookForEmp(ArrayList<Opinion> List, String name)
    {
        ArrayList<Opinion> arrayEmpa=new ArrayList<>();
        for (Opinion opinion: List) {
           if(name.equals(opinion.getiDEmpl())) {
               arrayEmpa.add(opinion);
           }
        }
        return arrayEmpa;
    }
}
