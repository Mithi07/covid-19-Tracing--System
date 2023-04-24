import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registration {     
    public static void Reg() throws IOException {
        ArrayList<Customer> customers = readCustomerFromFile();
        System.out.println ();

        Scanner input = new Scanner(System.in);
        System.out.print ("\t\t\t\t Enter your name : ");
        String name = input.nextLine();
        System.out.print ("\t\t\t\t Enter your phone number: ");
        String phone = input.nextLine(); 
        
        customers.add (new Customer(name,phone,"Normal"));
        System.out.println ();
        saveCustomerToFile (customers);
        System.out.println ("\t\t\t\t Registration completed!");
        System.out.println();
    }

    private static ArrayList<Customer> readCustomerFromFile() throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();

        // read customers.txt into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("customers.txt"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            // items[0] is name, items[1] is phone, items[2] is status
            customers.add (new Customer(items[0], items[1], items[2]));
        }
        return customers;
    }
    private static void saveCustomerToFile(ArrayList<Customer> customers) throws IOException {
        // read customers.txt into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            sb.append (customers.get(i).toTXTString() + "\n");
        }
        Files.write(Paths.get("customers.txt"), sb.toString().getBytes());
    }
}
