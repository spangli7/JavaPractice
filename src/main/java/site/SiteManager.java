package site;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SiteManager {

    public final int STREETS_WIDTH = 80;
    public final int SITE_MAX_WIDTH = 20;
    public final List<SiteData> allSite;
    public List<SiteData> goodLifeRow = new ArrayList<>();
    public List<SiteData> richRow = new ArrayList<>();



     public SiteManager(List<String> inputData){
        allSite = new ArrayList<>();
        parseInput(inputData);
     }

     void parseInput(List<String> inputData) {
         int goodLifeRowTotalLength = 0;
         int richRowTotalLength = 0;

         for (int i = 1; i < inputData.size() ; i++) {
             String[] spiltData = inputData.get(i).split(" ");

             if(spiltData.length > 2){
                SiteData data = new SiteData(Integer.parseInt(spiltData[0]),Integer.parseInt(spiltData[1]),
                        Integer.parseInt(spiltData[2]),Integer.parseInt(spiltData[1]) * Integer.parseInt(spiltData[2]));
                allSite.add(data);

                 if(data.getHouseNumber() % 2 == 0){
                     data.setStart(goodLifeRowTotalLength);
                     goodLifeRowTotalLength += data.getWidth();
                     goodLifeRow.add(data);
                 } else{
                     data.setStart(richRowTotalLength);
                     richRowTotalLength += data.getWidth();
                     richRow.add(data);

                 }
             }
         }
     }

    public int getStreetsDistrict(){
         SiteData lastHouse = goodLifeRow.get(goodLifeRow.size() - 1);
         return 2 * (lastHouse.getStart() + lastHouse.getWidth() + STREETS_WIDTH);
     }


    public long getAllSiteWichTwentyMeterOrSmaller(){
        return goodLifeRow.stream()
                .filter(m ->m.getWidth() <= SITE_MAX_WIDTH)
                .count();
    }

    public SiteData getBiggestSiteOnTheRichRow(){
        return richRow.stream()
                .max(Comparator.comparingInt(SiteData::getWidth))
                .orElse(null);
    }

    public SiteData getSmallestSiteOnTheRichRow(){
        return richRow.stream()
                .min(Comparator.comparingInt(SiteData::getWidth))
                .orElse(null);
    }


    public int getTaxOfTheRichRow(){
        int totalTax = 0;

        for (SiteData site : richRow) {
            int tax = 0;

            if(site.getArea() > 1000){
                tax += 200;
            }
            if(site.getArea() > 700) {
                tax += (Math.min(1000, site.getArea()) - 700) * 39;
            }
            tax += Math.min(700, site.getArea()) * 51;

            if(site.getWidth() <= 15 || site.getLength() <= 25){
                int discount =  tax / (100 / 20 );
                tax -= discount;
            }
            totalTax += tax;
        }

        totalTax = ((totalTax + 50) / 100 ) * 100;
        return totalTax;
    }


    public List<SiteData> getLastThreeSiteOfGoodLifeRow(){
        return goodLifeRow.subList(goodLifeRow.size()-3, goodLifeRow.size());
    }



    public List<SiteData> getAllSiteLengthOfGoodLife(){

        for (SiteData siteData : goodLifeRow) {

            int startGoodLifeSite = siteData.getStart();
            int endGoodLifeSite = startGoodLifeSite + siteData.getWidth();
            int maxLength = -1;

            for (SiteData site : richRow) {
                int startRichRowSite = site.getStart();
                int endRichRowSite = startRichRowSite + site.getWidth();

                if (!(startGoodLifeSite > startRichRowSite && startGoodLifeSite > endRichRowSite) && !(endGoodLifeSite < startRichRowSite && endGoodLifeSite < endRichRowSite)) {
                    if (site.getLength() > maxLength) {
                        maxLength = site.getLength();
                    }
                }
            }
            siteData.setLength(STREETS_WIDTH - maxLength - 10);
        }
        return goodLifeRow;
    }

}
