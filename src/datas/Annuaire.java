/**
 * Cette classe definit un annuaire telephonique comme une table de fiches
 * ( au sens BDD). Chaque fiche est ajoutee à l'aide d'une cle (unique)
 * de type  String. En plus des operations classiques sur une table, l'annuaire
 * peut être sauvegarde sur le disque. Cet annuaire doit donc être
 * serialisable.
 * @see Serialized Form
 * @author Rio Alexandre
 * @version 1.0
 */

package datas;

import datas.Fiche;

import java.util.Hashtable;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.util.Enumeration;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Annuaire implements Serializable {

   /**
    * La collection (de type table) contenant toutes les fihces.
    */
   private Hashtable<String, Fiche> tabFiches;

   /**
    * Creation de la collection. Au depart elle est vide.
    */
   public Annuaire() {
      this.tabFiches = new Hashtable<String, Fiche>();
   }

   /**
    * Methode repsonsable de l'ecriture de l'objet Annuaire courant(this) dans
    * un fichier "annuaire.out" (nom impose).
    */
   public void sauver() {
      String file = "data/files/annuaire.out";
      try {
	 FileOutputStream out = new FileOutputStream(file);
	 ObjectOutputStream flux = new ObjectOutputStream(out);

	 flux.writeObject(this);
      }
      catch(java.io.IOException e) {
	 e.printStackTrace();
      }
   }

   /**
    * Methode statique blabla
    * @return l'objet Annuaire cree à partir des donnees du fichier
    * "annuaire.out".
    */
   public static Annuaire charger() {
      String file = "data/files/annuaire.out";
      Annuaire returnAnnuaire = null;
      try {
	 FileInputStream out = new FileInputStream(file);
	 ObjectInputStream flux = new ObjectInputStream(out);

	 returnAnnuaire = (Annuaire) flux.readObject();
      }
      catch(IOException e) {
	 e.printStackTrace();
      }
      catch(ClassNotFoundException e) {
	 e.printStackTrace();
      }
      finally {
	 return returnAnnuaire;
      }
   }


   /**
    * Ajoute à l'annuaire une fiche dont on fournit egalement la cle; Il faut
    * verifier que la cle n'existe pas dejà dans l'annuaire avant d'ajouter;
    * @param cle cle d'identification (unique) de la fiche
    * @param personne fiche rajoutee dans la collection
    * @throws java.lang.IllegalArgumentException si un ou plusieurs arguments
    * parmi cle ou personne ne sont pas valies (i.e null)
    * @throws java.lang.Exception si la cle existe dejà dans l'annuaire (ajout
    * impossible)
    */
   public void ajouter(String cle, Fiche personne) throws java.lang.IllegalArgumentException, java.lang.Exception {
      if (! (cle == null || personne == null) ) {
	 Fiche retTmp;
	 if (tabFiches.get(cle) == null) {
	    //System.out.println(tabFiches.size());
	    retTmp = tabFiches.put(cle, personne);
	    //System.out.println(tabFiches.size());
	 }
	 else
	    throw new Exception("This key already exists.");
      }
      else
	 throw new IllegalArgumentException("You can't add null references.");

   }

   /**
    * Permet de supprimer une entree de l'annuaire à partir de sa cle
    * @param cle cle d'identification(unique) de la fiche
    * @throws java.lang.IllegalArgumentException si la cle n'est pas valide
    * (i.e. null)
    * @throws java.util.NoSuchElementException si la cle n'existe pas dans
    * l'annuaire (suppression impossible)
    */
   public void supprimer(String cle) throws java.lang.IllegalArgumentException, java.util.NoSuchElementException {
      if (cle != null) {
	 if (tabFiches.remove(cle) == null)
	    throw new NoSuchElementException("Nothing to removed.");
      }
      else
	 throw new IllegalArgumentException("You can't remove from a null key.");
   }

   /**
    * Permet de modifier une entree de l'annuaire à partir de sa cle
    * @param cle cle d'identification (unique) de la fiche
    * @param personne nouvelle fiche qui remplace l'ancienne
    * @throws java.lang.IllegalArgumentException si la cle n'est pas valide
    * (i.e. null)
    * @throws java.util.NoSuchElementException si la cle n'existe pas dans
    * l'annuaire (suppression impossible)
    */
   public void modifier(String cle, Fiche personne) throws java.lang.IllegalArgumentException, java.util.NoSuchElementException {
      Fiche oldFiche;
      if(cle != null) {
	 oldFiche = tabFiches.get(cle);
	 if (oldFiche != null) {
	    oldFiche = tabFiches.put(cle, personne);
	 }
	 else
	    throw new NoSuchElementException("The old Fiche doesn't exist.");
      }
      else
	 throw new IllegalArgumentException("You can't use a null key.");
   }

   /**
    * Renvoie l'ensemble des cles contenues dans la collection.
    * @return l'ensenble des cles
    */
   public Enumeration<String> cle() {
      return tabFiches.keys();
   }

   /**
    * Renvoie vrai si la fiche correspond à la cle dans la collection.
    * @param cle cle d'identification (unique) de la fiche
    * @return true si la fiche existe
    */
   public boolean exists(String cle) {
      boolean ret = false;
      ret = tabFiches.containsKey(cle);
      return ret;
   }

   /**
    * Renvoie le nombre total de fiches de la collection.
    * @return le nombre de fiches.
    */
   public int taille() {
      return tabFiches.size();
   }

   /**
    * Renvoie la fiche correspondat à une cle;
    * @param cle cle d'identification (unique) de la fiche.
    * @return la fiche correspondant à la cle passee en paramètre ou null si la
    * cle n'existe pas dans l'annuaire
    * @throws IllegalArgumentException si la cle n'est pas valide (i.e. null)
    */
   public Fiche consulter (String cle) throws IllegalArgumentException {
      Fiche returnFiche = null;
      if (cle != null) {
	 returnFiche = tabFiches.get(cle);
      }
      else
	 throw new IllegalArgumentException("Can't get the Fiche, null reference given.");
      return returnFiche;
   }
}
