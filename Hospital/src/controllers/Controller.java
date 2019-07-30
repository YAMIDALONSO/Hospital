package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import models.Donor;
import models.HospitalApp;
import persistence.FileManager;
import views.DialogDonate;
import views.DialogGeneralSing;
import views.DialogRemoveBlood;
import views.DialogRestantAmount;
import views.WindowHospital;
import static views.WindowHospital.SING_IN;
import static views.WindowHospital.SING_UP;

public class Controller implements ActionListener {

    private HospitalApp hospitalApp;
    private WindowHospital windowHospital;
    private DialogGeneralSing dialogGeneralSing;
    private DialogDonate dialogDonate;
    private FileManager fileManager;
    private DialogRestantAmount dialogRestantAmount;
    private DialogRemoveBlood dialogRemoveBlood;

    public Controller() {
        fileManager = new FileManager();
        try {
            hospitalApp = new HospitalApp(fileManager.readUsers(),fileManager.readDonors());
        } catch (IOException ex) {
            System.err.println("No se pudo cargar el archivo");
        }
        windowHospital = new WindowHospital(this);
        dialogGeneralSing = new DialogGeneralSing(windowHospital, this);
        dialogDonate = new DialogDonate(windowHospital, this);
        dialogRestantAmount = new DialogRestantAmount(windowHospital, this);
        dialogRemoveBlood = new DialogRemoveBlood(windowHospital, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())) {
            case SHOW_SING_IN:
                showSingIn();
                break;
            case SHOW_SING_UP:
                showSingUp();
                break;
            case SING_IN:
                singIn();
                break;
            case SING_UP:
                singUp();
                break;
            case SHOW_DIALOG_DONATE:
                showDialogDonor();
                break;
            case DONATE:
                donate();
                break;
            case SHOW_REMAINING_AMOUNT:
                showRemainingAmount();
                break;
            case REMAINING_AMOUNT:
                remainingAmount();
                break;
            case SHOW_DIALOG_REMOVE:
                showDialogRemove();
                break;
            case REMOVE:
                remove();
        }
    }

    private void showSingIn() {
        dialogGeneralSing.setButtonProperties(SING_IN, Events.SING_IN.toString());
        dialogGeneralSing.setVisible(true);
    }

    private void showSingUp() {
        dialogGeneralSing.setButtonProperties(SING_UP, Events.SING_UP.toString());
        dialogGeneralSing.setVisible(true);
    }

    private void singIn() {
        try {
            hospitalApp.addUser(HospitalApp.createUser(dialogGeneralSing.getNick(), dialogGeneralSing.getPassword()));
            dialogGeneralSing.setVisible(false);
            fileManager.writeUser(hospitalApp.getUsers());
        } catch (IOException ex) {
            System.err.println("No pudimos encontrar el archivo");
        }
    }

    private void singUp() {
        if (hospitalApp.isUserAndPasword(dialogGeneralSing.getNick(), dialogGeneralSing.getPassword())) {
            try {
                windowHospital.singUp();
                dialogGeneralSing.setVisible(false);
                windowHospital.donate(fileManager.readDonors());
                windowHospital.refreshStatus(hospitalApp.getStatus());
            } catch (IOException ex) {
                System.err.println("No Encontramos el Archivo");
            }
        } else {
            dialogGeneralSing.showErrorData();
        }
    }

    private void showDialogDonor() {
        dialogDonate.setVisible(true);
    }

    private void donate() {
        Donor donor = hospitalApp.createDonor(dialogDonate.getNameDonor(), dialogDonate.getBloodTypeDonor(), dialogDonate.getQuantityDonor());
        hospitalApp.addDonor(donor);
        windowHospital.donate(hospitalApp.getDonors());
        try {
            fileManager.writeDonor(hospitalApp.getDonors());
        } catch (IOException ex) {
            System.out.println("No se encontro el archivo");
        }
        dialogDonate.setVisible(false);
    }

    private void showRemainingAmount() {
        dialogRestantAmount.setVisible(true);
    }

    private void remainingAmount() {
        int restantAmount = hospitalApp.consultRestantAmount(dialogRestantAmount.getCategory());
        dialogRestantAmount.showRestantAmount(restantAmount);
    }

    private void showDialogRemove() {
        dialogRemoveBlood.setVisible(Boolean.TRUE);
    }

    private void remove() {
        if(hospitalApp.removeBlood(dialogRemoveBlood.getBloodType(), dialogRemoveBlood.getQuantityToRemove())){
            windowHospital.showMessageQuantityIsRemoved();
        }else{
            windowHospital.showMessageQuantityNotIsRemoved();
        }
        dialogDonate.setVisible(false);
    }
}