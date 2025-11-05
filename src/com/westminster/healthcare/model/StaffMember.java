package com.westminster.healthcare.model;

public abstract class StaffMember {

    private int id;
    private String name;
    private String surName;
    private String dob;
    private String contactNo;

    public StaffMember(int id,String name,String surName,String dob, String contactNo){
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.dob = dob;
        this.contactNo = contactNo;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    public String getDob(){
        return dob;
    }
    public String getContactNo(){
        return contactNo;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurName(String surName){
        this.surName = surName;
    }
    public void setDob(String dob){
        this.dob = dob;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s %s | DOB: %s | Contact: %s | Role: %s",
                id, name, surName, dob, contactNo, getRole());
    }
}
