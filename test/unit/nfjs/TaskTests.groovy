package nfjs

import grails.test.mixin.TestFor
import org.junit.Before

@TestFor(Task)
class TaskTests {
    Task task = new Task(name:'name')
    
    @Before
    void setUp() {
        Quest q = new Quest(name:'name')
        task.quest = q
        mockForConstraintsTests(Task, [task])
    }

    void testValid() {
        assert task.validate()
    }
    
    void testBlankName() {
        task.name = ''
        assert !task.validate()
        assert 'blank' == task.errors['name']
    }
    
    void testPriorityBelowMin() {
        task.priority = 0
        assert !task.validate()
        assert 'range' == task.errors['priority']
    }
    
    void testPriorityAboveMax() {
        task.priority = 6
        assert !task.validate()
        assert 'range' == task.errors['priority']
    }
    
    void testValidPriorities() {
        (1..5).each {
            task.priority = it
            assert task.validate()
        }
    }
    
    void testEndDateAfterStartDate() {
        task.endDate = task.startDate - 1
        assert !task.validate()
        assert 'validator' == task.errors['endDate']
    }
}
