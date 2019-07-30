package views;

import controllers.Events;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import models.Donor;

public class WindowHospital extends JFrame {

    public static final Color HOSPITAL_COLOR = Color.decode("#bd0926");
    public static final String SING_UP = "Iniciar Sesión";
    public static final String SING_IN = "Registrarse";
    public static final String TITLE = "HOSPITAL DE DONACIÓN";
    private static final String ICON = "/data/Icon.png";
    private static final String BACKGROUND_IMAGE = "/data/Background.png";
    public static final Font FONT_HOSPITAL = new Font("Times New Roman", Font.BOLD, 29);

    private JButton jbSingIn;
    private JButton jbSingUp;
    private PanelContainer panelContainer;

    public WindowHospital(ActionListener controller) {
        setTitle(TITLE);
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBackground(Color.WHITE);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(BACKGROUND_IMAGE))));
        setLayout(new FlowLayout(FlowLayout.CENTER, 400, 0));

        jbSingIn = new JButton(SING_IN);
        jbSingIn.setFont(FONT_HOSPITAL);
        jbSingIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbSingIn.setBackground(HOSPITAL_COLOR);
        jbSingIn.setForeground(Color.WHITE);
        jbSingIn.addActionListener(controller);
        jbSingIn.setActionCommand(Events.SHOW_SING_IN.toString());
        add(jbSingIn, FlowLayout.LEFT);

        jbSingUp = new JButton(SING_UP);
        jbSingUp.setFont(FONT_HOSPITAL);
        jbSingUp.setForeground(HOSPITAL_COLOR);
        jbSingUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbSingUp.setBackground(Color.WHITE);
        jbSingUp.addActionListener(controller);
        jbSingUp.setActionCommand(Events.SHOW_SING_UP.toString());
        add(jbSingUp);

        panelContainer = new PanelContainer(controller);

        setVisible(Boolean.TRUE);
    }

    public void singUp() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());
        add(panelContainer);
        revalidate();
    }

    public void donate(ArrayList<Donor> donors) {
        panelContainer.donate(donors);
    }

    public void refreshStatus(String status) {
        panelContainer.refreshStatus(status);
    }

    public void showMessageQuantityIsRemoved() {
        panelContainer.showMessageQuantityIsRemoved();
    }

    public void showMessageQuantityNotIsRemoved() {
        panelContainer.showMessageQuantityNotIsRemoved();
    }
}