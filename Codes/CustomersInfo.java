public class CustomersInfo {
    private String name;
    private String date;
    private String shopName;
    static String status = "Normal";

    public CustomersInfo () {}
    public CustomersInfo (String name, String date, String shopName, String status) {
        this.name = name;
        this.date = date;
        this.shopName = shopName;
        CustomersInfo.status = status;
    }
    static String getStatus() {
        return status;
    }
    public static void setStatus(String status) {
        CustomersInfo.status = status;
    }
    public String toString() {
        return name + " " + date + " " + shopName + " " + status;
    }
    public String toTXTString() {
       return name + "," + date + "," + shopName + "," + status;
   }
}
