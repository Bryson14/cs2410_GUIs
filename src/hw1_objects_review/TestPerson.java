package hw1_objects_review;

public class TestPerson {

    public static void main(String[] args) {
        MyDate date1 = new MyDate(2019, 5, 26);
        MyDate date2 = new MyDate(2008, 1, 8);
        MyDate date3 = new MyDate(1997, 3, 26);

        Person someDude = new Person("Joe Smo", "1234 Becker St","8015485485", "joe@gmail.com");
        Student a_a_ron = new Student("A-A-ron Bequeth", "6969 lol road", "3854251258", "aaron@yahoo.com", "Junior");
        Employee Thor = new Employee("Thor son of Odin", "Asguard", "n/a", "sendARaven@rainbowbridge.com", "Prince", 100, date1);
        Faculty Hulk = new Faculty("Bruce Banner", "Rio de Janeiro", "7845123455", "strongestavenger@gmail.com", "Gamma Radiation", 15000000, date2, "6pm-8pm","Level 5");
        Staff Stark = new Staff("Tony Stark", "Malibu", "Ask Jarvis", "imironman@stark.com", "R&D", 250000, date3, "Head of Research and Development");

        System.out.println(someDude.toString() + ", Email: " + someDude.getEmail());
        System.out.println(a_a_ron.toString() + ", Class Status : " + a_a_ron.getClassStatus());
        System.out.println(Thor.toString() + ", Email: " + Thor.getEmail());
        System.out.println(Hulk.toString() + ", Office: " + Hulk.getOffice());
        System.out.println(Stark.toString() + ", Phone: " + Stark.getPhoneNumber());
    }
}
