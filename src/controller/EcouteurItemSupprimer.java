package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurItemSupprimer implements ActionListener {

   private Wintel theWin;

   public EcouteurItemSupprimer (Wintel monWin) {
      this.theWin = monWin;
   }

   /**
    *
    */
   public void actionPerformed (ActionEvent e) {
      WtDialogSupprimer wt = theWin.getWtDialogSupprimer();
      wt.changeVisibility(true);
   }

}
