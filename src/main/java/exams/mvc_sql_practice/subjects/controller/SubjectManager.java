package exams.mvc_sql_practice.subjects.controller;

import exams.mvc_sql_practice.subjects.modell.Subject;
import exams.mvc_sql_practice.subjects.modell.Teacher;
import exams.mvc_sql_practice.subjects.sql.GetAllSubject;
import exams.mvc_sql_practice.subjects.sql.GetTeacherNumberOfClass;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectManager {

    GetAllSubject getAllSubject = new GetAllSubject();
    GetTeacherNumberOfClass getTeacherNumberOfClass = new GetTeacherNumberOfClass();

    public List<Subject> getAllTimetable(){
        return getAllSubject.getAllSubject();
    }

    public int getAllNumberOfHoursPerWeek(){
        List<Subject> subjects = getAllSubject.getAllSubject();

        return subjects.stream()
                .mapToInt(Subject::getNumberOfLesson)
                .sum();
    }

    public int getTeacherLessons( String teacherName ){
        List<Teacher> teacherNumberOfClass = getTeacherNumberOfClass.getTeacherNumberOfClass(teacherName);

        return teacherNumberOfClass.stream()
                .mapToInt(Teacher::getTeacherSubjects)
                .sum();
    }

    public List<String> getAllHeadTeachers(){
        List<Subject> subjects = getAllSubject.getAllSubject();

        return subjects.stream()
            .filter(m ->m.getSubject().equals("osztalyfonoki"))
            .map(Subject::getTeacherName)
            .collect(Collectors.toList());
    }

    public boolean getGroup(String department, String searchedSubject){
        List<Subject> subjects = getAllSubject.getAllSubject();
        int sum = 0;

        for (Subject subject : subjects) {
            if(subject.getDepartment().equals(department) && subject.getSubject().equals(searchedSubject)){
                sum++;
                if(sum == 2){
                    return true;
                }
            }
        }
        return false;
    }


    public List<String> getNumberOfTeachers(){
        List<Subject> subjects = getAllSubject.getAllSubject();

        return  subjects.stream()
                .distinct()
                .map(Subject::getTeacherName)
                .collect(Collectors.toList());
    }
}
