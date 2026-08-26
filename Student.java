public class Student {
    public String name;
    public String course;
    public int progress;
    public int score;

    public Student(String name, String course, int progress, int score) {
        this.name = name; this.course = course; this.progress = progress; this.score = score;
    }

    public boolean isBehind() {
        return progress < 50;
    }
}
