package views;

import controllers.Events;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import models.BloodType;
import static views.WindowHospital.FONT_HOSPITAL;
import static views.WindowHospital.HOSPITAL_COLOR;

public class DialogRestantAmount extends JDialog {

    private static final String CONSULT = "VER CANTIDAD RESTANTE";
    private static final String REGISTER_CATEGORY = "TIPO DE SANGRE";
    private static final String ADD_GAME = "CANTIDAD SEGUN TIPO DE SANGRE";

    private JLabel jlBloodType;
    private JComboBox jcbBloodType;
    private JButton jbSearch;
    private JLabel jlRestantAmount;

    public DialogRestantAmount(JFrame frame, ActionListener controller) {
        super(frame, true);
        setTitle(ADD_GAME);
        setSize(500, 400);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);

        jlBloodType = new JLabel(REGISTER_CATEGORY);
        jlBloodType.setFont(FONT_HOSPITAL);
        jlBloodType.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlBloodType);

        add(Box.createRigidArea(new Dimension(100, 25)));
        
        jcbBloodType = new JComboBox(BloodType.values());
        jcbBloodType.setFont(FONT_HOSPITAL);
        jcbBloodType.setForeground(HOSPITAL_COLOR);
        jcbBloodType.setBackground(Color.WHITE);
        jcbBloodType.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jcbBloodType);
        
        add(Box.createRigidArea(new Dimension(100, 25)));

        jlRestantAmount = new JLabel("Elija el tipo de sangre");
        jlRestantAmount.setFont(FONT_HOSPITAL);
        jlRestantAmount.setForeground(Color.WHITE);
        jlRestantAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlRestantAmount);

        jbSearch = new JButton(CONSULT);
        jbSearch.setFont(FONT_HOSPITAL);
        jbSearch.setForeground(Color.WHITE);
        jbSearch.setBackground(HOSPITAL_COLOR);
        jbSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbSearch.addActionListener(controller);
        jbSearch.setActionCommand(Events.REMAINING_AMOUNT.toString());
        add(jbSearch);
    }

    public BloodType getCategory() {
        return (BloodType) jcbBloodType.getSelectedItem();
    }

    public void showRestantAmount(int quantity) {
        jlRestantAmount.setText("Hay " + quantity + " litros de sangre restantes");
        jlRestantAmount.setForeground(HOSPITAL_COLOR);
    }
}