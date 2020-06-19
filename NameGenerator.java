// Callum McCubbin
// le epic name gen'rator

import java.util.*;

public class NameGenerator {

   public static void main(String[] args) {
   
   
      Scanner console = new Scanner(System.in);
      Random rand = new Random();
      boolean wb = false;

      String[] index = resetIndex(console);
      
      int key = 1;
      while (key != 0) {
         giveMenu(wb);
         
         key = console.nextInt();
         
         if (key == 1) {
            index = extendIndex(console, index);
         } else if (key == 2) {
            generateNames(console, index, rand, wb);
         } else if (key == 3) {
            if (wb == false) {
               wb = true;
            } else {
               wb = false;
            }
         } else if (key == 4) {
            index = resetIndex(console);
         } else if (key == 5) {
            index = addCarz(index);
         }
      }
      
      // This prints the index. For debugging.
      
      //      for(int i = 0; i <= 26; i++) {
      //   System.out.println(index[i]);   
      //}           
   }
   
   public static String[] addCarz(String[] index) {
   
      String[] carz = {"Ford",
                          "Toyota",
                          "Mercedes",
                          "Chevrolet",
                          "Subaru",
                          "Jeep",
                          "Buick",
                          "Mclaren",
                          "Honda",
                          "Nissan",
                          "Acura",
                          "Audi",
                          "Tesla",
                          "Cadillac",
                          "Mazda",
                          "Volkswagen",
                          "Volvo",
                          "Porsche",
                          "Suzuki",
                          "Chrysler",
                          "Maserati",
                          "Ferrari",
                          "Fiat",
                          "Bugatti"
                          };
      index = addSet(index, carz);
      return index;
   }
   
   // Adds an array of strings set.
   public static String[] addSet(String[] index, String[] set) {
   
      for (int i = 0; i < set.length; i++) {
         set[i] = set[i].toLowerCase();
         index = addIndex(index, set[i]);
      }
      return index;      
   }
   
   public static void generateNames(Scanner console, String[] index, Random rand, boolean wb) {
   
      int count = 1;
      while (count != 0) {
      
         System.out.print("How many names would you like to generate? (0 to end) ");   
         count = console.nextInt();
         for(int i = 1; i <= count; i++) {
         
            String name = getName(rand, index, wb);
            System.out.println(name);
         }
      }
   }
   
   public static void giveMenu(boolean wb) {
      System.out.println("Press 1 to add data");
      System.out.println("Press 2 to generate names");
      if (wb == true) {
      System.out.println("Press 3 to disable worldbuilding");
      } else {
      System.out.println("Press 3 to enable worldbuilding");
      }
      System.out.println("Press 4 to reset the index");
      System.out.println("Press 5 to add the default index (carz).");
      System.out.println("Press 0 to exit");
      }
   
   // method assembles the index
   public static String[] resetIndex(Scanner console) {
   
      String[] index = new String[27];
      //resets the index to ACTUALLY nothing
      for(int i = 0; i <= 26; i++) {
         index[i] = "";   
      
      }
      return index;
   }
   
   public static String[] extendIndex(Scanner console, String[] index) {
   
      String data = "";
      while(data.startsWith("/") == false) {
         System.out.print("Enter data instance (/ to end): ");
         data = console.next();
         data = data.toLowerCase();
         if(data.startsWith("/") == false) {
            index = addIndex(index, data);
         }
      }
         
      return index;
   }
   
   // Adds the string data to the index.
   public static String[] addIndex(String[] index, String data) {
   
      data = data += ' ';

      index[0] = index[0] += data.charAt(0);
      
      int pos = 1;
      char val = data.charAt(pos - 1);
      
      while(val != ' ') {
      
         index[val - 96] = index[val - 96] += data.charAt(pos);
         pos++;
         val = data.charAt(pos - 1);
      }
      
      return index;
   
   }
   
   // Will get a name from the index
   public static String getName(Random rand, String[] index, boolean wb) {
   
      String name = "";
      char currentLetter = pickLetter(rand, index, '`');
      name += currentLetter;
      
      while(currentLetter != ' ') {
         currentLetter =  pickLetter(rand, index, currentLetter);
         
         if(wb == true && rand.nextInt(5) == 0 && currentLetter != ' ') {
         
         name += "'";
         }
         
         name += currentLetter;
         
      }
      return name;
   }
   
   // will pick a letter given a letter from the index
   public static char pickLetter(Random rand, String[] index, char input) {
   
      String row = index[input - 96];
      char letter = row.charAt(rand.nextInt(row.length()));
      return letter;
   }
}

