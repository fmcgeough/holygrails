package nfjs

import grails.test.mixin.TestFor
import org.junit.Before

@TestFor(Castle)
class CastleTests {
    Castle castle = new Castle(name:'name',
        city:'city', state:'CT')
    
    @Before
    void setUp() {
        mockForConstraintsTests(Castle, [castle])
    }

    void testValid() {
        assert castle.validate()
    }
    
    void testBlankName() {
        castle.name = ''
        assert !castle.validate()
        assert 'blank' == castle.errors['name']
    }

    void testBlankCity() {
        castle.city = ''
        assert !castle.validate()
        assert 'blank' == castle.errors['city']
    }
    
    void testBlankState() {
        castle.state = ''
        assert !castle.validate()
        assert 'blank' == castle.errors['state']
    }
    
    void testLatTooLow() {
        castle.latitude = -91d;
        assert !castle.validate()
        assert 'min' == castle.errors['latitude']
    }
    
    void testLatTooLarge() {
        castle.latitude = 91d;
        assert !castle.validate()
        assert 'max' == castle.errors['latitude']
    }
    
    void testLatitudeOk() {
        (-90..90).each { lat ->
            castle.latitude = lat as double
            assert castle.validate()
        }
    }

}
