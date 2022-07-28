package fence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreetManager {
    public final List<StreetData> street;
    private final List<StreetData> oddCoasts = new ArrayList<>();

    public StreetManager(List<String> inputData) {
        this.street = new ArrayList<>();
        parseInput(inputData);
    }

    public void parseInput(List<String> rows) {

        for (String row : rows) {
            String[] plotsData = row.split(" ");

            StreetData data = new StreetData(
                    Integer.parseInt(plotsData[0]),
                    Integer.parseInt(plotsData[1]),
                    plotsData[2]);
            street.add(data);

            if(!data.isOdd()){
                oddCoasts.add(data);
            }
        }
    }

    public int getNumberOfPlotsSold(){
        return street.size();
    }

    public StreetData getLastPlot(){
        return street.get(street.size()-1);
    }

    public int getShameFenceColor(){
        int houseNumber = 0;
        int number = 0;

        for (StreetData plot : oddCoasts) {

            if(!plot.getColor().equals(":") && !plot.getColor().equals("#")  ){

                if(plot.getColor().equals(oddCoasts.get(number + 1).getColor())){
                    houseNumber = plot.getHouseNumber();
                    break;
                }
            }
            number++;
        }
        return houseNumber;
    }


    public List<String> getPlot(int house){
        List<String> colorPalette = Arrays.asList("A", "B", "C", "D");

        List<String> twoColors = new ArrayList<>();
        twoColors.add(street.get(house).getColor());

        List<String> colors = new ArrayList<>();

        colors.add(street.get(house).getColor());
        colors.add(street.get(house-2).getColor());
        colors.add(street.get(house+2).getColor());


        for (String color : colorPalette) {
            if(!colors.contains(color)){
                twoColors.add(color);
                break;
            }
        }
        return twoColors;
    }

    public String getColorCodeOfHouse(StreetData house){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < house.getLength(); i++) {
            sb.append(house.getColor());
        }
        return sb.toString();
    }

    public String getHouseNumberCodeOfHouse(StreetData house){
        StringBuilder sb = new StringBuilder();

        int length = String.valueOf(house.getHouseNumber()).length();
        sb.append(house.getHouseNumber());

        for(int i = 0; i < house.getLength()-length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
