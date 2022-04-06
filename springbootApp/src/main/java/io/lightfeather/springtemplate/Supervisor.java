package io.lightfeather.springtemplate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Supervisor {

    private @Id @GeneratedValue Long id;
    private String phone;
    private String jurisdiction;
    private String firstName;
    private String lastName;


    Supervisor() {}

    public Supervisor(String firstName, String lastName, String phoneNumber, String supervisor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phoneNumber;
        this.jurisdiction = supervisor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public String getDisplayName() {
        return jurisdiction + " - " + lastName + ", " + firstName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.jurisdiction);
    }

}