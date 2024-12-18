package de.tum.cit.dse.eist;

import de.tum.cit.dse.eist.data.Student;

public class SmokeTest {
    public static void main(String[] args) {
        TutorialService tutorialService = new TutorialService();

        /* uncomment if TutorialDashboard is implemented
        TutorialDashboard dashboard = new TutorialDashboard();
        tutorialService.addObserver(dashboard);
        */

        WaitingList waitingList = new WaitingList(tutorialService);

        tutorialService.addTutorial("PDGP", 2);
        tutorialService.addTutorial("Software Engineering", 1);

        Student alice = new Student("Alice", "Wilson", "alice@tum.de");
        Student bob = new Student("Bob", "Wilson", "bob@tum.de");
        Student charlie = new Student("Charlie", "Wilson", "charlie@tum.de");
        Student jack = new Student("Jack", "Wilson", "jack@tum.de");
        Student banga = new Student("Banga", "Wilson", "banga@tum.de");

        Thread thread1 = new Thread(() -> {
            boolean registered = tutorialService.tryRegisterStudent("PDGP", alice);
            System.out.println("Alice registered PDGP: " + registered);
            // uncomment if WaitingList is implemented
            // if (!registered) waitingList.addStudentToWaitingList("PDGP", alice);
        });

        Thread thread2 = new Thread(() -> {
            boolean registered = tutorialService.tryRegisterStudent("PDGP", bob);
            System.out.println("Bob registered PDGP: " + registered);
            // uncomment if WaitingList is implemented
            // if (!registered) waitingList.addStudentToWaitingList("PDGP", bob);
        });

        Thread thread3 = new Thread(() -> {
            boolean registered = tutorialService.tryRegisterStudent("PDGP", charlie);
            System.out.println("Charlie registered PDGP: " + registered);
            // uncomment if WaitingList is implemented
            // if (!registered) waitingList.addStudentToWaitingList("PDGP", charlie);
        });

        Thread thread4 = new Thread(() -> {
            boolean registered = tutorialService.tryRegisterStudent("Software Engineering", jack);
            System.out.println("Jack registered Software Engineering: " + registered);
            // uncomment if WaitingList is implemented
            // if (!registered) waitingList.addStudentToWaitingList("Software Engineering", jack);
        });

        Thread thread5 = new Thread(() -> {
            boolean registered = tutorialService.tryRegisterStudent("Software Engineering", banga);
            System.out.println("Banga registered Software Engineering: " + registered);
            // uncomment if WaitingList is implemented
            // if (!registered) waitingList.addStudentToWaitingList("Software Engineering", banga);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* uncomment if TutorialDashboard is implemented
        System.out.println("\nDashboard after registrations:");
        System.out.println(dashboard.formatDashboard());
        */

        /* uncomment if WaitingList is implemented
        System.out.println("Students in waiting list for PDGP:");
        waitingList.getStudentsInWaitingList("PDGP").forEach(System.out::println);

        System.out.println("\nStudents in waiting list for Software Engineering:");
        waitingList.getStudentsInWaitingList("Software Engineering").forEach(System.out::println);

        tutorialService.tryUnregisterStudent("PDGP", alice);
        tutorialService.tryUnregisterStudent("Software Engineering", jack);

        System.out.println("\nStudents in waiting list for PDGP:");
        waitingList.getStudentsInWaitingList("PDGP").forEach(System.out::println);

        System.out.println("\nStudents in waiting list for Software Engineering:");
        waitingList.getStudentsInWaitingList("Software Engineering").forEach(System.out::println);
        */
    }
}