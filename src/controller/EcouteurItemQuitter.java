package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class EcouteurItemQuitter implements ActionListener {

   private Wintel theWin;

   public EcouteurItemQuitter( Wintel monWin) {
      this.theWin = monWin;
   }

   public void actionPerformed (ActionEvent e) {
      theWin.dispose();
   }

}
