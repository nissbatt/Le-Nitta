import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java. text. DecimalFormat;

public class FoodCourtApp
{
    public static void main (String[] args)throws IOException
    {
        //variable declaration
        String foodCode, staffVendor, idOrder = null, contactCustomer = null, response;
        char payMetCustomer = ' ', membership = ' ', Fcode = ' ';
        int size, tableNoCustomer = 0, custCount = 0, orderSize = 0, quantity, custNum;
        double cash = 0.0, overall = 0.0;
        
        //object declaration
        Order orderObj = new Order();
        Vendor vendorObj = new Vendor();
        
        DecimalFormat df = new DecimalFormat(".00");
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        
        //input
        FileReader fr = new FileReader("Order.txt");
        BufferedReader br = new BufferedReader(fr);
        //output
        FileWriter fw = new FileWriter("Report.txt");
        PrintWriter pw = new PrintWriter(fw);
        
        //dialog box
        JOptionPane.showMessageDialog(null,"Hi, Welcome to Le' Nitta!","Le' Nitta Food Court",1);
        JOptionPane.showMessageDialog(null,"Before you enter the program, please fill in the following information on Order.txt: \n\nOrder id \nCustomer's contact \nTable number","Le' Nitta Food Court",1);
        response = JOptionPane.showInputDialog("Enter number of customer for this day");
        custNum = Integer.parseInt(response);
        
        double[] highPaid = new double[custNum];
        String[] nameCustomer = new String[custNum];
        double[] total = new double[custNum];
        double[] subTotal = new double[custNum];
        int[] cust = new int[5];
        String[] vend = new String[5];
        
        System.out.println("Enter the name of the staff that manage the vendor: ");
        staffVendor = input.next(); 
        
        for (int l = 0; l < custNum; l++)
        {
            custCount++;
            System.out.println("\nCustomer " + custCount + " Order");
            System.out.println("Enter Customer's name: ");
            nameCustomer[l] = input.next();
            System.out.println("Enter quantity of vendor you visited: ");
            size = input.nextInt();
            
            //array declaration for object
            Menu[] menuObj = new Menu[size];
            char[] typeVendor = new char[size];
            
            //array declaration for variable
            double subPrice = 0.0;
            char seeOrder = 'Y';
            String data = br.readLine();
            
            //loop for quantity of food ordered from all vendor
            for (int i = 0; i < size; i++)
            {                
                System.out.println("\n  =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println(" |      W E L C O M E  T O  L E ' N I T T A         |");
                System.out.println("  =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                
                System.out.println("Choose vendor"+
                                   "\n (W) Western"+
                                   "\n (K) Korean"+
                                   "\n (T) Thailand"+
                                   "\n (M) Malay"+
                                   "\n (B) Beverages");
                typeVendor[i] = input.next().charAt(0);
                    
                    if(typeVendor[i] == 'W' || typeVendor[i] == 'w')
                    { 
                        //WESTERN MENU
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("|                 W E S T E R N                     |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|    f o o d  n a m e    |          p r i c e       |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|(W1) Fish 'n' Chip      |          RM 10.00        |");
                        System.out.println("|(W2) Chicken  Chop      |          RM 15.00        |");
                        System.out.println("|(W3) Burger   GTR       |          RM  7.00        |");
                        System.out.println("|(W4) Nugget & Sausage   |          RM 10.00        |");
                        System.out.println("-----------------------------------------------------");
                        cust[0]++;
                        vend[0] = "Western";
                    }
                    else if(typeVendor[i] == 'M' || typeVendor[i] == 'm')
                    {
                        //MASAKAN MELAYU MENU
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("|            M A S A K A N  M E L A Y U             |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|    f o o d  n a m e    |          p r i c e       |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|(M1) Apam Balik         |          RM  4.00        |");
                        System.out.println("|(M2) Nasi Lemak         |          RM  3.00        |");
                        System.out.println("|(M3) Nasi Kerabu        |          RM  8.00        |");
                        System.out.println("|(M4) Chicken  Rice      |          RM  7.00        |");
                        System.out.println("-----------------------------------------------------");
                        cust[1]++;
                        vend[1] = "Malay";
                    }
                    else if(typeVendor[i] == 'T' || typeVendor[i] == 't')
                    {
                        //THAI MENU
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("|                  T H A I L A N D                  |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|    f o o d  n a m e    |          p r i c e       |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|(T1) Tomyam             |          RM  7.50        |");
                        System.out.println("|(T2) Pad Thai           |          RM  6.50        |");
                        System.out.println("|(T3) Kerabu Tomyam      |          RM  6.00        |");
                        System.out.println("|(T4) Claypot Chicken    |          RM  7.00        |");
                        System.out.println("-----------------------------------------------------");
                        cust[2]++;
                        vend[2] = "Thailand";
                    }
                    else if(typeVendor[i] == 'K' || typeVendor[i] == 'k')
                    {
                        //KOREAN MENU
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("|                   K O R E A N                     |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|    f o o d  n a m e    |          p r i c e       |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|(K1) Ramyeon            |          RM   6.50       |");
                        System.out.println("|(K2) Bulgogi            |          RM  15.00       |");
                        System.out.println("|(K3) Kimchi Stew        |          RM  12.00       |");
                        System.out.println("|(K4) Jajangmyeon        |          RM  10.00       |");
                        System.out.println("-----------------------------------------------------");
                        cust[3]++;
                        vend[3] = "Korean";
                    }
                    else if(typeVendor[i] == 'B' || typeVendor[i] == 'b')
                    {
                        //DRINKS
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("|                 B E V E R A G E S                 |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|   d r i n k  n a m e   |          p r i c e       |");
                        System.out.println("-----------------------------------------------------");
                        System.out.println("|(B1) Matcha             |          RM   3.50       |");
                        System.out.println("|(B2) Coffee             |          RM   4.00       |");
                        System.out.println("|(B3) Chocolate Milk     |          RM   3.00       |");
                        System.out.println("|(B4) Iced Lemon Tea     |          RM   2.50       |");
                        System.out.println("-----------------------------------------------------");
                        cust[4]++;
                        vend[4] = "Beverages";
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "WRONG INPUT!!", "ERROR", 2);
                        JOptionPane.showMessageDialog(null, "PLEASE RELOAD THE PROGRAM", "ERROR", 2);
                }
                                
                System.out.print("Enter food code: ");
                foodCode = input.next();
                Fcode = foodCode.charAt(0);
                System.out.print("Enter quantity: ");
                quantity = input.nextInt();
                
                menuObj[i] = new Menu(foodCode, quantity);
                
                //calc subtotal
                subPrice = menuObj[i].foodPrice();
                subTotal[l] = subPrice + subTotal[l];
            }
            //input file info
            StringTokenizer st = new StringTokenizer(data,"#");
            idOrder = st.nextToken();
            contactCustomer = st.nextToken();
            tableNoCustomer = Integer.parseInt(st.nextToken());
            
            System.out.print("Enter customer's payment method [Cash/E-wallet]: ");
            payMetCustomer = input.next().charAt(0);            
            
            System.out.print("Does customer have a membership? [Y/N]: ");
            membership = input.next().charAt(0);
            
            orderObj = new Order(idOrder, nameCustomer[l], contactCustomer, tableNoCustomer, payMetCustomer, membership);   
                        
            for(int q = 0; q < size; q++)
            {
                vendorObj = new Vendor(typeVendor[q], staffVendor, nameCustomer[l], contactCustomer, tableNoCustomer, payMetCustomer, membership);
            }
            if(payMetCustomer == 'C'|| payMetCustomer == 'c')
            {
                System.out.print("Enter customer's cash amount: ");
                cash = input.nextDouble();
            }
            
            //receipt customer
            orderObj.displayReceipt();
            for (int t = 0; t < size; t++)
            {
                System.out.println(menuObj[t].toString());
            }
            //calc for disc, tax, total
            orderObj.discount(subTotal[l]);
            orderObj.tax(subTotal[l]);
            orderObj.overallTotal(subTotal[l]);
            orderObj.balance(cash, subTotal[l]);
            
            //display receipt
            orderObj.displayReceipt2(cash, subTotal[l]);
            System.out.println(vendorObj.toString());
            
            //total profit for all vendor
            overall = overall + orderObj.overallTotal(subTotal[l]);
        }
        
        JOptionPane.showMessageDialog(null, "Thanks for coming to Le' Nitta :D \n   Please come again anytime!", "Le' Nitta", 1);
        
        String BestCustomer = nameCustomer[0];
        double maxTotal = orderObj.overallTotal(subTotal[0]);
        for(int d = 0; d < custNum; d++)
        {
            //customer with higher amount paid
            if(maxTotal < orderObj.overallTotal(subTotal[d]))
            {
                maxTotal = orderObj.overallTotal(subTotal[d]);
                BestCustomer = nameCustomer[d];
            }
        }
        
        double maxCust = cust[0];
        String maxVend = vend[0];
        for(int f = 0; f < 5; f++)
        {
            if(maxCust < cust[f])
            {
                maxCust = cust[f];
                maxVend = vend[f];
            }
        }
        
        pw.println("  =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+
                "\n  |         R E P O R T  O F  T H E  D A Y         |"+
                "\n  =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"+
                "\n TOTAL CUSTOMER: " + custNum +
                "\n CUSTOMER WITH THE HIGHEST AMOUNT PAID: " + BestCustomer +
                "\n TOTAL PROFIT FOR WHOLE FOODCOURT: RM" + df.format(overall) +
                "\n STAFF IN CHARGE: " + staffVendor +
                "\n------------------------------------------------------" +
                "\n Total customer visited from each vendor: " +
                "\n WESTERN: " + cust[0] +
                "\n MALAY: " + cust[1] +
                "\n THAILAND: " + cust[2] +
                "\n KOREAN: " + cust[3] +
                "\n BEVERAGES: " + cust[4] + 
                "\n------------------------------------------------------" +
                "\n BEST VENDOR BASED ON NUMBER OF CUSTOMER: " + maxVend + " Vendor");
                
                         
        br.close();
        pw.close();
    }
}
