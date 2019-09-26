package hw1_objects_review;

public class Staff extends Employee {
    private String title;

    Staff(String name, String address, String phone, String email, String office, float salary, MyDate dateHired, String title) {
        super(name, address, phone, email, office, salary, dateHired);
        this.title = title;
    }

    public String toString() {
        return "name: " + super.getName() + ", Class: " + getClass().getName();
    }

    @Override
    public String getOffice() {
        return super.getOffice();
    }

    @Override
    public MyDate getDateHired() {
        return super.getDateHired();
    }

    @Override
    public float getSalary() {
        return super.getSalary();
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

    public String getTitle() {
        return title;
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
