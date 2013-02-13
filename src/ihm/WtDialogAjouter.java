package ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import datas.*;
import controller.*;

public class WtDialogAjouter extends JDialog {

   private JPanel buttonPanel;
   private JPanel blankPanel;

   private JLabel textLabel;
   private JComboBox comboBox;

   private JLabel nomLabel;
   private JLabel prenomLabel;
   private JLabel numeroLabel;

   private JTextField nomTextField;
   private JTextField prenomTextField;
   private JTextField numeroTextField;

   private JButton confirmerButton;
   private JButton annulerButton;

   private Hashtable<String, Fiche> table;

   public WtDialogAjouter(Wintel theWin) {
      super (theWin, "Ajouter un nouveau contact", true);
      this.table = TableFiches.lireTableFiches();
      this.creerInterface();
      this.attacherReactions();
      this.setSize(400,400);
      this.setVisible(false);
   }

   /**
    * Change the visibility of the window
    * @param visible True makes the window visible
    */
   public void changeVisibility(boolean visible) {
      if(visible) {
	 String contactKey = (String) comboBox.getSelectedItem();
	 Fiche contactFiche = table.get(contactKey);

	 nomTextField.setText(contactFiche.getNom());
	 prenomTextField.setText(contactFiche.getPrenom());
	 numeroTextField.setText(contactFiche.getTelephone());

      }
      this.setVisible(visible);
   }

   private void creerInterface() {
      this.setLayout(new BorderLayout());
      this.setLayout(new GridLayout(10,0));

      textLabel = new JLabel("Veuillez choisir un nouveau contact dans la liste");
      Vector<String> nameVector = new Vector<String>();
      for (Enumeration<String> e = table.keys(); e.hasMoreElements();) {
	 nameVector.addElement(e.nextElement());
      }
      comboBox = new JComboBox(nameVector);

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
      this.add(comboBox);
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

   /**
    * Some access methods
    */

   /**
    * Access method
    * @return name text field
    */
   public JTextField getNomTextField () {
      return this.nomTextField;
   }

   /**
    * Access method
    * @return first name text field
    */
   public JTextField getPrenomTextField () {
      return this.prenomTextField;
   }

   /**
    * Access method
    * @return phone number text field
    */
   public JTextField getNumeroTextField () {
      return this.numeroTextField;
   }

   /**
    * Access method
    * @return combo box of the names of the contacts
    */
   public JComboBox getComboBox () {
      return this.comboBox;
   }

   /**
    * Access methods
    * @return Contact's hashtable of the binary file
    */
   public Hashtable<String, Fiche> getTable () {
      return this.table;
   }

   private void attacherReactions() {
      comboBox.addItemListener(new EcouteurComboBox((Wintel) this.getOwner()));
      annulerButton.addActionListener(new EcouteurAnnulerButtonAdd((Wintel) this.getOwner()));
      confirmerButton.addActionListener(new EcouteurConfirmerButtonAdd((Wintel) this.getOwner()));
   }

}
