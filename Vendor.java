public class Vendor extends Customer
{
    private char type;
    private String staff;
    
    public Vendor()
    {
        super();
        this.type = ' ';
        this.staff = null;
    }
    
    public Vendor(char type, String staff, String n, String c, int tn, char pm, char m)
    {
        super(n, c, tn, pm, m);
        this.type = type;
        this.staff = staff;
    }
    
    public char getType()
    {
        return type;
    }
    public String getStaff()
    {
        return staff;
    }
    
    public void setVendor(char type, String staff, String n, String c, int tn, char pm, char m)
    {
        super.setCustomer(n, c, tn, pm, m);
        this.type = type;
        this.staff = staff;
    }
    public void setType(char type)
    {
        this.type = type;
    }
    public void setStaff(String staff)
    {
        this.staff = staff;
    }
    
    
    public String toString(){
        return("\nStaff in charge: " + staff+
               "\nTable no: "+super.getTableNo());
    }
}
