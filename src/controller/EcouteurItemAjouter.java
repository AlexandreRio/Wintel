package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurItemAjouter implements ActionListener {

   private Wintel theWin;

   public EcouteurItemAjouter(Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogAjouter wt = theWin.getWtDialogAjouter();
      wt.changeVisibility(true);
   }
}
