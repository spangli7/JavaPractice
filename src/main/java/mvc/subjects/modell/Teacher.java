package mvc.subjects.modell;

public class Teacher {
    private String teacher;
    private int teacherSubjects;

    public Teacher(String teacher, int teacherSubjects) {
        this.teacher = teacher;
        this.teacherSubjects = teacherSubjects;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getTeacherSubjects() {
        return teacherSubjects;
    }

    public void setTeacherSubjects(int teacherSubjects) {
        this.teacherSubjects = teacherSubjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher='" + teacher + '\'' +
                ", orai=" + teacherSubjects +
                '}';
    }
}
