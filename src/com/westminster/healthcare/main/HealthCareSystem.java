package com.westminster.healthcare.main;
import java.util.*;
import com.westminster.healthcare.manager.WestminsterHealthCentreManager;
import com.westminster.healthcare.model.Doctor;
import com.westminster.healthcare.model.Receptionist;
import com.westminster.healthcare.model.*;
import com.westminster.healthcentre.gui.StaffManagementGUI;

public class HealthCareSystem {
    public static void main(String args[]){

        WestminsterHealthCentreManager manager = new WestminsterHealthCentreManager();

        // You can still run console-based tests if needed
        // Now, launch the GUI
        javax.swing.SwingUtilities.invokeLater(() -> new StaffManagementGUI(manager));
//        while (true) {
//            System.out.println("\n=== Westminster Health Centre Management System ===");
//            System.out.println("1. Add New Staff Member");
//            System.out.println("2. Remove Staff Member");
//            System.out.println("3. View All Staff");
//            System.out.println("4. Search Staff by ID");
//            System.out.println("5. Sort Staff by Name");
//            System.out.println("6. Display Statistics");
//            System.out.println("0. Exit");
//            System.out.print("Enter your choice: ");
//
//            String choice = input.nextLine();
//
//            switch (choice) {
//                case "1": manager.addStaff(); break;
//                case "2": manager.removeStaff(); break;
//                case "3": manager.viewStaff(); break;
//                case "4":
//                    System.out.print("Enter staff ID to search: ");
//                    String id = input.nextLine();
//                    var staff = manager.searchById(id);
//                    System.out.println(staff != null ? staff : "No staff found!");
//                    break;
//                case "5": manager.sortByName(); break;
//                case "6": manager.displayStatistics(); break;
//                case "0":
//                    System.out.println("Exiting...");
//                    input.close();
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid choice! Please try again.");
//            }
//        }
    }

}
