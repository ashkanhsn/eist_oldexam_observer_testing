package de.tum.cit.dse.eist.data;

import java.util.ArrayList;
import java.util.List;

// IMPORTANT: Do not change the code in here.
public class Tutorial {
    public final String name;
    private final int capacity;
    private final List<Student> students;

    public Tutorial(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getAvailableSlots() {
        return capacity - students.size();
    }

    public boolean signup(Student student) {
        if (students.size() >= capacity) {
            return false;
        }
        students.add(student);
        return true;
    }

    public boolean unregister(Student student) {
        int index = students.indexOf(student);
        if (index == -1) {
            return false;
        }

        students.remove(index);
        return true;
    }

    public List<Student> getRegisteredStudents() {
        return students;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Tutorial && name.equals(((Tutorial)obj).name);
    }
}
