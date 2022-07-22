package elections;

import common.PersonName;
import common.GeneralFileReader;
import common.GeneralFileWriter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ElectionsMain {

    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/elections/szavazatok-1.txt");

        List<String> inputData = reader.readLines();
        Scanner sc = new Scanner(System.in);

        // 1.task
        ElectionsManager electionsManager = new ElectionsManager(inputData);

        // 2.task
        int allStarting = electionsManager.getAllStarting();
        System.out.println("\n2.task \nA helyhatósági választásokon " + allStarting + " kpéviselőjelölt indult");

        // 3.task
        System.out.println("\n3.task \nAdjon meg egy nevet ");
        String fullName = sc.nextLine();
        PersonName name = new PersonName(fullName);

        int allVotes = electionsManager.getAllVotesOfPerson(name);

        System.out.println((allVotes==0) ? "Ilyen nevű képviselőjelölt nem szerepel a nyilvántartásban!"
                : fullName + " összesen " + allVotes + " szavazatot kapott ");

        // 4.task
        int allVote = electionsManager.getAllVotes();
        double all = (allVote / 12345.0) * 100;

        System.out.print("\n4.task \nA választáson " + allVote + " állampolgár, a jogosultak " );
        System.out.printf("%.2f",all );
        System.out.print("%. vett részt");
        System.out.println();

        // 5.task
        System.out.println("\n5.task");
        Map<PartiesType, Integer> allParts = electionsManager.getAllPartVotes();

        for (PartiesType part : allParts.keySet()) {
            System.out.print( part + " ");
            System.out.printf("%.2f ",(allParts.get(part) / 12345.0) *100);
            System.out.println();
        }

        // 6.task
        int winners = electionsManager.getWinner();
        System.out.println("\n6.task \nA legtöbb szavazatot kapott jelölt(ek) ");

        for(VoteData vote : electionsManager.voteList) {
            if(vote.getVote() == winners){
                System.out.println(vote.getPersonName() + " " +vote.getPartiesType());
            }
        }

        // 7.task
        Map<Integer,VoteData> winner = electionsManager.getAllWinnerOfDistrict();
        GeneralFileWriter writer = new GeneralFileWriter("src/main/resources/elections/fuggetlen-1.txt");

        for (int person : winner.keySet()) {
            writer.writeIntoFile(
                    person
                    + " " + winner.get(person).getPersonName()
                    + " " + winner.get(person).getPartiesType() + " \n");
        }
        System.out.println("\n7.task \nA fajl elkeszult");
    }
}
