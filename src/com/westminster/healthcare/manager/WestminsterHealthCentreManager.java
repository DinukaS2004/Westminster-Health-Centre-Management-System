package com.westminster.healthcare.manager;
import com.westminster.healthcare.model.StaffMember;
import com.westminster.healthcare.model.*;
import java.util.*;

public class WestminsterHealthCentreManager implements HealthCentreManager{
    private ArrayList <StaffMember> staffList;

    public WestminsterHealthCentreManager(){
        staffList = new ArrayList<>();
    }

    @Override
    public void addStaff(){
        System.out.println("Adding Staff");
    }
    @Override
    public void viewStaff(){
        for (StaffMember staff : staffList) {
            System.out.println(staff);
        }
    }
    @Override
    public void removeStaff(){
        System.out.println("Removing Staff");
    }

    public ArrayList <StaffMember> getStaffList(){
        return staffList;
    }

    // Week 5 testing
    public void addSampleStaff(StaffMember staff) {
        staffList.add(staff);
    }
}
