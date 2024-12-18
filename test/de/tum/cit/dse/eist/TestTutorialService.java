package de.tum.cit.dse.eist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

// Hint: Add any required imports.
// DO NOT change method names.
class TestTutorialService {

    @BeforeEach
    void setUp() {
        // TODO 2: Initialize the service and the observer used by the tests.
// Hint: EasyMock can be used to create a TutorialObserver mock.
    }

    @Test
    void addTutorialSuccess() {
        // TODO 2: Test that a tutorial is added correctly.
        throw new RuntimeException("not implemented");
    }

    @Test
    void addTutorialDuplicateNameThrowsException() {
        // TODO 2: Test that adding a duplicate tutorial throws the correct exception.
        throw new RuntimeException("not implemented");
    }

    @Test
    void tryRegisterStudentSuccess() {
        // TODO 2: Test successful student registration.
        throw new RuntimeException("not implemented");
    }

    @Test
    void tryRegisterStudentTutorialFullReturnsFalse() {
        // TODO 2: Test registration when the tutorial is already full.
        throw new RuntimeException("not implemented");
    }

    @Test
    void tryUnregisterStudentSuccess() {
        // TODO 2: Test successful student unregistration.
        throw new RuntimeException("not implemented");
    }

    @Test
    void tryUnregisterStudentStudentNotRegisteredReturnsFalse() {
        // TODO 2: Test unregistration of a student who is not registered.
        throw new RuntimeException("not implemented");
    }

    @Test
    void getTutorialNonExistentThrowsException() {
        // TODO 2: Test getting a tutorial that does not exist.
        throw new RuntimeException("not implemented");
    }
}
