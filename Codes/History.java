import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class History extends CustomerSignIn {
    public static void Shop (String name, String search) throws IOException
    {  
        ArrayList<CustomersInfo> customersInfo = readInfoFromFile();
        Scanner input = new Scanner(System.in);
        LocalDateTime DateVisited = LocalDateTime.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm");
        String d = date.format(DateVisited);
        String stats = CustomersInfo.getStatus();

        try {
            System.out.println ("\t\t\t\t ***************");
            System.out.println ("\t\t\t\t * 1. Tesco    *");
            System.out.println ("\t\t\t\t * 2. Walmart  *");
            System.out.println ("\t\t\t\t * 3. Domino's *");
            System.out.println ("\t\t\t\t * 4. H & M    *");
            System.out.println ("\t\t\t\t ***************");
            System.out.print ("\t\t\t\t ");
            int choice = input.nextInt();
            System.out.println();
            if (choice == 1) {
                customersInfo.add(new CustomersInfo(name,d,"Tesco",stats));
                saveCustomersInfoToFile(customersInfo);
                printHistory(name);
            }
            else if (choice == 2) {
                customersInfo.add(new CustomersInfo(name,d,"Walmart",stats));
                saveCustomersInfoToFile(customersInfo);   
                printHistory(name);         
            }
            else if (choice == 3) {
                customersInfo.add(new CustomersInfo(name,d,"Domino's",stats));
                saveCustomersInfoToFile(customersInfo);
                printHistory(name);
            }
            else if (choice == 4) {
                customersInfo.add(new CustomersInfo(name,d,"H & M",stats));
                saveCustomersInfoToFile(customersInfo);
                printHistory(name);
            }
            else
                System.out.println ("\t\t\t\t Please check in to one of the shops listed.");
        }
        catch (InputMismatchException ex) {
            System.out.println ("\t\t\t\t Choice must be numbers only");
            System.out.println();
                Shop(name, search);
        }
    }

    private static ArrayList<CustomersInfo> readInfoFromFile() throws IOException {
        ArrayList<CustomersInfo> customersInfo = new ArrayList<>();
        // read customersinfo.txt into a list of lines.
        List<String> lines = Files.readAllLines(Paths.get("customersinfo.txt"));
        for (int i = 0; i < lines.size(); i++) {
            // split a line by comma
            String[] items = lines.get(i).split(",");
            // items[0] is name, items[1] is date, items[2] is shop, items[3] is status
            customersInfo.add (new CustomersInfo(items[0], items[1], items[2], items[3]));
        }
        return customersInfo;
    }

    private static void saveCustomersInfoToFile(ArrayList<CustomersInfo> customersInfo) throws IOException {
        // read customersinfo.txt into a list of lines.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customersInfo.size(); i++) {
            sb.append (customersInfo.get(i).toTXTString() + "\n");
        }
        Files.write(Paths.get("customersinfo.txt"), sb.toString().getBytes());
    }

    private static void printHistory(String name) {
        ArrayList<String> allHistory = new ArrayList<>();
        Scanner y;
        boolean find = false;
        String nameFromFile = "";
        String dateFromFile = "";
        String shopsFromFile = "";
        String statusFromFile = "";
        String records = "";
        try
        {
            y = new Scanner(new File("customersinfo.txt"));
            y.useDelimiter("[,\n]");

            while(y.hasNext())
            {
                nameFromFile = y.next();
                if (nameFromFile.equals(name))
                {
                    dateFromFile = y.next();
                    shopsFromFile = y.next();
                    statusFromFile = y.next();
                    records = dateFromFile + " " + shopsFromFile + " " + statusFromFile;
                    allHistory.add(records);
                    find = true;
                }
                else
                {
                    y.next();
                    y.next();
                    y.next();
                }
            }
            if(!find) 
                System.out.println ("\t\t\t\t No records found.");
        }
        catch (Exception ex)
        {
            System.out.print("\t\t\t\t Error. File not found.");
        }

        String[] array = new String[allHistory.size()];
        System.out.println("\t\t\t\t History viewed by a customer:");
        System.out.println("\t\t\t\t No Date       Time   Shop   Status");
        for (int i = 0; i < array.length; i++)
            System.out.println ("\t\t\t\t " + (i + 1) + "  " + allHistory.get(i));
    }
}
