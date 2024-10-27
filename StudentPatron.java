public class StudentPatron extends Patron {
    public StudentPatron(String name, String address, String phoneNum) {
        super(name, address, phoneNum, "student");
        // in student and employee patron subclasses, their patron type is predefined. no need to declare it when making patrons!
    }
}