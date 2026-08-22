public class Student {
    private String id;
    private String name;
    private String activity;
    private double hours;
    private int attendance;
    private double averageMark;
    private String riskStatus;

    // Constructor for Main.java (Banele's task - TrackLearn)
    public Student(String name, String activity, double hours) {
        this.name = name;
        this.activity = activity;
        this.hours = hours;
        this.id = "N/A";
        this.attendance = 0;
        this.averageMark = hours; // use hours as mark for now
        this.riskStatus = "Low";
    }

    // Constructor for Siviwe/Phumelele's model
    public Student(String id, String name, int attendance, double averageMark) {
        this.id = id;
        this.name = name;
        this.attendance = attendance;
        this.averageMark = averageMark;
        this.activity = "General";
        this.hours = averageMark;
        this.riskStatus = "Low";
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getActivity() { return activity; }
    public double getHours() { return hours; }
    public int getAttendance() { return attendance; }
    public double getAverageMark() { return averageMark; }
    public String getRiskStatus() { return riskStatus; }
    
    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', activity='" + activity + "', hours=" + hours + 
               ", attendance=" + attendance + ", averageMark=" + averageMark + "}";
    }
}