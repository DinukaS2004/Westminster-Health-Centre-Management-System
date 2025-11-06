package com.westminster.healthcare.model;

public class Receptionist extends StaffMember{

    private String deskNumber;
    private int hoursPerWeek;

    public Receptionist(String id, String name, String surName, String dob, String contactNo,String deskNumber, int hoursPerWeek) {

        super(id,name,surName,dob,contactNo);
        this.deskNumber=deskNumber;
        this.hoursPerWeek=hoursPerWeek;

    }
    public  String getDeskNumber() {
        return deskNumber;
    }
    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
    public void setDeskNumber(String deskNumber) {
        this.deskNumber = deskNumber;
    }

    @Override
    public String getRole() {
        return "Receptionist";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Desk: %s | Hours/Week: %d",
                deskNumber, hoursPerWeek);
    }
}
