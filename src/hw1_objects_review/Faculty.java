package hw1_objects_review;

public class Faculty extends Employee {
    private String officeHours;
    private String rank;


    Faculty(String name, String address, String phone, String email, String office, float salary, MyDate dateHired, String officeHours, String rank) {
        super(name, address, phone, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String toString() {
        return "name: " + super.getName() + ", Class: " + getClass().getName();
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public String getOfficeHours() {
        return officeHours;
    }

    @Override
    public float getSalary() {
        return super.getSalary();
    }

    @Override
    public MyDate getDateHired() {
        return super.getDateHired();
    }

    @Override
    public String getOffice() {
        return super.getOffice();
    }

    public String getRank() {
        return rank;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
