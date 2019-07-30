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
import models.BloodType;
import static views.DialogDonate.QUANTITY;
import static views.PanelOptions.REMOVE;
import static views.WindowHospital.FONT_HOSPITAL;
import static views.WindowHospital.HOSPITAL_COLOR;
import static views.WindowHospital.TITLE;

public class DialogRemoveBlood extends JDialog {

    private JComboBox<BloodType> jcbBloodType;
    private JLabel jlQuantity;
    private JSpinner jsQuantity;
    private JButton jbDonate;

    public DialogRemoveBlood(JFrame frame,ActionListener controller) {
        super(frame, true);
        setTitle(TITLE);
        setSize(500, 400);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);

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

        jbDonate = new JButton(REMOVE);
        jbDonate.setFont(FONT_HOSPITAL);
        jbDonate.setForeground(HOSPITAL_COLOR);
        jbDonate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbDonate.setBackground(Color.WHITE);
        jbDonate.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbDonate.addActionListener(controller);
        jbDonate.setActionCommand(Events.REMOVE.toString());
        add(jbDonate);
    }

    public BloodType getBloodType() {
        return (BloodType) jcbBloodType.getSelectedItem();
    }

    public int getQuantityToRemove() {
        return (int) jsQuantity.getValue();
    }
}