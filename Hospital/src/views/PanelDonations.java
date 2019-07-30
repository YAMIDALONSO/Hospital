package views;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Donor;

public class PanelDonations extends JPanel {

    private static final String [] COLUMN_NAMES = {"NOMBRE DEL DONANTE","TIPO DE SANGRE","CANTIDAD"};
    
    private JTable jtDonations;
    private DefaultTableModel modelDonations;

    public PanelDonations() {
        modelDonations = new DefaultTableModel(null,COLUMN_NAMES);
        jtDonations = new JTable(modelDonations);
        add(new JScrollPane(jtDonations));
    }
    
    public void setdata(ArrayList<Donor> donors){
        modelDonations.setDataVector(null, COLUMN_NAMES);
        for (Donor donor : donors) {
            Object[] data = new Object[3];
            data[0] = donor.getName();
            data[1] = donor.getBloodType().getName();
            data[2] = donor.getQuantity();
            modelDonations.addRow(data);
        }
    }
}