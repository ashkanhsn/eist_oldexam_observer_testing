package de.tum.cit.dse.eist.data;

import java.util.Objects;

// IMPORTANT: Do not change the code in here.
public class Student {
    public final String firstName;
    public final String lastName;
    public final String email;

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student && firstName.equals(((Student) obj).firstName) &&
                lastName.equals(((Student) obj).lastName) &&
                email.equals(((Student) obj).email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + email + ">";
    }
}
