import java.text.DecimalFormat;

public class Order extends Customer
{
    private String id;
    DecimalFormat df = new DecimalFormat("0.00");
    
    public Order()
    {
        super();
        id = null;
    }
    public Order(String id, String n, String c, int tn, char pm, char m)
    {
        super(n, c, tn, pm, m);
        this.id = id;
    }
    
    public String getID()
    {
        return id;
    }
    public char getMem()
    {
        return super.getMembership();
    }
    
    public void setOrder(String id, String n, String c, int tn, char pm, char m)
    {
        super.setCustomer(n, c, tn, pm, m);
        this.id = id;
    }
    public void setMem(char membership)
    {
        super.setMembership(membership);
    }
    public void setCustomer(String n, String c, int tn, char pm, char m)
    {
        super.setCustomer(n, c, tn, pm, m);
    }
    public void setID(String id)
    {
        this.id = id;
    }
    
    public double discount(double price)
    {
        double discount = 0.0;
        if (price >= 20.0 && price < 50.0)
            discount = price * 0.03;
        else if (price >= 50.0 && price < 100.0)
            discount = price * 0.05;
        else if (price >= 100.0 && price < 150.0)
            discount = price * 0.1;
        else if (price >= 150)
            discount = price * 0.2;
        
        double Ewallet = 0.0;
        if (super.getPaymentMethod() == 'E' || super.getPaymentMethod() == 'e'){
            Ewallet = price * 0.03;
        }
        
        double mem = 0.0;
        if (super.getMembership() == 'Y' || super.getMembership() == 'y')
            mem = price * 0.04;
            
        discount = Ewallet + discount + mem;
        
        return discount;
    }
    
    public double tax(double price){
        double tax = 0.0;
        
        tax = price * 0.06;
        
        return tax;
    }
    
    public double overallTotal(double price)
    {
        double total = price - discount(price) + tax(price);
        return total;
    }
    
    public double balance(double cash, double price)
    {
        double balance = 0.0;
        
        if (super.getPaymentMethod() == 'C' || super.getPaymentMethod() == 'c')
            balance = cash - overallTotal(price);
            
        return balance;
    }
    
    public String method()
    {
        String method = null;
        
        if (super.getPaymentMethod() == 'C' || super.getPaymentMethod() == 'c')
            method = "Cash";
        else if(super.getPaymentMethod() == 'E' || super.getPaymentMethod() == 'e')
            method = "E-wallet";
            
        return method;
    }
    
    public void displayReceipt()
    {
        System.out.println("\n  =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(" |      L E ' N I T T A  F O O D C O U R T       |");
        System.out.println("  =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("\nORDER #"+ id +" FOR " + super.getName());
        System.out.println("Customer's contact: " + super.getContact());
        System.out.println("----------------------------------------------------");
        System.out.println("QTY"+"\tFOOD CODE"+"\tFOOD NAME"+"\t\tFOOD PRICE");
    }
    
    public void displayReceipt2(double cash, double price)
    {
        System.out.println("----------------------------------------------------");
        System.out.print("\nPayment method: " + method());
        System.out.print("\nSub total: RM" + df.format(price));
        System.out.print("\nTotal discount: RM" + df.format(discount(price)));
        System.out.print("\nTax: RM" + df.format(tax(price)));
        System.out.print("\nTotal: RM" + df.format(overallTotal(price)));
        System.out.print("\n");
        
        if (super.getPaymentMethod() == 'C' || super.getPaymentMethod() == 'c')
        {
            System.out.println("\nTotal Amount given: RM" + df.format(cash));
            System.out.print("\nBalance: RM" + df.format(balance(cash, price)));
        }
    }
}

