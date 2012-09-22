package nfjs

class Quest {
    String name
    Date dateCreated
    Date lastUpdated
    
    String toString() { name }

    static hasMany = [tasks:Task]
    
    static constraints = {
        name blank:false
    }
}
