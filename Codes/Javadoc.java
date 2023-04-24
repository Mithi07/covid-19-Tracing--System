/**
 * Represents customer registration name, phone and their status where all are String.
 */
public class Javadoc {
    private String name;
    private String phone;
    private String CStatus;
  
  /** 
   * Constructs customer name, customer phone and customer status and set to null.
   */
  public Javadoc() {}
  
  /** 
   * Constructs a customer with the specified name, phone and status.
   *
   * @param name the name of customer
   * @param phone the phone of customer
   * @param CStatus the status of customer
   */
  public Javadoc(String name, String phone, String CStatus) {
    this.name = name;
    this.phone = phone;
    this.CStatus = CStatus;
  }

  /** 
   * Returns a String with name, phone and status.
   * @return (name, phone, CStatus)
   */   
    public String toString() {
        return name + " " + phone + " " + CStatus;
    }

    /** 
   * Returns a comma delimited String to a text file.
   * @return (name, phone, CSatus)
   */   
    public String toTXTString() {
        return name + "," + phone + "," + CStatus;
    }
}