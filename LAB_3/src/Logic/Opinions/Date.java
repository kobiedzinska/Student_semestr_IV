package Logic.Opinions;

import java.io.Serializable;

public class Date implements Serializable {
    private static final long serialVersionUID=4652544843967491976L;
    private int day;
    private int month;
    private int year;

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
    public String getFormattedDate() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
    public void setMonth(int month)
    {
        this.month=month;
    }
    public void setYear(int year)
    {
        this.year=year;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

}
