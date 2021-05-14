package com.example.tpgit_miniblog;

public class DataModal {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String batch;
    private String department;

    public DataModal(String firstname, String lastname, String email, String password, String batch, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.batch = batch;
        this.department = department;
    }

    public String getFName() {
        return firstname;
    }

    public void setFName(String firstname) {
        this.firstname = firstname;
    }

    public String getLName() {
        return lastname;
    }

    public void setLName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}


