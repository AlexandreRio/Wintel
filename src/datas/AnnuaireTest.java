/**
 * Class test for Annuaire using junit
 * @author Rio Alexandre
 * @version 1.0
 */

package datas;

import org.junit.*;
import static org.junit.Assert.*;

public class AnnuaireTest {

   private Annuaire ann;

   @Before()
   public void setup() {
      ann = new Annuaire();
   }

   @Test()
   public void testSauver() {
      boolean success = true;
      System.out.println("test");
      try {
	 this.ann.sauver();
      }
      catch (Exception e) {
	 success = false;
	 e.getMessage();
      }
      Assert.assertTrue(success);
   }

   @Test()
   public void testAjouter() {
      boolean success = true;
      boolean failure = false;

      Fiche fiche = new Fiche("Nom1", "Prenom1", "001");
      try {
	 ann.ajouter("00", fiche);
      }
      catch( IllegalArgumentException e) {
	 e.getMessage();
	 System.out.println("IllegalArgumentException");
	 success = false;
      }
      catch (Exception e) {
	 e.getMessage();
	 System.out.println("Exception");
	 success = false;
      }
      Assert.assertTrue(success);

      //Try to re-add the same Fiche, this have to fail
      try {
	 ann.ajouter("00", fiche);
      }
      catch( IllegalArgumentException e) {
	 e.getMessage();
	 System.out.println("IllegalArgumentException");
	 failure = true;
      }
      catch (Exception e) {
	 e.getMessage();
	 System.out.println("Exception");
	 failure = true;
      }
      Assert.assertTrue(failure);
   }

   @Test()
   public void testModifier() {

   }

   @Test()
   public void testSupprimer() {

   }

   @Test()
   public void testCle() {

   }
}
