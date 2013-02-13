package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurItemModifier implements ActionListener {

   private Wintel theWin;

   public EcouteurItemModifier (Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      WtDialogModifier wt = theWin.getWtDialogModifier();
      wt.changeVisibility(true);
   }

}
