package com.finalexam.vigenereTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VigenereTableManager {

    private final List<Character> punctuationMark = Arrays.asList(',','.',':','!','?',' ');
    static final Map<Character,Character> accent = new HashMap<>();
    Map<Character, Map<Character, Character>> table;
    private String keyWord;
    String newCode;


    public VigenereTableManager(List<String> inputData) {
        this.table = new HashMap<>();
        parseInput(inputData);
    }

    public void parseInput(List<String> inputData) {
        for(String inputDatum : inputData) {
            table.put(inputDatum.charAt(0), new HashMap<>());

            for(int i = 0; i < inputData.get(0).length(); i++){
                char key = inputData.get(0).charAt(i);
                char current = inputDatum.charAt(i);
                table.get(inputDatum.charAt(0)).put(key, current);
            }
        }
    }

    public String getRepairText(String sentence){
        String newSentence = "";

        for (int i = 0; i < sentence.length() ; i++) {
            if(!punctuationMark.contains(sentence.charAt(i))){
                newSentence += repair(sentence.charAt(i));
            }
        }
        return newSentence.toUpperCase();
    }


    public void repairNewWord(String word){
        keyWord = word.toUpperCase();
    }


    public String keyWordRepeat(String newSentence){
        StringBuilder builder = new StringBuilder();

        while (builder.length() <= newSentence.length()) {
            builder.append(keyWord);
        }

        builder.setLength(newSentence.length());
        return builder.toString();
    }



    public void vigeneTable(String newSentence, String keySentence){
        newCode = "";
        for (int i = 0; i < newSentence.length() ; i++) {
            newCode += table.get(newSentence.charAt(i)).get(keySentence.charAt(i));
        }
    }


    public String getNewCode(){
        return newCode;
    }



    public Character repair(char character){
        accent.put('á','a');
        accent.put('é','e');
        accent.put('í','i');
        accent.put('ó','o');
        accent.put('ö','o');
        accent.put('ő','o');
        accent.put('ú','u');
        accent.put('ü','u');
        accent.put('ű','u');
        for (char c :accent.keySet()) {
            if(character == c){
                return accent.get(c);
            }
        }
    return character;
    }


}
