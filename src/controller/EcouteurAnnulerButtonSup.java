package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import datas.*;
import ihm.*;

public class EcouteurAnnulerButtonSup implements ActionListener {

   private Wintel theWin;

   public EcouteurAnnulerButtonSup (Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogSupprimer wt = theWin.getWtDialogSupprimer();
      wt.changeVisibility(false);

   }

}
