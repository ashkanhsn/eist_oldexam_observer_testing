package de.tum.cit.dse.eist.exceptions;

// IMPORTANT: Do not change the code in here.
public class TutorialAlreadyExistsException extends RuntimeException {
    public TutorialAlreadyExistsException(String message) {
      super("Tutorial already exists: " + message);
    }
}
