package common;

import java.util.Objects;

public class PersonName implements Comparable<PersonName>{
    private String firstName;
    private String middleName;
    private String lastName;

    public PersonName(String fullName) {
        String[] name = fullName.split(" ");
        this.firstName = name[0];
        this.lastName = name[1];
    }

    public PersonName(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public PersonName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + (middleName == null ? "" : middleName + " ")  + lastName;
    }

    @Override
    public int compareTo(PersonName o) {
        return this.toString().compareTo(o.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonName that = (PersonName) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(lastName, that.lastName);
    }

}
