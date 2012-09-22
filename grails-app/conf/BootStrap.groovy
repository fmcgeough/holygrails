import nfjs.*

class BootStrap {

    def init = { servletContext ->
        Quest q = new Quest(name:'Seek the grail')
            .addToTasks(name:'Run away from killer rabbit')
            .addToTasks(name:'Answer the bridgekeeper',priority:1)
            .addToTasks(name:'Defeat the Black Knight',completed:true)
            .addToTasks(name:'Bring out your dead',completed:true,priority:4)
            .addToTasks(name:'Give a shrubbery to Knights Who Say Ni!',priority:2)
            .addToTasks(name:'Get taunted by Frenchman',completed:true)
            .addToTasks(name:'Weigh a witch against a duck')
            .addToTasks(name:'Dance and sing and imitate Clark Gable',completed:true)
            .addToTasks(name:'Build Giant Wooden Hare')
            .addToTasks(name:'Attack Swamp Castle',priority:5)
            .addToTasks(name:'Applaud Tim the Enchanter')
            .addToTasks(name:'Oppress peasant')
            .addToTasks(name:'Lobbeth thou thy Holy Hand Grenade of Antioch')
            .save(failOnError:true)
        Castle camelot = new Castle(name:'Camelot',city:'Boston',state:'MA')
            .addToKnights(title:'King',name:'Arthur',quest:q)
            .addToKnights(title:'Sir', name:'Lancelot the Brave',quest:q)
            .addToKnights(title:'Sir', name:'Galahad the Pure', quest:q)
            .addToKnights(title:'Sir', name:'Bedevere', quest:q)
            .addToKnights(title:'Sir', name:'Robin',quest:q)
            .save(failOnError:true)

        Castle aarrgghh = new Castle(name:'Aaaarrrrggghhh',city:'Framingham',state:'MA')
            aarrgghh.save(failOnError:true)
    }

    def destroy = {
    }
}
