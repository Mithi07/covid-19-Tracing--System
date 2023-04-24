public class ShopList {
    public static void main(String[] args)
    { 
        String[] shops ={"7Eleven","Isetan","Cmart","Ecoshop","Checkers","Parkson","Tesco","Walmart","Domino's","H & M"};
        String[] phone ={" 0183994858","  0385958677","   0983375399"," 0385958877","0983375388",
                         " 0286463673","   5123456987"," 2455476965","3423423534","  7865582343"} ;
        String Status ="Normal";
        String[] manager={ "Siti  ","Pria  ","Tina  ","Polin ","Mina  ","Riana ","Jack  ","Dream ","Pewds ","Charlie"};
        System.out.println("\t\t\t\t List of the Shops viewed by admin :");
        System.out.println("\t\t\t\t No   Name       Phone       Manager   Status");
        for(int i=0; i<10; i++) 
            System.out.println ("\t\t\t\t " + (i+1) + "    " + shops[i] + "   " + phone[i] + "  " + manager[i] + "    " + Status);
        System.out.println();
    }
}
