package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import datas.*;
import ihm.*;

public class EcouteurConfirmerButtonMod implements ActionListener {

   private Wintel theWin;

   public EcouteurConfirmerButtonMod (Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogModifier wt = theWin.getWtDialogModifier();
      Annuaire annuaire = theWin.getAnnuaire();

      JTextField keyField = wt.getNomTextField();
      String key = keyField.getText();

      if (annuaire.exists(key)) {
	 JTextField prenomField = wt.getPrenomTextField();
	 String prenom = prenomField.getText();
	 JTextField numeroField = wt.getNumeroTextField();
	 String numero = numeroField.getText();

	 Fiche newFiche = new Fiche (key, prenom, numero);

	 annuaire.modifier(key, newFiche);

	 theWin.afficherAnnuaire();

	 wt.changeVisibility(false);
      }
      else {
	 //Ici on peut afficher un pop-up d'erreur
      }

   }

}
