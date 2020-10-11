package com.example.payoassignment;

public class usersModel {
    public String firstName;
    public String userid;
    public String email;
    public String phone;
    public String address;
    public String lastName;

    public usersModel(String firstName, String userid, String email, String phone, String address, String lastName) {
        this.firstName = firstName;
        this.userid = userid;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public usersModel() {
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


}
