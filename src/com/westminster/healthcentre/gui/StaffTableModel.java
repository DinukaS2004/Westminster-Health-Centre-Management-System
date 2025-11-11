package com.westminster.healthcentre.gui;
import com.westminster.healthcare.model.*;
import javax.swing.table.AbstractTableModel; 
import java.util.ArrayList;

public class StaffTableModel extendes AbstractTableModel{
    private ArrayList<StaffMember> staffList;
    private final String [] columnNames = {"ID","Name","Surname","Role","DOB","Contact"};

    public void staffTableModel(ArrayList <StaffMember> staffList){
        this.staffList = staffList;
    }
    @Override
    public int getRowCount(){
        return staffList.size();
    }
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    @Override
    public Object getValueAt(int row, int col) {
        StaffMember staff = staffList.get(row);
        switch (col) {
            case 0: return staff.getId();
            case 1: return staff.getName();
            case 2: return staff.getSurname();
            case 3: return staff.getRole();
            case 4: return staff.getDob();
            case 5: return staff.getContactNo();
            default: return null;
        }
    }

    public void refresh() {
        fireTableDataChanged();
    }

    private void fireTableDataChanged() {
    }
}
