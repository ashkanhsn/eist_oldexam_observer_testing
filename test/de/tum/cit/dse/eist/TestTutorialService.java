package de.tum.cit.dse.eist;

import de.tum.cit.dse.eist.data.Student;
import de.tum.cit.dse.eist.data.Tutorial;
import de.tum.cit.dse.eist.exceptions.TutorialAlreadyExistsException;
import de.tum.cit.dse.eist.exceptions.TutorialNotFoundException;
import org.easymock.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

// Hint: Add any required imports.
// DO NOT change method names.
class TestTutorialService {

    @Mock
    private TutorialObserver tutorialObserver;
    private TutorialService tutorialService;

    @BeforeEach
    void setUp() {
        // TODO 2: Initialize the service and the observer used by the tests.
// Hint: EasyMock can be used to create a TutorialObserver mock.
        this.tutorialService = new TutorialService();
    }

    @Test
    void addTutorialSuccess() {
        // TODO 2: Test that a tutorial is added correctly.
        Tutorial newTutorial = new Tutorial("Ashkan", 10);
        tutorialService.addTutorial(newTutorial.name, newTutorial.getAvailableSlots());
        assertEquals(10 , tutorialService.getTutorial("Ashkan").getAvailableSlots());
    }

    @Test
    void addTutorialDuplicateNameThrowsException() {
        // TODO 2: Test that adding a duplicate tutorial throws the correct exception.
        Tutorial newTutorial = new Tutorial("Ashkan", 10);
        tutorialService.addTutorial(newTutorial.name, newTutorial.getAvailableSlots());
        assertThrows(TutorialAlreadyExistsException.class, () -> tutorialService.addTutorial("Ashkan", 10));
    }

    @Test
    void tryRegisterStudentSuccess() {
        // TODO 2: Test successful student registration.
        Tutorial newTutorial = new Tutorial("Ashkan", 10);
        Student student = new Student("a", "b", "sjkdf");
        tutorialService.addTutorial(newTutorial.name, newTutorial.getAvailableSlots());
        assertTrue(tutorialService.tryRegisterStudent(newTutorial.name, student));
    }

    @Test
    void tryRegisterStudentTutorialFullReturnsFalse() {
        // TODO 2: Test registration when the tutorial is already full.
        Tutorial newTutorial = new Tutorial("Ashkan", 1);
        Student student1 = new Student("a", "b", "sjkdf");
        Student student2 = new Student("f", "y", "bfuid");
        tutorialService.addTutorial(newTutorial.name, newTutorial.getAvailableSlots());
        assertTrue(tutorialService.tryRegisterStudent(newTutorial.name, student1));
        assertFalse(tutorialService.tryRegisterStudent(newTutorial.name, student2));
    }

    @Test
    void tryUnregisterStudentSuccess() {
        // TODO 2: Test successful student unregistration.
        Tutorial newTutorial = new Tutorial("Ashkan", 10);
        Student student = new Student("a", "b", "sjkdf");
        tutorialService.addTutorial(newTutorial.name, newTutorial.getAvailableSlots());
        assertTrue(tutorialService.tryRegisterStudent(newTutorial.name, student));
        assertTrue(tutorialService.tryUnregisterStudent(newTutorial.name, student));
    }

    @Test
    void tryUnregisterStudentStudentNotRegisteredReturnsFalse() {
        // TODO 2: Test unregistration of a student who is not registered.
        Tutorial newTutorial = new Tutorial("Ashkan", 10);
        Student student = new Student("a", "b", "sjkdf");
        tutorialService.addTutorial(newTutorial.name, newTutorial.getAvailableSlots());
        assertFalse(tutorialService.tryUnregisterStudent(newTutorial.name, student));
    }

    @Test
    void getTutorialNonExistentThrowsException() {
        // TODO 2: Test getting a tutorial that does not exist.
        Tutorial newTutorial = new Tutorial("Ashkan", 10);
        assertThrows(TutorialNotFoundException.class, () -> tutorialService.getTutorial(newTutorial.name) );
    }
}
