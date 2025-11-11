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
        System.out.println("===Remove Staff === ");
        System.out.println();
        System.out.print("Enter staff ID to remove : ");
        String id = input.nextLine().trim();

        StaffMember staff = searchById(id);

        if(staff != null){
            System.out.println("Fouond : "+staff);
            System.out.println();
            System.out.print("Are you want to remove this staff ? (Y/N) : ");
            String confirm = input.nextLine().trim();

            if(confirm.equalsIgnoreCase("Y")){
                staffList.remove(staff);
                System.out.println("Staff removed successfully!");
            }else{
                System.out.println("Remove cancelled!");
            }
        }else{
            System.out.println("Staff not found!");
        }
    }

    public ArrayList <StaffMember> getStaffList(){
        return staffList;
    }

    public void sortByName(){
        staffList.sort(Comparator.comparing(StaffMember::getSurName).thenComparing(StaffMember::getName));
        System.out.println("Staff list sorted by surname and name");
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
    public void displayStatistics(){
        long doctors = staffList.stream().filter(s->s instanceof Doctor).count();
        long receptionists = staffList.stream().filter(s->s instanceof Receptionist).count();

        System.out.println("\n=== Statistics ===");
        System.out.println("Total Staff: " + staffList.size());
        System.out.println("Doctors: " + doctors);
        System.out.println("Receptionists: " + receptionists);
    }

    public void exit() {
        System.out.println("Exiting program...");
        input.close();
        System.exit(0);
    }

}
