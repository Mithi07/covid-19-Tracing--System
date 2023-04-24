import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactTracing
{
    public static void main (String[] args) 
    {
        Scanner input = new Scanner (System.in);
        int option;
        try {
            do {
                System.out.println();
                System.out.println ("\t\t\t\t ***************************************");
                System.out.println ("\t\t\t\t * CONTACT TRACING SYSTEM FOR COVID-19 *");
                System.out.println ("\t\t\t\t * 1. Admin                            *");
                System.out.println ("\t\t\t\t * 2. Shop                             *");
                System.out.println ("\t\t\t\t * 3. Customer                         *");
                System.out.println ("\t\t\t\t ***************************************");
                System.out.print ("\t\t\t\t ");
                option = input.nextInt();
                System.out.println ();

                if (option == 1) {
                    Admin.main(null);
                }
                else if (option == 2) 
                    shopChoice();
                else if (option == 3) 
                    Choice();
                else {
                    System.out.println ("\t\t\t\t Please choose 1, 2 or 3.");
                    System.out.println();
                    main(null);
                }
            }while(option <= 3);
        }
        catch (InputMismatchException ex) {
            System.out.println ("\t\t\t\t Choice must be numbers only.");
            System.out.println();
            main(null);
        }  
    }

    public static void Choice () {
        Scanner input = new Scanner (System.in);
        int choice;
        try {
            do {
                System.out.println ("\t\t\t\t ****************************************************************");
                System.out.println ("\t\t\t\t * Please register first if you have not registered. Thank You. *");
                System.out.println ("\t\t\t\t * 1. Registration                                              *");
                System.out.println ("\t\t\t\t * 2. Sign In                                                   *");
                System.out.println ("\t\t\t\t * 3. Exit                                                      *");
                System.out.println ("\t\t\t\t ****************************************************************");
                System.out.print ("\t\t\t\t ");
                choice = input.nextInt();
                System.out.println ();

                if (choice == 1)
                {
                    try {
                        Registration.Reg();
                    }
                    catch (Exception ex) {
                    }
                }
                else if (choice == 2)
                {
                    try {
                        CustomerSignIn.CustSignIn();
                        System.out.println ();
                    }
                    catch (Exception ex) {
                    }
                }
                else if (choice == 3)
                    System.exit(0);
                else {
                    System.out.println ("\t\t\t\t Please choose 1, 2 or 3.");
                    System.out.println();
                    Choice();
                }

            }while(choice <= 3);
        }
        catch (InputMismatchException ex) {
            System.out.println ("\t\t\t\t Choice must be numbers only.");
            System.out.println();
            Choice();
        } 
    }

    public static void shopChoice () {
        Scanner input = new Scanner (System.in);
        int choices;
        try {
            do {
                System.out.println ("\t\t\t\t **************");
                System.out.println ("\t\t\t\t * 1. Sign In *");
                System.out.println ("\t\t\t\t * 2. Exit    *");
                System.out.println ("\t\t\t\t **************");
                System.out.print ("\t\t\t\t ");
                choices = input.nextInt();
                System.out.println ();

                if (choices == 1) 
                    ShopSignIn.main(null);
                else if (choices == 2) 
                    System.exit(0);
                else {
                    System.out.println ("\t\t\t\t Please choose 1 or 2.");
                    System.out.println();
                    shopChoice();
                }
            }while(choices <= 2);
        }
        catch (InputMismatchException ex) {
            System.out.println ("\t\t\t\t Choice must be numbers only.");
            System.out.println();
            shopChoice();
        } 
    }
}