package com.dzone.api;
import com.dzone.api.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student extends BaseModel {

    private String firstName;
    private String lastName;
    private String marks;
    private long dob;
    @Email
    private String email;


    public Student() {
    }

    public Student(String firstName, String lastName, String marks, long dob, @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.marks = marks;
        this.dob = dob;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public long getDob() {
        return dob;
    }

    public void setDob(long dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
