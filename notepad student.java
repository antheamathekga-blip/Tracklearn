public class Student {
    private String name;
    private String activity;
    private double hours;

    public Student(String name, String activity, double hours) {
        this.name = name;
        this.activity = activity;
        this.hours = hours;
    }

    public String toString() {
        return "Student: " + name + " | Activity: " + activity + " | Hours: " + hours;
    }
}
