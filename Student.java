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

    // Getters needed for saving to file
    public String getName() { 
        return name; 
    }
    
    public String getActivity() { 
        return activity; 
    }
    
    public double getHours() { 
        return hours; 
    }
}
