/**
 * Cette classe specifie les donnes d'un correspondant telephonique
 * @see Serialized Form
 * @author Rio Alexandre
 * @version 1.0
 */

package datas;

import java.io.Serializable;

public class Fiche implements Serializable {

   /**
    * nom du correspondant
    */
   private String nom;

   /**
    * prenom du correspondant
    */
   private String prenom;

   /**
    * numero de telephone du correspondant
    */
   private String telephone;

   /**
    * leNom nom du correspondant
    * lePrenom prenom du correspondant
    * leTelephone numero de telephone du correspondant
    */
   public Fiche (String leNom, String lePrenom, String leTelephone) {
      this.nom = leNom;
      this.prenom = lePrenom;
      this.telephone = leTelephone;
   }

   /**
    * Accesseur
    * @return le nom du correspondant
    */
   public String getNom() {
      return this.nom;
   }

   /**
    * Accesseur
    * @return  le prenom du correspondant
    */
   public String getPrenom() {
      return this.prenom;
   }

   /**
    * Accesseur
    * @return le numero de telephone du correspondant
    */
   public String getTelephone() {
      return this.telephone;
   }

   /**
    * Renvoie une chaîne de caractères qui represente une fiche
    * @return une chaîne
    * @see Object#toString
    */
   public String toString() {
      String ret = "Prenom: " + this.prenom + "\nNom: " + this.nom
	 + " Numero: " + this.telephone;
      return ret;
   }

}
