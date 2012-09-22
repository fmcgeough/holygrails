package nfjs

import grails.test.mixin.TestFor
import org.junit.Before

@TestFor(Quest)
class QuestTests {
    Quest quest = new Quest(name:'Seek the grail')

    @Before
    void setUp() {
        mockForConstraintsTests(Quest, [quest])
    }
    
    void testValid() {
        assert quest.validate()
    }
    
    void testBlankName() {
        quest.name = ''
        assert !quest.validate()
        assert 'blank' == quest.errors['name']
    }
}
