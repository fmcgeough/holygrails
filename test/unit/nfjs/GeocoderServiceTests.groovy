package nfjs

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import groovy.mock.interceptor.StubFor;

import static org.junit.Assert.*
import org.junit.Before

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(GeocoderService)
@Mock(Castle)
class GeocoderServiceTests {
    def xml = '''
    <root><result><geometry>
        <location>
             <lat>40</lat>
             <lng>-100</lng>
        </location>
    </geometry></result></root>'''
    
    def slurper
    
    @Before
    void setUp() {
        def root = new XmlSlurper().parseText(xml)
        slurper = new StubFor(XmlSlurper)
        slurper.demand.parse { root }
    }
    
    void testOnline() {
        Castle google = new Castle(city:'Mountain View',state:'CA')
        service.fillInLatLng(google)
        assertEquals(  37.4, google.latitude, 0.1)
        assertEquals(-122.1, google.longitude, 0.1)
    }
    
    
    void testOffline() {
        Castle castle = new Castle(name:'Camelot',
            street:'street',city:'city',state:'state')
        
        slurper.use {
            service.fillInLatLng(castle)
            
            assertEquals(40, castle.latitude, 0.01)
            assertEquals(-100, castle.longitude, 0.01)
        }
    }
}
