package exams.oo_practice.site

import spock.lang.Specification

class SiteManagerTest extends Specification {


    def 'parseInput'() {
        setup:
            def list = ['','1 23 21 33', '2 12 44 55', '3 23 21 66']

            def expected = [['houseNumber' : 1, 'width' : 23, 'length' : 21, 'area' : 483],
                            ['houseNumber' : 2, 'width' : 12, 'length' : 44, 'area' : 528],
                            ['houseNumber' : 3, 'width' : 23, 'length' : 21, 'area' : 483]]

        when:
            def manager = new SiteManager(list)
        then:
            assert manager.allSite.size() == 3

            for (int i = 1; i < list.size()-1; i++) {
                validateSite(manager.allSite.get(i), expected.get(i))
            }
    }


    def 'getStreetsDistrict'() {
        setup:
            def manager = new SiteManager(['', '1 23 21 33', '2 ' + test + ' 44 55', '3 23 21 66'])
        when:
            def number = manager.getStreetsDistrict()
        then:
            assert number == expected
        where:
            test           | expected
            20             | 200
            30             | 220
            0              | 160
    }


    def 'getAllSiteWitchTwentyMeterOrSmaller'() {
        setup:
            def manager = new SiteManager([])
            manager.goodLifeRow = list

        when:
            def number = manager.getAllSiteWichTwentyMeterOrSmaller()
        then:
            assert number == expected
        where:
            list                        | expected
            [new SiteData(2,10,19,30),
             new SiteData(3,10,21,30)]  | 2
            [ new SiteData(3,10,20,30)] | 1
            []                          | 0
    }


    def 'getBiggestSiteOnTheRichRow'() {
        setup:
            def manager = new SiteManager([])
            manager.richRow = [new SiteData(2,10,19,30),
                               new SiteData(3,33,21,40),
                               new SiteData(4,21,21,40)]

        when:
            def number = manager.getBiggestSiteOnTheRichRow()
        then:
            assert number.houseNumber == 3
            assert number.width == 33
    }


    def 'getSmallestSiteOnTheRichRow'() {
        setup:
            def manager = new SiteManager([])
            manager.richRow = [new SiteData(2,21,19,31),
                               new SiteData(3,19,21,30),
                               new SiteData(4,44,19,31),
                               new SiteData(6,43,21,30)]

        when:
            def number = manager.getSmallestSiteOnTheRichRow()
        then:
            assert number.houseNumber == 3
            assert number.width == 19
    }


    def 'getTaxOfTheRichRow'() {
        setup:
            def manager = new SiteManager([])
            manager.richRow = test as List<SiteData>

        when:
            def number = manager.getTaxOfTheRichRow()
        then:
            assert number == expected
        where:
            test                                   |  expected
            [new SiteData(2,10,19,700)]  | 28600
            [new SiteData(2,10,19,1200)] | 38100
            [new SiteData(2,10,19,700),
             new SiteData(2,10,19,1200)] | 66600
    }

    def 'getLastThreeSiteOfGoodLifeRow'() {

        setup:
            def manager = new SiteManager([])
            manager.goodLifeRow = [new SiteData(1,10,19,31),
                                   new SiteData(2,20,21,30),
                                   new SiteData(3,30,20,30),
                                   new SiteData(4,23,19,180),
                                   new SiteData(5,23,13,300),
                                   new SiteData(6,19,22,220)]

        when:
            def number = manager.getLastThreeSiteOfGoodLifeRow()

        then:
            assert number.size() == 3
            assert number.get(0).houseNumber == 4
            assert number.get(0).width == 23
            assert number.get(0).length == 19
            assert number.get(0).area == 180
            assert number.get(1).houseNumber == 5
            assert number.get(1).width == 23
            assert number.get(1).length == 13
            assert number.get(1).area == 300
            assert number.get(2).houseNumber == 6
            assert number.get(2).width == 19
            assert number.get(2).length == 22
            assert number.get(2).area == 220
    }


    def 'getAllSiteLengthOfGoodLife'(){

        setup:
            def list = ['', '1 23 23 33',
                            '2 12 0 55',
                            '3 23 30 66',
                            '4 23 0 33',
                            '5 12 44 55',
                            '6 23 0 66']
            def manager = new SiteManager(list)

            def expected = [new SiteData(2,12,47,0),
                            new SiteData(4,23,40,0),
                            new SiteData(6,23,26,0)]

        when:
            def test = manager.getAllSiteLengthOfGoodLife()

        then:
            assert test.get(0).houseNumber == expected.get(0).houseNumber
            assert test.get(0).width == expected.get(0).width
            assert test.get(0).length == expected.get(0).length
            assert test.get(0).area == expected.get(0).area

            assert test.get(1).houseNumber == expected.get(1).houseNumber
            assert test.get(1).width == expected.get(1).width
            assert test.get(1).length == expected.get(1).length
            assert test.get(1).area == expected.get(1).area

            assert test.get(2).houseNumber == expected.get(2).houseNumber
            assert test.get(2).width == expected.get(2).width
            assert test.get(2).length == expected.get(2).length
            assert test.get(2).area == expected.get(2).area

    }



    static def validateSite(SiteData site, def expectedData){
        assert site.houseNumber == expectedData.houseNumber
        assert site.width == expectedData.width
        assert site.length == expectedData.length
        assert site.area == expectedData.area
        return true
    }
}




