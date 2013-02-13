package datas;

import java.util.Hashtable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import java.io.IOException;
import java.io.EOFException;

public class TableFiches {

   /**
    * Gets all the Fiche in the file table.bin
    * @return All the Fiche in a Hashtable
    */
   public static Hashtable<String, Fiche> lireTableFiches() {
      Hashtable<String, Fiche> listFiche = new Hashtable<String, Fiche>();
      String file = "data/files/table.bin";
      Fiche tmpFiche;
      try {
	 FileInputStream out = new FileInputStream(file);
	 ObjectInputStream flux = new ObjectInputStream(out);
	 while (true) {
	    tmpFiche = (Fiche)flux.readObject();
	    listFiche.put(tmpFiche.getNom(), tmpFiche);
	 }
      }
      catch (IOException e) {
      }
      catch (ClassNotFoundException e) {
	 e.printStackTrace();
      }
      catch (Exception e) {
	 e.printStackTrace();
      }
      return listFiche;
   }
}
