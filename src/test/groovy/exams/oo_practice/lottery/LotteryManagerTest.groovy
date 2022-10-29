package exams.oo_practice.lottery

import spock.lang.Shared
import spock.lang.Specification

class LotteryManagerTest extends Specification{

    @Shared LotteryManager lotteryManager = new LotteryManager(['37 42 44 61 62', '18 42 54 83 89', '5 12 31 53 60'])

    def 'exams.oo_practice.lottery parseInput' (){

        setup:
            def list = ['37 42 44 61 62', '18 42 54 83 89', '5 12 31 53 60']
            def uniqueList = [37, 44, 61, 62, 18, 54, 83, 42 , 89,
                              5 ,12, 31, 53, 60]

        when:
            def manager = new LotteryManager(list)

        then:
            assert manager.lotteries.size() == 3
            assert manager.allNumbers.size() == uniqueList.size()

            assert manager.lotteries.get(0) == [37, 42, 44, 61,62]
            assert manager.lotteries.get(1) == [18, 42, 54, 83, 89]
            assert manager.lotteries.get(2) == [5, 12, 31, 53, 60]

            assert manager.allNumbers.containsAll(uniqueList)

    }

    def 'exams.oo_practice.lottery getSortNumbers' (){

        when:
            def result = lotteryManager.getSortNumbers(numbers)

        then:
            assert result == expected

        where:
            numbers     | expected
            []          | []
            [1,2,4]     | [1,2,4]
            [2,3,1]     | [1,2,3]

    }

    def 'exams.oo_practice.lottery getSortNumbers-exception' (){

        when:
            lotteryManager.getSortNumbers(null)

        then:
            thrown(NullPointerException)

    }

    def 'getNumbersOfWeek' (){

        when: 'valid case'
            def list = lotteryManager.getNumbersOfWeek(2)

        then:
            assert list == [18, 42, 54, 83, 89]

        when: 'invalid case'
            lotteryManager.getNumbersOfWeek(7)

        then:
            thrown(IndexOutOfBoundsException)
    }

    def 'missingNumbers' (){

        setup:
            def manager = new LotteryManager([])
            (1..maxNumber).every() {number -> manager.allNumbers.add(number)}

        when:
            def comeBack = manager.missingNumbers()

        then:
            assert expected == comeBack

        where:
            maxNumber  | expected
            70         | true
            90         | false
    }

    def 'getOddNumbers' (){

        setup:
            def manager = new LotteryManager([])
                manager.allNumbers.add(22)
                manager.allNumbers.add(26)

        when:
            def number = manager.getOddNumbers()

        then:
            assert number == 0
    }

    def 'getNewList' (){

        when:
            def list = lotteryManager.getNewList([1,2,3,4,5])
        then:
            assert list == [[37,42,44,61,62], [18,42,54,83,89], [5, 12 ,31, 53, 60], [1, 2, 3, 4, 5]]

    }

    def 'getSumNumbers'(){

        when:
            def list = lotteryManager.getSumNumbers(test)
            def map = list

        then:
            assert map == X

        where:
            test                    | X
            ['37 42 44 61 42']      | [37:1, 42:2, 44:1, 61:1]

    }

    def 'getIsPrimeNumber' () {
        setup:
            def manager = new LotteryManager([])

        when:
            def prims = manager.getIsPrimeNumber()

        then:
            assert prims.containsAll([2, 3, 5, 7, 11])
        }


    def 'getMissPrim'(){
        setup:
            def manager = new LotteryManager([])
                manager.allNumbers.add(3)
                manager.allNumbers.add(5)
                manager.allNumbers.add(19)

        when:
            def list = manager.getMissPrim([2, 3, 5, 7, 11, 19])

        then:
            assert list == [2,7,11]
    }



}
