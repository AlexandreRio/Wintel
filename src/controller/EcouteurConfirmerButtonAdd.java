package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import datas.*;
import ihm.*;

public class EcouteurConfirmerButtonAdd implements ActionListener {

   private Wintel theWin;

   public EcouteurConfirmerButtonAdd (Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogAjouter dialog = theWin.getWtDialogAjouter();
      JTextField nomField = dialog.getNomTextField();
      JTextField prenomField = dialog.getPrenomTextField();
      JTextField numeroField = dialog.getNumeroTextField();

      String nom = nomField.getText();
      String prenom = prenomField.getText();
      String numero = numeroField.getText();

      theWin.ajouterAbonne(nom, prenom, numero);
      theWin.afficherAnnuaire();
      dialog.changeVisibility(false);
   }

}
