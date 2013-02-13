package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.NoSuchElementException;

import datas.*;
import ihm.*;

public class EcouteurConfirmerButtonSup implements ActionListener {

   private Wintel theWin;

   public EcouteurConfirmerButtonSup (Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogSupprimer wt = theWin.getWtDialogSupprimer();
      JTextField nomField = wt.getNomTextField();
      String nom = nomField.getText();
      Annuaire annuaire = theWin.getAnnuaire();

      try {
	 annuaire.supprimer(nom);
      }
      catch(NoSuchElementException ex) {
	 System.out.println("No such element");
	 //pop-up erreur
      }
      catch(IllegalArgumentException ex) {
      }
      theWin.afficherAnnuaire();
      wt.changeVisibility(false);

   }

}
