package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurItemCharger implements ActionListener {

   private Wintel theWin;

   public EcouteurItemCharger (Wintel monWin) {
      this.theWin = monWin;
   }

   /**
    *
    */
   public void actionPerformed (ActionEvent e) {
      theWin.chargerEtAfficherAnnuaire();
   }

}
