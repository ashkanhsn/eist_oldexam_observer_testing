package de.tum.cit.dse.eist;

import de.tum.cit.dse.eist.data.Student;
import de.tum.cit.dse.eist.data.Tutorial;
import de.tum.cit.dse.eist.exceptions.TutorialAlreadyExistsException;
import de.tum.cit.dse.eist.exceptions.TutorialNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;

// Hint: Do not forget the necessary imports.

public class TutorialService {
    // TODO 1.1: Add the observer-related state according to the UML diagram.
    private HashMap<String, Tutorial> tutorials;
    private List<TutorialObserver> observers;

    // TODO 1.2: Add the internal state needed to manage tutorials and optional concurrency.

    public TutorialService(){
        this.tutorials = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public void addObserver(TutorialObserver observer) { 
        // TODO 1.2: Add the observer and synchronize its initial state.
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(TutorialObserver observer) { 
        // TODO 1.2: Remove the observer from future notifications.
        observers.remove(observer);
    }

    private void notifyObservers(String tutorialName, int availableSlots) { 
        // TODO 1.2: Notify all registered observers.
        for (TutorialObserver observer: observers){
            observer.update(tutorialName, availableSlots);
        }
    }

    public void addTutorial(String name, int availableSlots) { 
        // TODO 1.2: Add a new tutorial.
        if (tutorials.containsKey(name)){
            throw new TutorialAlreadyExistsException("already there!");
        }else{
            Tutorial newTutorial = new Tutorial(name, availableSlots);
            tutorials.put(name, newTutorial);
        }
    }

    public boolean tryRegisterStudent(String tutorialName, Student student) { 
        // TODO 1.2: Try to register the student.
        if (!tutorials.containsKey(tutorialName)){
            throw new TutorialNotFoundException("not found");
        }else{
            Tutorial tutor = tutorials.get(tutorialName);
            if (tutor.getAvailableSlots() <= 0){
                return false;
            }else{
                tutor.signup(student);
                notifyObservers(tutorialName, tutor.getAvailableSlots());
                return true;
            }
        }

    }

    public boolean tryUnregisterStudent(String tutorialName, Student student) { // 
        // TODO 1.2: Try to unregister the student.
        if (!tutorials.containsKey(tutorialName)){
            throw new TutorialNotFoundException("not there");
        }else{
            Tutorial tutorial = tutorials.get(tutorialName);
            if (tutorial.getRegisteredStudents().contains(student)){
                tutorial.unregister(student);
                notifyObservers(tutorialName, tutorial.getAvailableSlots());
                return true;
            }else {
                return false;
            }
        }
    }

    public Tutorial getTutorial(String tutorialName) {
        // TODO 1.2: Return the requested tutorial.
        if (tutorials.containsKey(tutorialName)){
            return tutorials.get(tutorialName);
        }else{
            throw new TutorialNotFoundException("not exist");
        }
    }
}
