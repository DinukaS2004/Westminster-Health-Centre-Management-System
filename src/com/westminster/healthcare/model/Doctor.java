package com.westminster.healthcare.model;

public class Doctor extends StaffMember {

    private String licenceNumber;
    private String specialisation;
    private int consultationsPerWeek;

    public Doctor(String id,String name,String surName,String dob,String contactNo, String licenceNumber,String specialisation,int consultationsPerWeek) {
        super(id,name,surName,dob,contactNo);
        this.licenceNumber=licenceNumber;
        this.specialisation=specialisation;
        this.consultationsPerWeek=consultationsPerWeek;
    }

    public String getLicenceNumber(){
        return licenceNumber;
    }
    public String getSpecialisation(){
        return specialisation;
    }
    public int getConsultationsPerWeek(){
        return consultationsPerWeek;
    }

    public void setLicenceNumber(String licenceNumber){
        this.licenceNumber=licenceNumber;
    }
    public void setSpecialisation(String specialisation){
        this.specialisation=specialisation;
    }
    public void setConsultationsPerWeek(int consultationsPerWeek){
        this.consultationsPerWeek=consultationsPerWeek;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Licence: %s | Specialisation: %s | Consultations: %d",
                licenceNumber, specialisation, consultationsPerWeek);
    }
}
