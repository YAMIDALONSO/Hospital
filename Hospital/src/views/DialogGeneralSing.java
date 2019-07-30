package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import static views.WindowHospital.FONT_HOSPITAL;
import static views.WindowHospital.HOSPITAL_COLOR;
import static views.WindowHospital.TITLE;

public class DialogGeneralSing extends JDialog {

    private static final String USER_AND_PASSWORD = "Ingrese Su Usuario y Contraseña";
    private static final String PASSWORD = "Contraseña";
    public static final String NICK = "Nombre o Usuario";

    private JButton jbGeneralSing;
    private JLabel jlNick;
    private JTextField jtfNick;
    private JLabel jlPassword;
    private JPasswordField jpfPassword;
    private JLabel jlData;

    public DialogGeneralSing(JFrame frame, ActionListener controller) {
        super(frame, true);
        setTitle(TITLE);
        setSize(500, 400);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);

        jlData = new JLabel(USER_AND_PASSWORD);
        jlData.setFont(FONT_HOSPITAL);
        jlData.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlData);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jlNick = new JLabel(NICK);
        jlNick.setFont(FONT_HOSPITAL);
        jlNick.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlNick);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jtfNick = new JTextField();
        jtfNick.setFont(FONT_HOSPITAL);
        jtfNick.setAlignmentX(Component.CENTER_ALIGNMENT);
        jtfNick.setForeground(HOSPITAL_COLOR);
        jtfNick.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 40, 0, 40, Color.WHITE), BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED)));
        add(jtfNick);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jlPassword = new JLabel(PASSWORD);
        jlPassword.setFont(FONT_HOSPITAL);
        jlPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(jlPassword);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jpfPassword = new JPasswordField();
        jpfPassword.setFont(FONT_HOSPITAL);
        jpfPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpfPassword.setForeground(HOSPITAL_COLOR);
        add(jpfPassword);

        add(Box.createRigidArea(new Dimension(100, 25)));

        jbGeneralSing = new JButton();
        jbGeneralSing.setFont(FONT_HOSPITAL);
        jbGeneralSing.setForeground(HOSPITAL_COLOR);
        jbGeneralSing.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbGeneralSing.setBackground(Color.WHITE);
        jbGeneralSing.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbGeneralSing.addActionListener(controller);
        add(jbGeneralSing);
    }

    public void setButtonProperties(String text, String actionComand) {
        jbGeneralSing.setText(text);
        jbGeneralSing.setActionCommand(actionComand);
        cleanData();
    }

    private void cleanData() {
        jtfNick.setText("");
        jpfPassword.setText("");
    }

    public String getNick() {
        return jtfNick.getText();
    }

    public String getPassword() {
        return Arrays.toString(jpfPassword.getPassword());
    }

    public void showErrorData() {
        jlData.setText("Usuario o Contraseña Incorrectos");
        jlData.setForeground(HOSPITAL_COLOR);
    }
}
