package hw1_objects_review;

public class Employee extends Person {
    private String office;
    private float salary;
    private MyDate dateHired;

    Employee(String name, String address, String phone, String email, String office, float salary, MyDate dateHired) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String toString() {
        return "name: " + super.getName() + ", Class: " + getClass().getName();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    public float getSalary() {
        return salary;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public String getOffice() {
        return office;
    }
}
