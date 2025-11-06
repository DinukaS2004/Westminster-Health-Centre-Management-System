package com.westminster.healthcare.main;

import com.westminster.healthcare.manager.WestminsterHealthCentreManager;
import com.westminster.healthcare.model.Doctor;
import com.westminster.healthcare.model.Receptionist;

public class HealthCareSystem {
    public static void main(String args[]){

        WestminsterHealthCentreManager manager = new WestminsterHealthCentreManager();

        Doctor d1 = new Doctor("D001", "John", "Smith", "1978-09-12", "1234567890",
                "ML12345", "Cardiology", 15);

        Receptionist r1 = new Receptionist("R001", "Alice", "Brown", "1985-02-18",
                "0987654321", "Desk-03", 40);

        manager.addStaff(d1);
        manager.addStaff(r1);

        manager.viewStaff();
    }

}
