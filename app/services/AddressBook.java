package services;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AddressBook {
    private String firstName;
    private String lastName;
    private boolean isMale;
    private DateTime birthDate;
    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yy");

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public AddressBook(String firstName, String lastName, boolean isMale, DateTime birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMale = isMale;
        this.birthDate = birthDate;
    }

    public AddressBook(String line) {
        final String[] tokens = line.split(",");
        final String[] fullName = tokens[0].trim().split(" ");
        this.firstName = fullName[0];
        this.lastName = fullName[1];
        this.isMale = tokens[1].trim().equals("Male");
        this.birthDate = formatter.parseDateTime(tokens[2].trim());
    }
}
