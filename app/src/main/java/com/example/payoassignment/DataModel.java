package com.example.payoassignment;

public class DataModel {
    private String first_name;
    private String last_name;
    private String avatar;
    private String email;

    public DataModel() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DataModel(String first_name, String last_name, String avatar, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
        this.email = email;
    }
}
