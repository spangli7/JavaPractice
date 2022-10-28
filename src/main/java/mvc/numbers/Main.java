package mvc.numbers;

import mvc.numbers.controller.NumbersManager;
import mvc.numbers.model.Question;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NumbersManager manager = new NumbersManager();
        Scanner sc = new Scanner(System.in);

        // 1.task
        int numberOfQuestion = manager.getNumberOfQuestions();
        System.out.println(numberOfQuestion);

        // 2.task
        Map<Integer,Integer> mathByPoints =  manager.getAllMathQuestions();
        for (Map.Entry<Integer,Integer> point : mathByPoints.entrySet()) {
            System.out.println( point.getKey() + ":" + point.getValue() );
        }

        // 3. Task
        Question maxAnswer = manager.getMaxAnswer();
        Question minAnswer = manager.getMinAnswer();
        System.out.println("Legnagyobb valasz " + maxAnswer.answer +"\nLegkisebb valasz " + minAnswer.answer);

        // 4.task
        List<String> allTopics = manager.getAllTopics();
        System.out.println("Temakorok " + allTopics);

        // 5.task
        System.out.println("Adjon meg egy temakort (matematika)");
        Question question = manager.getRandom(sc.next());
        System.out.println(question.question + "\nAdja meg a valaszt");
        int answer = sc.nextInt();
        System.out.println( (answer == question.answer) ? "helyes valasz " + question.point + " pont "
                : "rossz valasz a helyes valasz " + question.answer );

    }
}
