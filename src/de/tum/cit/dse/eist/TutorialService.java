package de.tum.cit.dse.eist;

import de.tum.cit.dse.eist.data.Student;
import de.tum.cit.dse.eist.data.Tutorial;

// Hint: Do not forget the necessary imports.

public class TutorialService {
    // TODO 1.1: Add the observer-related state according to the UML diagram.

    // TODO 1.2: Add the internal state needed to manage tutorials and optional concurrency.

    public void addObserver(TutorialObserver observer) { 
        // TODO 1.2: Add the observer and synchronize its initial state.
        throw new RuntimeException("TutorialService::addObserver: Not implemented yet");
    }

    public void removeObserver(TutorialObserver observer) { 
        // TODO 1.2: Remove the observer from future notifications.
        throw new RuntimeException("TutorialService::removeObserver: Not implemented yet");
    }

    private void notifyObservers(String tutorialName, int availableSlots) { 
        // TODO 1.2: Notify all registered observers.
        throw new RuntimeException("TutorialService::notifyObservers: Not implemented yet");
    }

    public void addTutorial(String name, int availableSlots) { 
        // TODO 1.2: Add a new tutorial.
        throw new RuntimeException("TutorialService::addTutorial: Not implemented yet");
    }

    public boolean tryRegisterStudent(String tutorialName, Student student) { 
        // TODO 1.2: Try to register the student.
        throw new RuntimeException("TutorialService::tryRegisterStudent: Not implemented yet");
    }

    public boolean tryUnregisterStudent(String tutorialName, Student student) { // 
        // TODO 1.2: Try to unregister the student.
        throw new RuntimeException("TutorialService::tryUnregisterStudent: Not implemented yet");
    }

    public Tutorial getTutorial(String tutorialName) {
        // TODO 1.2: Return the requested tutorial.
        throw new RuntimeException("TutorialService::getTutorial: Not implemented yet");
    }
}
