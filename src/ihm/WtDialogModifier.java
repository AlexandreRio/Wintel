package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import datas.*;
import controller.*;

public class WtDialogModifier extends JDialog {

   private JPanel buttonPanel;
   private JPanel blankPanel;

   private JLabel textLabel;

   private JLabel nomLabel;
   private JLabel prenomLabel;
   private JLabel numeroLabel;

   private JTextField nomTextField;
   private JTextField prenomTextField;
   private JTextField numeroTextField;

   private JButton confirmerButton;
   private JButton annulerButton;

   public WtDialogModifier (Wintel theWin) {
      super(theWin, "Modifier un contact", true);
      this.creerInterface();
      this.attacherReactions();
      this.setSize(400,400);
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
      this.setLayout(new GridLayout(9,0));

      textLabel = new JLabel("Contact  à modifier (nom inchange)");

      nomLabel = new JLabel("Nom");
      nomTextField = new JTextField();
      prenomLabel = new JLabel("Prenom");
      prenomTextField = new JTextField();
      numeroLabel = new JLabel("Numero");
      numeroTextField = new JTextField();

      buttonPanel = new JPanel();

      confirmerButton = new JButton("Confirmer");
      annulerButton = new JButton("Annuler");

      this.add(textLabel);
      this.add(nomLabel);
      this.add(nomTextField);
      this.add(prenomLabel);
      this.add(prenomTextField);
      this.add(numeroLabel);
      this.add(numeroTextField);

      blankPanel = new JPanel();
      this.add(blankPanel);
      this.add(buttonPanel);

      buttonPanel.setLayout(new GridLayout(1,0));
      buttonPanel.add(confirmerButton);
      buttonPanel.add(annulerButton);
   }

   private void attacherReactions() {
      confirmerButton.addActionListener(new EcouteurConfirmerButtonMod((Wintel)this.getOwner()));
      annulerButton.addActionListener(new EcouteurAnnulerButtonMod((Wintel)this.getOwner()));
   }

   /**
    * Some access methods
    */

   /**
    * Access method
    * @return name field
    */
   public JTextField getNomTextField() {
      return this.nomTextField;
   }

   /**
    * Access method
    * @return surname field
    */
   public JTextField getPrenomTextField() {
      return this.prenomTextField;
   }

   /**
    * Access method
    * @return phone number field
    */
   public JTextField getNumeroTextField() {
      return this.numeroTextField;
   }

}
