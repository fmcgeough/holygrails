package nfjs

class Knight {
    String title
    String name
    Quest quest
    Castle castle
    
    String toString() { "$title $name" }
    
    static constraints = {
        title inList:['Sir','Lord','King','Squire']
        name blank:false
        quest nullable:true
        castle nullable:true
    }
}
