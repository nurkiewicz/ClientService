package com.ofg.clients.model;

public class Client {

    String firstName;

    String lastName;

    Integer age;

    String loanId;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
}
