package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import datas.*;
import controller.*;

public class WtDialogSupprimer extends JDialog {

   private JLabel textLabel;
   private JTextField textField;
   private JButton confirmerButton;
   private JButton annulerButton;

   private JPanel buttonPanel;
   private JPanel blankPanel;

   public WtDialogSupprimer (Wintel theWin) {
      super(theWin, "Supprimer");
      this.creerInterface();
      this.attacherReactions();
      this.setSize(300,300);
      this.setVisible(false);
   }

   /**
    * Change the visibility of the window
    * @param visible True makes the window visible
    */
   public void changeVisibility (boolean visible) {
      this.setVisible(visible);
   }


   private void creerInterface() {
      this.setLayout(new BorderLayout());
      this.setLayout(new GridLayout(4, 0));
      buttonPanel = new JPanel();
      blankPanel = new JPanel();

      textLabel = new JLabel("Supprimer le contact ?");
      textField = new JTextField();

      confirmerButton = new JButton("Confirmer");
      annulerButton = new JButton("Annuler");

      this.add(textLabel);
      this.add(textField);
      this.add(blankPanel);
      this.add(buttonPanel);


      buttonPanel.setLayout(new FlowLayout());
      buttonPanel.add(confirmerButton);
      buttonPanel.add(annulerButton);


   }

   /**
    * Access method
    * @return name field
    */
   public JTextField getNomTextField() {
      return this.textField;
   }

   private void attacherReactions() {
      confirmerButton.addActionListener(new EcouteurConfirmerButtonSup((Wintel)this.getOwner()));
      annulerButton.addActionListener(new EcouteurAnnulerButtonSup((Wintel)this.getOwner()));
   }

}
