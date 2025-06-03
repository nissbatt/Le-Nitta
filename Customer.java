public class Customer
{
    private String name;
    private String contact;
    private int tableNo;
    private char paymentMethod;
    private char membership;
    
    public Customer()
    {
        name = null;
        contact = null;
        tableNo = 0;
        paymentMethod = ' ';
        membership = ' ';
    }
    public Customer(String name, String contact, int tableNo, char paymentMethod, char membership)
    {
        this.name = name;
        this.contact = contact;
        this.tableNo = tableNo;
        this.paymentMethod = paymentMethod;
        this.membership = membership;
    }
    
    public String getName()
    {
        return name;
    }
    public String getContact()
    {
        return contact;
    }
    public int getTableNo()
    {
        return tableNo;
    }    
    public char getPaymentMethod()
    {
        return paymentMethod;
    }
    public char getMembership()
    {
        return membership;
    }
    
    public void setCustomer(String name, String contact, int tableNo, char paymentMethod, char membership)
    {
        this.name = name;
        this.contact = contact;
        this.tableNo = tableNo;
        this.paymentMethod = paymentMethod;
        this.membership = membership;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setContact(String contact)
    {
        this.contact = contact;
    }
    public void setTableNo(int tableNo)
    {
        this.tableNo = tableNo;
    }
    public void setPaymentMethod(char paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
    public void setMembership(char membership)
    {
        this.membership = membership;
    }
}
