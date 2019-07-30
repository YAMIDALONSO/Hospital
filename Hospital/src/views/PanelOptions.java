package views;

import controllers.Events;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static views.WindowHospital.FONT_HOSPITAL;
import static views.WindowHospital.HOSPITAL_COLOR;

public class PanelOptions extends JPanel {

    private static final String DONATE_ICON = "/data/Donate.png";
    private static final String REMOVE_ICON = "/data/Remove.png";
    private static final String AMOUNT_ICON = "/data/Amount.png";
    private static final String QUANTYTI_AMOUNT = "Cantidad restante";

    private static final int SIZE = 40;
    public static final String REMOVE_STATUS = "Estado del retiro";
    public static final String REMOVE = "Retirar";
    public static final String DONATE = "Donar";

    private JButton jbDonate;
    private JButton jbRemove;
    private JButton jbSeeRemainingAmount;
    private JLabel isPossibleRemove;
    private JLabel jlStatus;

    public PanelOptions(ActionListener controller) {
        setLayout(new GridLayout(6, 1, 0, 40));

        add(new JPanel());

        jbDonate = new JButton(DONATE);
        jbDonate.setFont(FONT_HOSPITAL);
        jbDonate.setForeground(Color.WHITE);
        jbDonate.setBackground(HOSPITAL_COLOR);
        jbDonate.setIcon(getIcon(DONATE_ICON));
        jbDonate.addActionListener(controller);
        jbDonate.setActionCommand(Events.SHOW_DIALOG_DONATE.toString());
        add(jbDonate);

        jbRemove = new JButton(REMOVE);
        jbRemove.setFont(FONT_HOSPITAL);
        jbRemove.setForeground(Color.WHITE);
        jbRemove.setBackground(HOSPITAL_COLOR);
        jbRemove.setIcon(getIcon(REMOVE_ICON));
        jbRemove.addActionListener(controller);
        jbRemove.setActionCommand(Events.SHOW_DIALOG_REMOVE.toString());
        add(jbRemove);

        jbSeeRemainingAmount = new JButton(QUANTYTI_AMOUNT);
        jbSeeRemainingAmount.setFont(FONT_HOSPITAL);
        jbSeeRemainingAmount.setForeground(Color.WHITE);
        jbSeeRemainingAmount.setBackground(HOSPITAL_COLOR);
        jbSeeRemainingAmount.setIcon(getIcon(AMOUNT_ICON));
        jbSeeRemainingAmount.addActionListener(controller);
        jbSeeRemainingAmount.setActionCommand(Events.SHOW_REMAINING_AMOUNT.toString());
        add(jbSeeRemainingAmount);

        isPossibleRemove = new JLabel(REMOVE_STATUS);
        isPossibleRemove.setFont(FONT_HOSPITAL);
        add(isPossibleRemove);

        jlStatus = new JLabel();
        jlStatus.setFont(FONT_HOSPITAL);
        add(jlStatus);
    }

    public ImageIcon getIcon(String icon) {
        Image iiNewSize = new ImageIcon(getClass().getResource(icon)).getImage();
        Image newPhoto = iiNewSize.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
        return new ImageIcon(newPhoto);
    }

    public void refreshStatus(String status) {
        jlStatus.setText(status);
    }

    public void showMessageQuantityIsRemoved() {
        isPossibleRemove.setText("Removida exitosamente");
    }

    public void showMessageQuantityNotIsRemoved() {
        isPossibleRemove.setForeground(HOSPITAL_COLOR);
        isPossibleRemove.setText("Imposible de remover");
    }
}