[README.md](https://github.com/user-attachments/files/29940370/README.md)
You’re a developer at the Technical University of Garching b. München (TUGbM) — not to be confused with TUM. Until now, tutorial signups were handled manually via email, creating a burden for 
secretaries due to frequent student registration changes.

To improve this, the university is funding a new tutorial signup system for next semester. It will show available slots, manage a waiting list, and automatically assign spots as they open. You choose the Observer Pattern to let the waiting list and dashboard react independently to slot updates.

Part 0
Here is an overview of the project and the distribution of the tasks. Familiarize yourself with the structure of the provided code.
![Screenshot 2026-07-12 at 15.49.36.png](../../../../../var/folders/nl/gvfqz3f501n8b03j3_7vt2f40000gn/T/TemporaryItems/NSIRD_screencaptureui_o4SB0h/Screenshot%202026-07-12%20at%2015.49.36.png)

Part 1
First, start with implementing the Observer Pattern. For now, only implement the TutorialService, TutorialObserver, and TutorialDashboard.

1.1 Observer pattern
Implement the basic observer structure according to the UML diagram: define the observer interface, let TutorialService store observers, and make TutorialDashboard implement the observer interface.
![Screenshot 2026-07-12 at 15.50.02.png](../../../../../var/folders/nl/gvfqz3f501n8b03j3_7vt2f40000gn/T/TemporaryItems/NSIRD_screencaptureui_TdvI7a/Screenshot%202026-07-12%20at%2015.50.02.png)

Observer Pattern No tests
Complete the TODOs marked with 1.1 in TutorialObserver, TutorialService, and TutorialDashboard. The behavior of adding, removing, and notifying observers will be implemented in Part 1.2.
1.2 Tutorial Service
The TutorialService also contains the following methods:

public void addObserver(TutorialObserver observer)
Adds the given observer. Then immediately calls update on this new observer once for each existing tutorial, using the tutorial's current number of available slots.
public void removeObserver(TutorialObserver observer) Removes the given observer. After removal, it should no longer receive updates.
private void notifyObservers(String tutorialName, int availableSlots)
Calls update on each registered observer with the given tutorial name and its current number of available slots.
public void addTutorial(String name, int availableSlots)
Adds a new tutorial with the given name and initial number of available slots. The new tutorial has no registered students. If a tutorial with the same name already exists, throw a TutorialAlreadyExistsException.
public boolean tryRegisterStudent(String tutorialName, Student student)
Try registering a student. If the tutorial does not exist, throw a TutorialNotFoundException. If the tutorial is full, return false and do not register the student. Otherwise, add the student to the tutorial and return true. After the registration attempt, call notifyObservers if the tutorial exists.
public boolean tryUnregisterStudent(String tutorialName, Student student)
Try unregistering a student. If the tutorial does not exist, throw a TutorialNotFoundException. If the student was not registered for the tutorial, return false. Otherwise, remove the student from the tutorial and return true. After the unregistration attempt, call notifyObservers if the tutorial exists.
public Tutorial getTutorial(String tutorialName)
Return the tutorial with the given name, if it exists. If it doesn't exist, throw a TutorialNotFoundException.
Tip

An observer may call the TutorialService in its update method.
In this exercise, notifyObservers is called after each registration or unregistration attempt if the tutorial exists. This keeps the implementation simple, but may notify observers even when no state changed. In a real-world system, observers are usually notified only after a successful state change.
The concurrency part is optional and can be skipped, if you're short on time.
Use SmokeTest.java to roughly check if your implementation works correctly when used concurrently.
TutorialService Methods No tests
Implement the methods listed above in TutorialService.java.
TutorialService Concurrency No tests
Make your implementation thread-safe. (Can be skipped if you're short on time.)
1.3 Tutorial Dashboard
The TutorialDashboard, in addition to the methods from the observer pattern, contains the following methods:

public int getAvailableSlots(String tutorialName): Returns the number of available slots stored for the given tutorial. Returns 0 if the dashboard has not received any update for this tutorial.
public String formatDashboard(): This function returns a string with all the tutorials, sorted by name, formatted like the example below. The dashboard only keeps state it receives from the observer pattern. The dashboard is only aware of tutorials it is notified by the TutorialService through update.
![Screenshot 2026-07-12 at 15.50.46.png](../../../../../var/folders/nl/gvfqz3f501n8b03j3_7vt2f40000gn/T/TemporaryItems/NSIRD_screencaptureui_HVW0Wj/Screenshot%202026-07-12%20at%2015.50.46.png)

TutorialDashboard Methods No tests
Implement the methods listed above in TutorialDashboard.java. Also override the update method from the observer interface so that the dashboard stores the received tutorial slot information.

Part 2
Now, to ensure you did your job in part 1 correctly, write the following unit tests in the TutorialServiceTest. This class as well as the method bodies already exist.

void addTutorialSuccess(): Check that the tutorial is correctly added.
void addTutorialDuplicateNameThrowsException(): Check that adding a duplicate tutorial correctly throws a TutorialAlreadyExistsException.
void tryRegisterStudentSuccess(): Check that registering a student correctly updates the tutorial slots and returns true. The test should also verify that observers are notified.
void tryRegisterStudentTutorialFullReturnsFalse(): Check that registering a student to a full tutorial returns false and does not update the available slots.
void tryUnregisterStudentSuccess(): Check that unregistering correctly updates the tutorial slots and returns true. The test should also verify that observers are notified.
void tryUnregisterStudentStudentNotRegisteredReturnsFalse(): Check that unregistering a student who is not registered for the tutorial returns false and does not update the available slots.
void getTutorialNonExistentThrowsException(): Check that getting a non-existent tutorial throws a TutorialNotFoundException.
For tryUnregisterStudentSuccess() and tryRegisterStudentSuccess(), the test should check if the student is actually added/removed from the internal student list of the tutorial.

For tryUnregisterStudentSuccess() and tryUnregisterStudentStudentNotRegisteredReturnsFalse(), the test should check if observer.update() is called with the correct arguments.

After implementing these tests, run them to see if your implementation from Part 1 is correct.

Tip

EasyMock can be used to mock classes and check whether methods have been called on objects like TutorialObserver. However, this is not a must for achieving full marks.

TutorialService Unit Tests No tests
Implement the test methods listed above in TestTutorialService.java.

Part 3
Warning

This third part is more challenging and may involve tricky concurrency issues. If you are short on time or stuck, consider skipping the concurrency parts for now and coming back later. You may need to re-visit code you have written earlier to handle concurrency properly (see 1.2 Concurrency).

Since the TUGbM is a small and not very excellent university, it does not have a lot of funding for tutors. It frequently happens that there are many more students than tutorial slots available. Implement a thread-safe waiting list, that also implements the TutorialObserver interface:
![Screenshot 2026-07-12 at 15.51.39.png](../../../../../var/folders/nl/gvfqz3f501n8b03j3_7vt2f40000gn/T/TemporaryItems/NSIRD_screencaptureui_LQ69PN/Screenshot%202026-07-12%20at%2015.51.39.png)

The waiting should, in addition to the methods from the observer pattern, implement the following methods:

public void addStudentToWaitingList(String tutorial, Student student)
Add a student to the waiting list for a given tutorial.
public List<Student> getStudentsInWaitingList(String tutorial)
Return the students in the waiting list for a given tutorial, or an empty list, if there are none.
Constructor: The constructor needs to register the waiting list as an observer.
The waiting list should react to new free slots in its update method. Whenever there are free slots available and a student is in the waiting list for that tutorial, try to register the student for the tutorial. This might fail (e.g., because another student just signed up for the tutorial), so make sure you handle this case carefully. Beware that signing up a student for a tutorial might result in a call to the update function again, so make sure you do not create any deadlocks. Also make sure to not introduce accidental data races, as students might be added to the waiting list while you are trying to sign up a student. If it is not possible to add a student to the waiting list, the student should stay in the waiting list.

Important

The waiting list needs to react to slot changes from the very beginning of the semester, make sure it starts receiving updates as soon as it is created.

WaitingList Constructor and Methods No tests
Implement the constructor and the methods listed above in WaitingList.java.
