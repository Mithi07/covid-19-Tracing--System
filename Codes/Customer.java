public class Customer {
    private String name;
    private String phone;
    private String CStatus;
    public Customer() {}
    public Customer(String name, String phone, String CStatus) {
        this.name = name;
        this.phone = phone;
        this.CStatus = CStatus;
    }
    public String toString() {
        return name + " " + phone + " " + CStatus;
    }
    public String toTXTString() {
       return name + "," + phone + "," + CStatus;
   }
}
