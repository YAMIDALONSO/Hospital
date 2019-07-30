package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Donor;

public class PanelContainer extends JPanel {

    private PanelOptions panelOptions;    
    private PanelDonations panelDonations;
    
    public PanelContainer(ActionListener controller) {
        setLayout(new BorderLayout());
        setOpaque(true);
        
        panelOptions = new PanelOptions(controller);
        add(panelOptions,BorderLayout.CENTER);
        
        panelDonations = new PanelDonations();
        add(panelDonations,BorderLayout.LINE_END);
    }

    public void donate(ArrayList<Donor> donors) {
        panelDonations.setdata(donors);
    }

    public void refreshStatus(String status) {
        panelOptions.refreshStatus(status);
    }

    public void showMessageQuantityIsRemoved() {
        panelOptions.showMessageQuantityIsRemoved();
    }

    public void showMessageQuantityNotIsRemoved() {
        panelOptions.showMessageQuantityNotIsRemoved();
    }
}