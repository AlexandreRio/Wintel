package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurComboBox implements ItemListener {

   private Wintel theWin;

   public EcouteurComboBox (Wintel monWin) {
      theWin = monWin;
   }

   public void itemStateChanged(ItemEvent e) {
      WtDialogAjouter dialog = theWin.getWtDialogAjouter();
      JTextField nom = dialog.getNomTextField();
      JTextField prenom = dialog.getPrenomTextField();
      JTextField numero = dialog.getNumeroTextField();

      JComboBox comboBox = dialog.getComboBox();

      String contactKey = (String) comboBox.getSelectedItem();

      Fiche contactFiche = dialog.getTable().get(contactKey);

      nom.setText(contactFiche.getNom());
      prenom.setText(contactFiche.getPrenom());
      numero.setText(contactFiche.getTelephone());

   }
}
