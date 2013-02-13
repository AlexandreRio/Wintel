package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurItemSauver implements ActionListener {

   private Wintel theWin;

   public EcouteurItemSauver(Wintel monWin) {
      this.theWin = monWin;
   }

   /**
    *
    */
   public void actionPerformed (ActionEvent e) {
      Annuaire theAnnuaire = theWin.getAnnuaire();
      theAnnuaire.sauver();
   }
}
