package datas;

public class testAnnuaire {

   public static void main (String[] args) {
      Annuaire ann = new Annuaire();
      Fiche fiche1 = new Fiche("Nom1", "Prenom1", "001");
      Fiche fiche2 = new Fiche("Nom2", "Prenom1", "001");
      Fiche fiche3 = new Fiche("Nom3", "Prenom1", "001");
      Fiche fiche4 = new Fiche("Nom4", "Prenom1", "001");

      try {
	 ann.ajouter("00", fiche1);
	 ann.ajouter("01", fiche2);
	 ann.ajouter("02", fiche3);
	 ann.ajouter("03", fiche4);
      }
      catch( IllegalArgumentException e) {
	 e.getMessage();
	 System.out.println("IllegalArgumentException");
      }
      catch (Exception e) {
	 System.out.println("Exception");
	 e.getMessage();
      }
      ann.sauver();
   }
}
