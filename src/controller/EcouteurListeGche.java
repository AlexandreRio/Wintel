package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurListeGche extends MouseAdapter {

   private Wintel theWin;

   public EcouteurListeGche(Wintel monWin) {
      this.theWin = monWin;
   }

   /**
    *
    */
   public void mouseClicked (MouseEvent e) {
      String cle;

      JList maListe = theWin.getListeGche();
      int index = maListe.locationToIndex(e.getPoint());
      if(index >= 0) {
	 DefaultListModel tab = (DefaultListModel)(maListe.getModel());
	 cle = (String) tab.get(index);

	 Annuaire monA = theWin.getAnnuaire();
	 Fiche laFiche = monA.consulter(cle);

	 JTextField nom = theWin.getFieldNom();
	 nom.setText(laFiche.getNom());
	 JTextField prenom = theWin.getFieldPrenom();
	 prenom.setText(laFiche.getPrenom());
	 JTextField num = theWin.getFieldNumero();
	 num.setText(laFiche.getTelephone());
      }
   }

}
