package Logic.Opinions;

public class Validation {
    public static boolean isDateGood(Date date) {
        int year1 = date.getYear();
        int month1 = date.getMonth();
        int day1 = date.getDay();
        if (year1 < 0 || year1 > 2024) {
            System.out.println("Wrong year.");
            return false;
        } else if (month1 <= 0 || month1 > 12) {
            System.out.println("Wrong month.");
            return false;
        }
        switch (month1) {
            case 2: {
                if (year1 % 4 == 0) {
                    if (day1 <= 0 || day1 > 29) {
                        System.out.println("Wrong day.");
                        return false;
                    }
                }
                else
                {
                    if(day1<=0 || day1>28)
                    {
                        System.out.println("Wrong day.");
                        return false;
                    }
                }
            break;
            }
            case 1,3,5,7,8,10,12:
            {
                if(day1<=0 || day1>31)
                {
                    System.out.println("Wrong day.");
                    return false;
                }
                break;
            }
            case 4,6,9,11:
            {
                if(day1<=0 || day1>30)
                {
                    System.out.println("Wrong day.");
                    return false;
                }
                break;
            }
        }
        System.out.println("Date is good");
        return true;
    }
    public static boolean isCharGood(Opinion opinion)
    {
        if(opinion.getKind()!='P'&& opinion.getKind()!='p' && opinion.getKind()!='N'&& opinion.getKind()!='n')
        {
            System.out.println("Wrong kind.");
            return false;
        }
        System.out.println("Good kind.");
        return true;
    }
    public static boolean isWageGood(Opinion opinion)
    {
        if(opinion.getWage()!=0 && opinion.getWage()!=1 && opinion.getWage()!=2)
        {
            System.out.println("Wrong wage!");
            return false;
        }
        System.out.println("Good wage");
        return true;
    }
    public static boolean isIDGood(Opinion opinion)
    {
        if(opinion.getiDEmpl().length()>8)
        {
            return false;
        }
        return true;
    }

}

