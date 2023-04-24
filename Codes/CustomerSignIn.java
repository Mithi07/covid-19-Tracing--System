import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CustomerSignIn
{
    public static void CustSignIn() throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\t\t\t\t Please enter your name: ");
        String name = input.nextLine();

        String search = name;
        searchData(name,search);
    }

    public static void searchData(String name, String search) throws IOException
    {
        Scanner x;
        boolean found = false;
        String nameFromFile = "";
        String phoneFromFile = "";
        String statusFromFile = "";
        try
        {
            x = new Scanner(new File("customers.txt"));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found)
            {
                nameFromFile = x.next();
                phoneFromFile = x.next();
                statusFromFile = x.next();
                if (nameFromFile.equals(search))
                    found = true;
            }
        }
        catch (Exception ex)
        {
            System.out.print("\t\t\t\t Error. File not found.");
        }
        
        if (found)
        {
            System.out.println("\t\t\t\t Please check in.");
            History.Shop(name,search);
        }
        else
            System.out.println("\t\t\t\t Please register first. Thank you.");
    }
}
