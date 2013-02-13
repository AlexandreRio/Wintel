package ihm;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

import datas.*;
import controller.*;

public class Wintel extends JFrame {

   private JPanel panelNord;
   private JLabel labelAbonnes;
   private JLabel labelCaracteristiques;
   private JList maListe;
   private JPanel panelCaract;

   private JPanel panelCentre;
   private JLabel labelNom;
   private JTextField textFieldNom;
   private JLabel labelPrenom;
   private JTextField textFieldPrenom;
   private JLabel labelNumero;
   private JTextField textFieldNumero;
   private JButton buttonComposer;

   private JMenuBar myBar;
   private JMenu menuFichier;
   private JMenu menuAbonnes;
   private JMenu menuAide;
   private JMenuItem itemCharger;
   private JMenuItem itemSauver;
   private JMenuItem itemQuitter;
   private JMenuItem itemAjouter;
   private JMenuItem itemModifier;
   private JMenuItem itemSupprimer;
   private JMenuItem itemAide;

   private Annuaire monAnnuaire;
   private WtDialogAjouter dialogAj;
   private WtDialogModifier dialogMod;
   private WtDialogSupprimer dialogSup;

   public Wintel() {
      super("Wintel");
      this.creerInterface();
      this.attacherReactions();
      this.init();
      this.setSize(500,500);
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public void creerInterface() {
      this.setLayout(new BorderLayout());

      panelNord = new JPanel();
      this.add(panelNord, BorderLayout.NORTH);
      panelNord.setLayout(new GridLayout(1,2));
      labelAbonnes = new JLabel("Abonnes");
      labelCaracteristiques = new JLabel("Caractristiques");
      panelNord.add(labelAbonnes);
      panelNord.add(labelCaracteristiques);

      panelCentre = new JPanel();
      this.add(panelCentre, BorderLayout.CENTER);
      panelCentre.setLayout(new GridLayout(1,2,40,0));
      maListe = new JList();
      maListe.setModel(new DefaultListModel());
      panelCaract = new JPanel();
      panelCaract.setLayout(new GridLayout(0,1));
      panelCentre.add(maListe);
      panelCentre.add(panelCaract);

      labelNom = new JLabel("Nom");
      textFieldNom = new JTextField();
      labelPrenom = new JLabel("Prenom");
      textFieldPrenom = new JTextField();
      labelNumero = new JLabel("Numero");
      textFieldNumero = new JTextField();
      buttonComposer = new JButton("Composer");

      panelCaract.add(labelNom);
      panelCaract.add(textFieldNom);
      panelCaract.add(labelPrenom);
      panelCaract.add(textFieldPrenom);
      panelCaract.add(labelNumero);
      panelCaract.add(textFieldNumero);
      panelCaract.add(buttonComposer);

      myBar = new JMenuBar();
      menuFichier = new JMenu("Fichier");
      menuAbonnes = new JMenu("Abonnes");
      menuAide = new JMenu("Aide");
      myBar.add(menuFichier);
      myBar.add(menuAbonnes);
      myBar.add(menuAide);
      itemSauver = new JMenuItem("Sauver");
      itemCharger = new JMenuItem("Charger");
      itemQuitter = new JMenuItem("Quitter");
      itemAjouter = new JMenuItem("Ajouter");
      itemModifier = new JMenuItem("Modifier");
      itemSupprimer = new JMenuItem("Supprimer");
      itemAide = new JMenuItem("Aide");
      menuFichier.add(itemCharger);
      menuFichier.add(itemSauver);
      menuFichier.add(itemQuitter);
      menuAbonnes.add(itemAjouter);
      menuAbonnes.add(itemModifier);
      menuAbonnes.add(itemSupprimer);
      menuAide.add(itemAide);
      setJMenuBar(myBar);
   }

   /**
    * Add a new Abonne in the Annuaire
    * @param nom Name of the new Abonne, its also the unique key
    * @param prenom Surname of the new Abonne
    * @param numTel Phone number of the new Abonne
    */
   public void ajouterAbonne (String nom, String prenom, String numTel) {
      Fiche fiche = new Fiche(nom, prenom, numTel);
      try {
	 if(! this.monAnnuaire.exists(nom))
	    this.monAnnuaire.ajouter(nom, fiche);
      }
      catch( IllegalArgumentException e) {
	 e.printStackTrace();
      }
      catch (Exception e) {
	 e.printStackTrace();
      }
   }

   /**
    * Some access methods
    */

   /**
    * Access method
    * @return The field containing the surname
    */
   public JTextField getFieldNom() {
      return this.textFieldNom;
   }

   /**
    * Access method
    * @return The field containing the first name
    */
   public JTextField getFieldPrenom() {
      return this.textFieldPrenom;
   }

   /**
    * Access method
    * @return The field containing the phone number
    */

   /**
    * Access method
    * @return The List of the contacts
    */
   public JList getListeGche() {
      return this.maListe;
   }

   /**
    * Access method
    * @return The 'add contact' window
    */
   public WtDialogAjouter getWtDialogAjouter() {
      return this.dialogAj;
   }

   /**
    * Access method
    * @return The 'modify contact' window
    */
   public WtDialogModifier getWtDialogModifier() {
      return this.dialogMod;
   }

   /**
    * Access method
    * @return The 'modify contact' window
    */
   public WtDialogSupprimer getWtDialogSupprimer() {
      return this.dialogSup;
   }

   /**
    * Access method
    * @return The Annuaire containing all the contacts
    */
   public Annuaire getAnnuaire() {
      return this.monAnnuaire;
   }

   public JTextField getFieldNumero() {
      return this.textFieldNumero;
   }

   /**
    * Load and print the Annuaire in the JList
    */
   public void chargerEtAfficherAnnuaire() {
      monAnnuaire = datas.Annuaire.charger();
      DefaultListModel tab =(DefaultListModel)(maListe.getModel());
      tab.clear();
      Enumeration<String> keyList = monAnnuaire.cle();
      while (keyList.hasMoreElements()){
	 tab.addElement(keyList.nextElement());
      }

   }

   /**
    * Update the List with the Annuaire
    */
   public void afficherAnnuaire() {
      DefaultListModel tab =(DefaultListModel)(maListe.getModel());
      tab.clear();
      Enumeration<String> keyList = monAnnuaire.cle();
      while (keyList.hasMoreElements()){
	 tab.addElement(keyList.nextElement());
      }
   }

   /**
    * Initialize the Annuaire
    */
   private void init() {
      this.monAnnuaire = new Annuaire();
      this.dialogAj = new WtDialogAjouter(this);
      this.dialogMod = new WtDialogModifier(this);
      this.dialogSup = new WtDialogSupprimer(this);
   }

   private void attacherReactions() {
      maListe.addMouseListener(new EcouteurListeGche(this));

      itemSauver.addActionListener(new EcouteurItemSauver(this));
      itemCharger.addActionListener(new EcouteurItemCharger(this));
      itemQuitter.addActionListener(new EcouteurItemQuitter(this));

      itemAjouter.addActionListener(new EcouteurItemAjouter(this));
      itemModifier.addActionListener(new EcouteurItemModifier(this));
      itemSupprimer.addActionListener(new EcouteurItemSupprimer(this));

   }

   public static void main (String[] args) {
      Wintel w1 = new Wintel();
   }

}
