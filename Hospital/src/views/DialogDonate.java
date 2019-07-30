package views;

import controllers.Events;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import models.BloodType;
import static views.DialogGeneralSing.NICK;
import static views.PanelOptions.DONATE;
import static views.WindowHospital.FONT_HOSPITAL;
import static views.WindowHospital.HOSPITAL_COLOR;

public class DialogDonate extends JDialog{
    
    public static final String QUANTITY = "Cantidad";
    private static final String BLOOD_TYPE = "Tipo de sangre";
    private static final String TITLE = "Gracias Por Donar";
    
    private JLabel jlName;
    private JTextField jtfName;
    private JLabel jlBloodType;
    private JComboBox<BloodType> jcbBloodType;
    private JLabel jlQuantity;
    private JSpinner jsQuantity;
    private JButton jbDonate;

    public DialogDonate(JFrame frame, ActionListener controller) {
        super(frame, true);
        setTitle(TITLE);
        setSize(500, 400);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);
        
        jlName = new JLabel(NICK);
        jlName.setFont(FONT_HOSPITAL);
        jlName.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlName);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jtfName = new JTextField();
        jtfName.setFont(FONT_HOSPITAL);
        jtfName.setAlignmentX(Component.CENTER_ALIGNMENT);
        jtfName.setForeground(HOSPITAL_COLOR);
        add(jtfName);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jlBloodType = new JLabel(BLOOD_TYPE);
        jlBloodType.setFont(FONT_HOSPITAL);
        jlBloodType.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlBloodType);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jcbBloodType = new JComboBox<>(BloodType.values());
        jcbBloodType.setFont(FONT_HOSPITAL);
        jcbBloodType.setAlignmentX(Component.CENTER_ALIGNMENT);
        jcbBloodType.setBackground(HOSPITAL_COLOR);
        jcbBloodType.setForeground(Color.WHITE);
        add(jcbBloodType);

        add(Box.createRigidArea(new Dimension(100, 25)));
        
        jlQuantity = new JLabel(QUANTITY);
        jlQuantity.setFont(FONT_HOSPITAL);
        jlQuantity.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlQuantity);
        
        jsQuantity = new JSpinner();
        jsQuantity.setFont(FONT_HOSPITAL);
        jsQuantity.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jsQuantity);

        jbDonate = new JButton(DONATE);
        jbDonate.setFont(FONT_HOSPITAL);
        jbDonate.setForeground(HOSPITAL_COLOR);
        jbDonate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbDonate.setBackground(Color.WHITE);
        jbDonate.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbDonate.addActionListener(controller);
        jbDonate.setActionCommand(Events.DONATE.toString());
        add(jbDonate);
    }   

    public String getNameDonor() {
        return jtfName.getText();
    }
    public BloodType getBloodTypeDonor() {
        return (BloodType) jcbBloodType.getSelectedItem();
    }
    public int getQuantityDonor() {
        return (int) jsQuantity.getValue();
    }
}