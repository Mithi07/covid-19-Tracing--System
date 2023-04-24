import java.util.ArrayList;
import java.util.HashMap;

public class Flagging {
    static class Shop{
        public String name;
        public ArrayList<Log> visitors = new ArrayList<Log>();
        public String status = "Normal";
        public Shop(String name){
            this.name = name;
        }
        public void addVisitor(Log Visitor) {
            visitors.add(Visitor);
        }
        public void Flag(String flag, String date, int hour, int minute){
            this.status = flag;
            if(flag.equals("Case")){
                for(Log visit:visitors){
                    if(visit.date.equals(date)) {
                        //System.out.println(((visit.hour * 60 + visit.minute) - (hour * 60 + minute)));
                        if (((visit.hour * 60 + visit.minute) - (hour * 60 + minute) <= 60)) {
                            visit.customer.Flag("Close");
                        }
                    }
                }
            }
        }

        public String getStatus(){
            return this.status;
        }
    }

    static class Log{
        //public LocalDateTime visitTime;
        public String date;
        public int hour;
        public int minute;
        public Cust customer;
        public Shop shop;
        public Log(Shop shop, Cust customer, String date, int hour, int minute){
            this.date=date;
            this.hour=hour;
            this.minute=minute;
            this.customer = customer;
            this.shop = shop;
        }
    }

    static class Cust{
        public String name;
        public ArrayList<Log> visited = new ArrayList<Log>();
        public String status = "Normal";
        public Cust() {}
        public Cust(String name){
            this.name = name;
        }
        public void addVisit(Log visit){
            this.visited.add(visit);
        }

        public void Flag(String flag){
            this.status = flag;
            if(flag.equals("Case")){
                //for every visit made by this person
                for (Log visit:visited) {
                    visit.shop.Flag("Case", visit.date, visit.hour, visit.minute);
                }
            }
        }

        public String getStatus(){
            return this.status;
        }
    }

    public static void main(String[] args) {
        // we have 3 shops (Tesco, 99, 7Eleven);
        //we keep a map of the shops
        HashMap<String, Shop> map = new HashMap<String, Shop>();
        ArrayList<Shop> shops = new ArrayList<Shop>();
        shops.add(new Shop("Tesco"));
        shops.add(new Shop("Walmart"));
        shops.add(new Shop("7Eleven"));
        map.put("Tesco", shops.get(0));
        map.put("Walmart", shops.get(1));
        map.put("7Eleven", shops.get(2));

        //if we have 5 customers
        ArrayList<Cust> cust= new ArrayList<Cust>();
        cust.add(new Cust("Anirban"));
        cust.add(new Cust("Ramisa"));
        cust.add(new Cust("Shamiha"));
        cust.add(new Cust("WeiToo"));
        cust.add(new Cust("ManYi"));

        //customer 1 makes a visit to Tesco
        Log l1 = new Log(map.get("Tesco"), cust.get(0), "26-12-2020", 12, 34);

        map.get("Tesco").addVisitor(l1);
        cust.get(0).addVisit(l1);

       //customer 2 makes a visit to 99
        Log l2 = new Log(map.get("Walmart"), cust.get(1), "26-12-2020", 13, 15); 
        map.get("Walmart").addVisitor(l2);
        cust.get(1).addVisit(l2);

        //all others make a visit to tesco
        //customer 1 makes a visit to Tesco
        Log l3 = new Log(map.get("Tesco"), cust.get(2), "26-12-2020", 13, 15);
        Log l4 = new Log(map.get("Tesco"), cust.get(3), "26-12-2020", 13, 18);
        Log l5 = new Log(map.get("Tesco"), cust.get(4), "26-12-2020", 13, 58);
     
        map.get("Tesco").addVisitor(l3);
        cust.get(2).addVisit(l3);
        map.get("Tesco").addVisitor(l4);
        cust.get(3).addVisit(l4);
        map.get("Tesco").addVisitor(l5);
        cust.get(4).addVisit(l5);

        // flag customer 1
        cust.get(0).Flag("Case");
        //All the people who visited tesco within an hour will now get flagged.
        //customer 2 will not get flagged because she never visited tesco.
        //customer 5 will not get flagged because she visited tesco after one hour.

        System.out.println();
        System.out.println ("\t\t\t\t **************************************");
        System.out.println ("\t\t\t\t  List of Customer flagged by admin : ");
        for(Cust customer:cust) {
            System.out.println ("\t\t\t\t  Customer name :    Customer status : " );
            System.out.println ("\t\t\t\t  " + customer.name + "              " + customer.getStatus());
        }

        System.out.println ("\t\t\t\t --------------------------------------");

        System.out.println ("\t\t\t\t  List of Shops flagged by admin  : ");
        for(Shop shop:shops) {
            System.out.println ("\t\t\t\t  Shop name :    Shop status : " );
            System.out.println ("\t\t\t\t  " + shop.name + "          " + shop.getStatus());
        }
        System.out.println ("\t\t\t\t **************************************");
        System.out.println();
    }
}
