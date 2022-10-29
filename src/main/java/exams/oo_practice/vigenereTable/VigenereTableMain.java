package exams.oo_practice.vigenereTable;

import common.file.GeneralFileReader;
import common.file.GeneralFileWriter;

import java.util.List;
import java.util.Scanner;

public class VigenereTableMain {
    public static void main(String[] args) {

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/vigenere_table/Vtabla.dat");

        Scanner sc = new Scanner(System.in);

        List<String> inputData = reader.readLines();

        VigenereTableManager manager = new VigenereTableManager(inputData);

        // 1.task
        System.out.println("\n1.task \nAdjon meg egy szöveget (Ez a próba szöveg, amit kódolunk!)");
        String sentence = sc.nextLine();

        // 2.task
        System.out.println("\n2.task \nAz átalakítás megtörtént");

        // 3.task
        System.out.println("\n3.task");
        String newSentence = manager.getRepairText(sentence);
        System.out.println(newSentence);


        // 4.task
        System.out.println("\n4.task \nAdjon meg egy kulcsszót (auto)");
        manager.repairNewWord(sc.nextLine());


        // 5.task
        System.out.println("\n5.task");
        String keySentence = manager.keyWordRepeat(newSentence);
        System.out.println(keySentence);

        // 6.task
        System.out.println("\n6.task");
        manager.vigeneTable(newSentence,keySentence);

        // 7.task
        String newCode = manager.getNewCode();
        GeneralFileWriter writer  = new GeneralFileWriter("src/main/resources/exams/oo_practice/vigenere_table/kodolt.dat");
        writer.writeIntoFile(newCode);
        System.out.println("\n7.task \nA fájl elkészült \nAz uj szöveg " + newCode);


    }
}
