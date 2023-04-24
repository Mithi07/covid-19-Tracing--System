import java.io.File;
import java.util.Scanner;

public class ShopSignIn {
    public static void main(String[] args) 
    {
        String file = "shops.txt";

        Scanner input = new Scanner(System.in);
        System.out.print ("\t\t\t\t Please enter your shop name: ");
        String shopName = input.nextLine();

        String search = shopName;
        searchData(shopName,search,file);
        System.out.println();
    }

    public static void searchData(String shopName, String search, String file)
    {
        Scanner x;
        boolean found = false;
        String shopFromFile = "";
        String phoneFromFile = "";
        String managerFromFile = "";
        String statusFromFile = "";
        try
        {
            x = new Scanner(new File(file));
            x.useDelimiter("[,,,\n]");

            while(x.hasNext() && !found)
            {
                shopFromFile = x.next();
                phoneFromFile = x.next();
                managerFromFile = x.next();
                statusFromFile = x.next();
                if (shopFromFile.equals(search))
                    found = true;
            }
        }
        catch (Exception ex)
        {
            System.out.print("\t\t\t\t Error. File not found.");
        }

        if (found)
        {
            System.out.println ("\t\t\t\t History vieved by shop:");
            System.out.println ("\t\t\t\t Name     Phone      Manager  Status ");
            System.out.format ("\t\t\t\t " + shopFromFile + " "+ phoneFromFile + " "+ managerFromFile + "    "+ statusFromFile);
            System.out.println();
        }
        else
            System.out.println ("\t\t\t\t Shop not found.");
    }
}
