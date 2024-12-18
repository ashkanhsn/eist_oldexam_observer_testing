package de.tum.cit.dse.eist;

import de.tum.cit.dse.eist.data.Student;

import java.util.List;

// Hint: Do not forget the necessary imports.
// TODO 3: Complete the class declaration according to the UML diagram.

public class WaitingList {
    // TODO 3: Add the fields needed to manage waiting students for each tutorial.

    // TODO 3: Keep the service reference needed for registration attempts.

    // Optional: Add a synchronization mechanism for the concurrency part.


    public WaitingList(TutorialService tutorialService) {
        // TODO 3: Initialize the waiting list and register it as an observer.
        throw new RuntimeException("WaitingList::WaitingList: Not implemented yet");
    }

    public void addStudentToWaitingList(String tutorial, Student student) {
        // TODO 3: Add the student to the waiting list of the given tutorial.
        throw new RuntimeException("WaitingList::addStudentToWaitingList: Not implemented yet");
    }

    public List<Student> getStudentsInWaitingList(String tutorial) {
        // TODO 3: Return the waiting students for the given tutorial.
        throw new RuntimeException("WaitingList::getStudentsInWaitingList: Not implemented yet");
    }
    
    // TODO 3: React to tutorial slot updates received through the observer interface.
}
