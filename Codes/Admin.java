import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);
        int choice;

        try {
            do{
                System.out.println ("\t\t\t\t ******************************************");
                System.out.println ("\t\t\t\t * 1. Customer History                    *"); 
                System.out.println ("\t\t\t\t * 2. Shop List                           *"); 
                System.out.println ("\t\t\t\t * 3. Master visit Hitory                 *"); 
                System.out.println ("\t\t\t\t * 4. List of Customers and Shops flagged *"); 
                System.out.println ("\t\t\t\t * 5. Exit                                *");
                System.out.println ("\t\t\t\t ******************************************");
                System.out.print ("\t\t\t\t ");
                choice = input.nextInt();
                System.out.println ();

                if (choice == 1)
                    CustomerList.main(null);
                else if (choice == 2)
                    ShopList.main(null);
                else if (choice == 3)
                    MasterVisit.main(null);
                else if (choice == 4)
                    Flagging.main(null);
                else if (choice == 5)
                    System.exit(0);
                else {
                        System.out.println ("\t\t\t\t Please choose 1, 2, 3, 4 or 5.");
                        System.out.println();
                        main(null);
                }
            }while(choice <= 5);
        }
        catch (InputMismatchException ex) {
            System.out.println ("\t\t\t\t Choice must be numbers only.");
            System.out.println();
            main(null);
        }  
    } 
}
