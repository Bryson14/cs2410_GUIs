package hw1_objects_review;

public class MyDate {
    private int day;
    private int month;
    private int year;

    MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }
    public void setmonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }
    public void setDay(int day) {
        this.day = day;
    }

}
