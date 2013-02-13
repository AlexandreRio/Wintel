package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurAnnulerButtonAdd implements ActionListener {

   private Wintel theWin;

   public EcouteurAnnulerButtonAdd (Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogAjouter wt = theWin.getWtDialogAjouter();
      wt.changeVisibility(false);
   }
}
