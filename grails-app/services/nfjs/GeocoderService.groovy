package nfjs

class GeocoderService {

    public static final BASE = 'http://maps.googleapis.com/maps/api/geocode/xml?'
    
    def fillInLatLng(Castle castle) {
        def encoded = [castle.city, castle.state].collect {
            URLEncoder.encode(it, 'UTF-8')
        }.join(',+')
        def qs = [address:encoded, sensor:false].collect { it }.join('&')
        def root = new XmlSlurper().parse(BASE + qs)
        castle.latitude = 
            root.result[0].geometry.location.lat.toDouble()
        castle.longitude =
            root.result[0].geometry.location.lng.toDouble()
    }    
}
