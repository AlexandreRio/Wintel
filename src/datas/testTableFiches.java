package datas;

import java.util.Hashtable;

public class testTableFiches {

   public static void main (String[] args) {
      Hashtable<String, Fiche> list = TableFiches.lireTableFiches();
      System.out.println(list.size());
   }

}
