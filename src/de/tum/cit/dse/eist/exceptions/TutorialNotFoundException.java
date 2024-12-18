package de.tum.cit.dse.eist.exceptions;

// IMPORTANT: Do not change the code in here.
public class TutorialNotFoundException extends RuntimeException {
    public TutorialNotFoundException(String message) {
        super("Tutorial not found: " + message);
    }
}
