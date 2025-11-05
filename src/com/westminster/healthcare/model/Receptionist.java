package com.westminster.healthcare.model;

public class Receptionist extends StaffMember{

    private String deskNumber;
    private String hoursPerWeek;

    public Receptionist(int id, String name, String surName, String dob, String contactNo) {

        super(id,name,surName,dob,contactNo);
        this.deskNumber=deskNumber;
        this.hoursPerWeek=hoursPerWeek;

    }
    public  String getDeskNumber() {
        return deskNumber;
    }
    public String getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(String hoursPerWeek) {
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
