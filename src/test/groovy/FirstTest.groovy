
import spock.lang.Specification

class FirstTest extends Specification {

    def "firstTest" (){
        when:
            def a = 10

        then:
            assert a == 10
    }
}
