package com.westminster.healthcare.manager;
import com.westminster.healthcare.model.StaffMember;
import com.westminster.healthcare.model.*;
import java.util.*;

public class WestminsterHealthCentreManager implements HealthCentreManager{

    private ArrayList <StaffMember> staffList;
    Scanner input = new Scanner(System.in);

    public WestminsterHealthCentreManager(){
        staffList = new ArrayList<>();
    }

    // ADD STAFF
    @Override
    public void addStaff(){

        System.out.print("Enter staff type (Doctor/Receptionist) : ");
        String staffType = input.nextLine().trim();

        System.out.print("Enter staff name ID : ");
        String id =  input.nextLine().trim();

        //Prevent duplicates
        if(searchById(id)!= null){
            System.out.println("Staff member with this ID already exists");
            return;
        }

        System.out.print("Enter name : ");
        String name = input.nextLine().trim();

        System.out.print("Enter surname : ");
        String surname = input.nextLine().trim();

        System.out.print("Enter the date of birth (YYYY-MM-DD) : ");
        String dob = input.nextLine().trim();

        System.out.print("Enter contact number : ");
        String contactNo = input.nextLine().trim();

        if(staffType.equalsIgnoreCase("Doctor")){

            System.out.print("Enter licence number : ");
            String licenceNumber = input.nextLine().trim();

            System.out.print("Enter specialisation : ");
            String specialisation = input.nextLine().trim();

            System.out.print("Enter consultations per week : ");
            int consultationsPerWeek = input.nextInt();

            Doctor doctor = new Doctor(id,name,surname,dob,contactNo,licenceNumber,specialisation,consultationsPerWeek);
            staffList.add(doctor);
            System.out.println("✅ Doctor added successfully!");

        }else if(staffType.equalsIgnoreCase("Receptionist")){

            System.out.print("Enter desk number: ");
            String desk = input.nextLine().trim();

            System.out.print("Enter hours per week: ");
            int hours = Integer.parseInt(input.nextLine().trim());

            Receptionist receptionist = new Receptionist(id, name, surname, dob, contactNo, desk, hours);
            staffList.add(receptionist);
            System.out.println("✅ Receptionist added successfully!");

        } else {
            System.out.println("❌ Invalid staff type.");
        }
    }
    @Override
    public void viewStaff(){

        if(staffList.isEmpty()){
            System.out.println("No staff records found");
            return;
        }

        System.out.println("=== Staff Members ===");
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

    //Search By ID
    public StaffMember searchById(String id) {
        for (StaffMember staff : staffList) {
            if(staff.getId().equalsIgnoreCase(id)){
                return staff;
            }
        }
        return null;
    }
}
