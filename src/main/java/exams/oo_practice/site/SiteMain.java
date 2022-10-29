package exams.oo_practice.site;

import common.file.GeneralFileReader;

import java.util.List;

public class SiteMain {
    public static void main(String[] args) {

        final int FIRST_NUMBER_OF_GOOD_LIFE = 2;

        GeneralFileReader reader = new GeneralFileReader("src/main/resources/exams/oo_practice/site/telkek.txt");

        List<String> inputData = reader.readLines();
        SiteManager manager = new SiteManager(inputData);

        // 2.task
        int district = manager.getStreetsDistrict();
        System.out.println("\n2.task \nA körbesétáláshoz " + district + " métert kell megtenni" );

        // 3.task
        long allSite = manager.getAllSiteWichTwentyMeterOrSmaller();
        System.out.println("\n3.task \nA összesen " + allSite + " telket kell beépiteni" );

        // 4.task
        SiteData smallest = manager.getSmallestSiteOnTheRichRow();
        SiteData biggest = manager.getBiggestSiteOnTheRichRow();

        System.out.println("\n4.task \nA legkisebb telek " + smallest.getHouseNumber() + " " + smallest.getWidth() * smallest.getLength()
                           + "\nA legnagyobb telek  " + biggest.getHouseNumber() +" "+ biggest.getWidth() * biggest.getLength()
                            + "\nA két telek közti telkek száma " + (biggest.getHouseNumber() - smallest.getHouseNumber()) );


        // 5.task
        int amount = manager.getTaxOfTheRichRow();
        System.out.println("\n5.task \nA összesen " + amount + " adóbevételre  számíthat az önkormányzat" );

        // 6.task
        System.out.println("\n6.task");
        List<SiteData> threeSite = manager.getLastThreeSiteOfGoodLifeRow();
        for (SiteData site : threeSite) {
            System.out.println("A házszám " + site.getHouseNumber() + " távolsága " +
                    (site.getHouseNumber()-FIRST_NUMBER_OF_GOOD_LIFE));
        }

        // 7.task
        System.out.println("\n7.task ");
        List<SiteData> list = manager.getAllSiteLengthOfGoodLife();
        for (SiteData site : list) {
            System.out.println(site);
        }


    }
}
