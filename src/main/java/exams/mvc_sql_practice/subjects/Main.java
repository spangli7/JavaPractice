package exams.mvc_sql_practice.subjects;



import exams.mvc_sql_practice.subjects.controller.SubjectManager;
import exams.mvc_sql_practice.subjects.modell.Subject;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SubjectManager manager = new SubjectManager();
        Scanner sc = new Scanner(System.in);

        // 1.Task
        List<Subject> timetable = manager.getAllTimetable();
        System.out.println("\nOsszesen " + timetable.size() + " db orarend talalhato" );

        // 2.Task
        int allNumberOfHoursPerWeek = manager.getAllNumberOfHoursPerWeek();
        System.out.println("\nHetente osszesen " + allNumberOfHoursPerWeek + " db ora van");

        // 3.Task
        System.out.println("\nAdjon meg egy tanar nevet (Albatrosz Aladin)");
        String teacher = sc.nextLine();
        int teacherLessons = manager.getTeacherLessons(teacher);
        System.out.println( teacher + "nak hetente " + teacherLessons + "oraja van");

        // 4.
        List<String> teachers = manager.getAllHeadTeachers();
        System.out.println("\n osztalyfonokok " + teachers.toString());

        // 5.Task
        System.out.println("\nAdjon meg egy ostályt es egy tantargyat (9.a, matematika)");
        boolean breakDown = manager.getGroup(sc.next(), sc.next());
        System.out.println( breakDown ? "csoportbontasban tanuljak " : " nem cssoportbontasban tanuljak ");


        // 6.Task
        List<String> allTeachers = manager.getNumberOfTeachers();
        System.out.println("\nosszesen " + allTeachers + " tanar van");

    }
}
