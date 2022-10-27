package mvc.subjects.modell;

public class Subject {
    private String teacherName;
    private String subject;
    private String department;
    private int numberOfLesson;

    public Subject(String teacherName, String subject, String department, int numberOfLesson) {
        this.teacherName = teacherName;
        this.subject = subject;
        this.department = department;
        this.numberOfLesson = numberOfLesson;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumberOfLesson() {
        return numberOfLesson;
    }

    public void setNumberOfLesson(int numberOfLesson) {
        this.numberOfLesson = numberOfLesson;
    }

    @Override
    public String toString() {
        return "Tantargy{" +
                "tanarNeve='" + teacherName + '\'' +
                ", tantargy='" + subject + '\'' +
                ", osztaly='" + department + '\'' +
                ", oraszam=" + numberOfLesson +
                '}';
    }
}
