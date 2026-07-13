package de.tum.cit.dse.eist;

import de.tum.cit.dse.eist.data.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// Hint: Do not forget the necessary imports.
// TODO 3: Complete the class declaration according to the UML diagram.

public class WaitingList implements TutorialObserver{
    // TODO 3: Add the fields needed to manage waiting students for each tutorial.

    // TODO 3: Keep the service reference needed for registration attempts.

    // Optional: Add a synchronization mechanism for the concurrency part.
    private HashMap<String, List<Student>> waitingList;
    private ReentrantLock mutex;
    private TutorialService tutorialService;


    public WaitingList(TutorialService tutorialService) {
        // TODO 3: Initialize the waiting list and register it as an observer.
        this.waitingList = new HashMap<>();
        this.tutorialService = tutorialService;
        tutorialService.addObserver(this);
        this.mutex = new ReentrantLock();
    }

    public void addStudentToWaitingList(String tutorial, Student student) {
        // TODO 3: Add the student to the waiting list of the given tutorial.
        waitingList.computeIfAbsent(tutorial, t -> new ArrayList<>()).add(student);
    }

    public List<Student> getStudentsInWaitingList(String tutorial) {
        // TODO 3: Return the waiting students for the given tutorial.
        return waitingList.getOrDefault(tutorial, new ArrayList<>());
    }

    @Override
    public void update(String tutorialName, int availableSlots) {
        List<Student> students = getStudentsInWaitingList(tutorialName);
        if (students.isEmpty() || availableSlots <= 0) {
            return;
        } else {
            List<Student> copy = new ArrayList<>(students);
            for (int i = 0; i < availableSlots; i++) {
                if (i < students.size()) {
                    boolean flag = tutorialService.tryRegisterStudent(tutorialName, copy.get(i));
                    if (flag) {
                        students.remove(copy.get(i));
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // TODO 3: React to tutorial slot updates received through the observer interface.
}
