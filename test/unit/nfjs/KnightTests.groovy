package nfjs

import grails.test.mixin.TestFor
import org.junit.Before

@TestFor(Knight)
class KnightTests {
    Knight knight = new Knight(title:'Sir',name:'Lancelot')

    @Before
    void setUp() {
        mockForConstraintsTests(Knight, [knight])
    }
    
    void testValid() {
        assert knight.validate()
    }
    
    void testBlankName() {
        knight.name = ''
        assert !knight.validate()
        assert 'blank' == knight.errors['name']
    }
    
    void testInvalidTitle() {
        knight.title = 'Baron'
        assert !knight.validate()
        assert 'inList' == knight.errors['title']
    }
    
    void testValidTitles() {
        ['Sir','Lord','King','Squire'].each { title ->
            knight.title = title
            assert knight.validate()
        }
    }
}
