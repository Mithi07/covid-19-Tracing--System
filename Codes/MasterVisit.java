import java.io.File; // To read file
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class MasterVisit{
  public static void main(String[] args) {
    System.out.println("\t\t\t\t Master visit history:");
    System.out.println("\t\t\t\t No  Date        Time    Customer     Shop");
    try {
      File myObj = new File("randomvisits.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println("\t\t\t\t " + data);
        
      }
      myReader.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("\t\t\t\t An error occurred.");
      e.printStackTrace();
    }
    printlist();
  }

  private static void printlist() {
    ArrayList<String> Master = new ArrayList<>();
    Scanner y;
    String nameFromFile = "";
    String dateFromFile = "";
    String shopFromFile = "";
    String statusFromFile = "";
    String rec = "";
    try
    {
        y = new Scanner(new File("customersinfo.txt"));
        y.useDelimiter("[,\n]");

        while(y.hasNext())
        {
            nameFromFile = y.next();
            dateFromFile = y.next();
            shopFromFile = y.next();
            statusFromFile = y.next();
                rec = dateFromFile + "   " + nameFromFile + "       " + shopFromFile;
                Master.add(rec);
        }
    }
    catch (Exception ex)
    {
        System.out.print("\t\t\t\t Error. File not found.");
    }

    String[] arrays = new String[Master.size()];
    for (int i = 0; i < arrays.length; i++)
        System.out.println ("\t\t\t\t " + (i + 31) + "  " + Master.get(i));
    System.out.println();
}
}
