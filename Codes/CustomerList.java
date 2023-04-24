import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerList{
    public static void main(String[] args) 
    {
        System.out.println("\t\t\t\t List of customers viewed by admin:");
        System.out.println("\t\t\t\t No  Name         Phone          Status");
        try {
            File obj = new File("customerlist.txt");
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNextLine()) {
              String record = myReader.nextLine();
              System.out.println("\t\t\t\t " + record);
            }
            myReader.close();
          } 
          catch (FileNotFoundException e) {
            System.out.println("\t\t\t\t An error occurred.");
            e.printStackTrace();
          }
          print();
    }

    private static void print() {
      ArrayList<String> allCust = new ArrayList<>();
      Scanner y;
      String nameFromFile = "";
      String phoneFromFile = "";
      String statusFromFile = "";
      String rec = "";
      try
      {
          y = new Scanner(new File("customers.txt"));
          y.useDelimiter("[,\n]");

          while(y.hasNext())
          {
              nameFromFile = y.next();
              phoneFromFile = y.next();
              statusFromFile = y.next();
                  rec = nameFromFile + "       " + phoneFromFile + "     " + statusFromFile;
                  allCust.add(rec);
          }
      }
      catch (Exception ex)
      {
          System.out.print("\t\t\t\t Error. File not found.");
      }

      String[] arrays = new String[allCust.size()];
      for (int i = 0; i < arrays.length; i++)
          System.out.println ("\t\t\t\t " + (i + 31) + "  " + allCust.get(i));
      System.out.println();
  }
}
