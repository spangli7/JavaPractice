package exams.mvc_sql_practice.numbers.controller;

import exams.mvc_sql_practice.numbers.model.Question;
import exams.mvc_sql_practice.numbers.sql.GetAllQuestion;
import exams.mvc_sql_practice.numbers.sql.GetAllQuizType;

import java.util.*;
import java.util.stream.Collectors;

public class NumbersManager {

    GetAllQuestion question = new GetAllQuestion();
    GetAllQuizType quizType = new GetAllQuizType();


    public int getNumberOfQuestions(){
        return question.getAllQuestions().size();
    }

    public Map<Integer,Integer> getAllMathQuestions(){
        List<Question> allQuestions = question.getAllQuestions();
        Map<Integer,String> quiz = quizType.getAllQuizType();

        int id = 0;
        for (Map.Entry<Integer,String> q : quiz.entrySet()) {
            if(q.getValue().equals("matematika") ){
                id = q.getKey();
                break;
            }
        }

        Map<Integer,Integer> mathByPoints = new HashMap<>();

        for (Question  question : allQuestions) {
            if(question.type == id){
                int count = mathByPoints.computeIfAbsent(question.point,t-> 0);
                mathByPoints.put(question.point,++count);
            }
        }
        return mathByPoints;
    }

    public Question getMaxAnswer(){
        List<Question> allQuestions = question.getAllQuestions();

        return allQuestions.stream()
                .max(Comparator.comparingInt(Question::getAnswer))
                .orElse(null);
    }

    public Question getMinAnswer(){
        List<Question> allQuestions = question.getAllQuestions();

        return allQuestions.stream()
                .min(Comparator.comparingInt(Question::getAnswer))
                .orElse(null);
    }

    public List<String> getAllTopics(){
        Map<Integer,String> quiz = quizType.getAllQuizType();

        return quiz.values().stream().distinct().collect(Collectors.toList());
    }

    public Question getRandom(String topics){
        List<Question> allQuestions = question.getAllQuestions();
        Map<Integer,String> quiz = quizType.getAllQuizType();

        int id = 0;
        for (Map.Entry<Integer,String> q : quiz.entrySet()) {
            if(q.getValue().equals(topics)){
                id = q.getKey();
                break;
            }
        }

        List<Question> questions = new ArrayList<>();

        for (Question quest : allQuestions){
            if(quest.type == id){
                questions.add(quest);
            }
        }

        Random rand = new Random();
        int randomNumber = rand.nextInt(questions.size());

        return questions.get(randomNumber);
    }


}
