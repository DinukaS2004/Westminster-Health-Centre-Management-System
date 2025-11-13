package com.westminster.healthcentre.gui;
import com.westminster.healthcare.manager.*;
import com.westminster.healthcare.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class StaffManagementGUI extends JFrame{

    private WestminsterHealthCentreManager manager;
    private JTable staffTable;
    private StaffTableModel tableModel;

    public StaffManagementGUI(WestminsterHealthCentreManager manager){

        this.manager = manager;
        setTitle("Westminster Health Centre Management System");
        setSize(900,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // === Table ===
        tableModel = new StaffTableModel(manager.getStaffList());
        staffTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(staffTable);
        add(scrollPane, BorderLayout.CENTER);

        // === Buttons ===
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton addButton = new JButton("Add Staff");
        JButton removeButton = new JButton("Remove Staff");
        JButton statsButton = new JButton("Show Statistics");
        JButton refreshButton = new JButton("Refresh");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(statsButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);


        addButton.addActionListener(this::onAdd);
        removeButton.addActionListener(this::onRemove);
        statsButton.addActionListener(this::onStats);
        refreshButton.addActionListener(e -> tableModel.refresh());
        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
    private void onAdd(ActionEvent e) {
        JOptionPane.showMessageDialog(this,
                "Add staff feature will be implemented in Week 8.",
                "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onRemove(ActionEvent e) {
        int row = staffTable.getSelectedRow();
        if (row >= 0) {
            String id = (String) tableModel.getValueAt(row, 0);
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Remove staff with ID " + id + "?",
                    "Confirm Removal", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                manager.getStaffList().remove(row);
                tableModel.refresh();
                JOptionPane.showMessageDialog(this, "Staff removed successfully!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a staff member first!");
        }
    }

    private void onStats(ActionEvent e) {
        ArrayList<StaffMember> list = manager.getStaffList();
        long doctors = list.stream().filter(s -> s instanceof Doctor).count();
        long receptionists = list.stream().filter(s -> s instanceof Receptionist).count();

        JOptionPane.showMessageDialog(this,
                "Total Staff: " + list.size() +
                        "\nDoctors: " + doctors +
                        "\nReceptionists: " + receptionists,
                "Statistics", JOptionPane.INFORMATION_MESSAGE);
    }
}
