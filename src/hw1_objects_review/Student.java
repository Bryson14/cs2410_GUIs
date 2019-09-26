package hw1_objects_review;

public class Student extends Person {

    private String classStatus;

    public Student() {
        super();
        this.classStatus = "Freshman";
    }
    public Student(String classStatus) {
        super();
        this.classStatus = classStatus;
    }
    Student(String name, String address, String phone, String email, String classStatus) {
        super(name, address, phone, email);
        this.classStatus = classStatus;
    }
    @Override
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

    public String getClassStatus() {
        return classStatus;
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

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }
}
