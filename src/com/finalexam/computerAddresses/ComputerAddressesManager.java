package com.finalexam.computerAddresses;

import java.util.*;

public class ComputerAddressesManager {
    public final List<Address> addresses;
    public final List<String> sorting = new ArrayList<>();
    public final Map<Integer,String> sortAddresses = new HashMap<>();

    public ComputerAddressesManager(List<String> rows) {
        this.addresses = new ArrayList<>();
        parseInput(rows);
    }

    public void parseInput(List<String> rows){
        int number = 0;
        for (String row : rows) {
            String[] splitData = row.split(":");

            AddressTypes types = null;

            if(splitData[0].equals("2001") && splitData[1].equals("0db8")){
                types = AddressTypes.DOKUMENTACIOS;
            }
            if(splitData[0].equals("2001") && splitData[1].startsWith("0e")){
                types = AddressTypes.EGYEDI;
            }
            if(splitData[0].startsWith("fc") || splitData[0].startsWith("fd") ){
                types = AddressTypes.HELYI;
            }

            List<String> title = Arrays.asList(splitData[0],splitData[1],splitData[2],splitData[3],
                    splitData[4],splitData[5],splitData[6],splitData[7]);


            Address address = new Address(types,title);

            addresses.add(address);
            sorting.add(row);
            number++;
            sortAddresses.put(number,row);
        }
    }

    public int getAllRows(){
        return addresses.size();
    }

    public String getSmallestAddress(){
        Collections.sort(sorting);
        return sorting.get(0);
    }

    public Map<AddressTypes, Integer> getAllTypes(){
        Types types = new Types();
        Map<AddressTypes, Integer> allTypes = new HashMap<>();

        for (Address address : addresses) {
           if(address.getTypes() == AddressTypes.DOKUMENTACIOS){
               types.dokumentacios++;
               allTypes.put(AddressTypes.DOKUMENTACIOS,types.dokumentacios);
           }
            if(address.getTypes() == AddressTypes.EGYEDI){
                types.egyedi++;
                allTypes.put(AddressTypes.EGYEDI,types.egyedi);
            }
            if(address.getTypes() == AddressTypes.HELYI){
                types.helyi++;
                allTypes.put(AddressTypes.HELYI,types.helyi);
            }
        }
        return allTypes;
    }

    public Map<Integer,String> get18Zero(){
        Map<Integer,String> mostZero = new HashMap<>();

        for (int number : sortAddresses.keySet()) {
            int zero = 0;
            String address = sortAddresses.get(number);

            for (int j = 0; j < address.length() ; j++) {
                if(address.charAt(j) == '0'){
                    zero++;
                }
            }
            if(zero >= 18){
                mostZero.put(number, address);
            }
        }
        return mostZero;
    }

    public List<String> getSmallRow(int number){
        List<String> row = new ArrayList<>(Arrays.asList(sortAddresses.get(number).split(":")));

        for (int i = 0; i < row.size() ; i++) {

            if(row.get(i).equals("0000")){
                row.set(i,"0");
            } else if(row.get(i).charAt(0) == '0'){

                for (int j = 0; j < row.get(i).length() ; j++) {

                    if( row.get(i).charAt(j) != 0){

                        row.set(i,row.get(i).substring(j+1));
                        break;
                    }
                }
            }
        }
        return row;
    }

    public String getOriginalRow(int number){
        return sortAddresses.get(number);
    }

    public void shortenRow(List<String> row){
        int first = 0;
        int start = 0;
        int width = 0;
        int mostWidth = 0;

        for (int i = 0; i < row.size() ; i++) {

            if(row.get(i).equals("0") &&  first == 0 ){
                first = i;
                width++;
            } else if(row.get(i).equals("0") ){
                width++;
            }else{

                if( width > mostWidth){
                    mostWidth = width;

                    start = first;
                    width = 0;
                    first = 0;
                }
            }
        }
        for (int i = 0; i < mostWidth ; i++) {
            row.remove(start);
        }

        row.add(start,"");
    }
}
