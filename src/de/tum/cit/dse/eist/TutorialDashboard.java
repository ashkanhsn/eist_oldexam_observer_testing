package de.tum.cit.dse.eist;

// Hint: Add any required imports.

import java.util.HashMap;

public class TutorialDashboard implements TutorialObserver{
    // TODO 1.1: Complete the class declaration according to the UML diagram.
    // Hint: Don't forget to add the observer method required by the interface.
    private HashMap<String, Integer> tutorialSlots;
    
    // TODO 1.3: Add the internal state needed to store tutorial slot information.
    // Optional: Add synchronization if you implement the concurrency part.

    // TODO 1.3: Update the dashboard state when new slot information is received.
    

    public int getAvailableSlots(String tutorialName) { 
        // TODO 1.3: Look up the requested tutorial in the dashboard state.
        return tutorialSlots.getOrDefault(tutorialName, 0);
    }

    public String formatDashboard() { 
        // TODO 1.3: Create the formatted dashboard string as described in the task.
        // Hint: hashMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> { /* something */})
        throw new RuntimeException("TutorialDashboard::formatDashboard: Not implemented yet");
    }

    @Override
    public void update(String tutorialName, int availableSlots) {
        if (tutorialSlots.containsKey(tutorialName)){
            tutorialSlots.replace(tutorialName, availableSlots);
        }else{
            tutorialSlots.put(tutorialName, availableSlots);
        }
    }
}
