import java.text.DecimalFormat;

public class Menu
{
    private String foodCode;
    private int quantity;
    DecimalFormat df = new DecimalFormat(".00");
    
    public Menu(String foodCode, int quantity)
    {
        this.foodCode = foodCode;
        this.quantity = quantity;
    }
    
    public String getFoodCode()
    {
        return foodCode;
    }
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setMenu(String foodCode, int quantity)
    {
        this.foodCode = foodCode;
        this.quantity = quantity;
    }
    public void setFoodCode(String foodCode)
    {
        this.foodCode = foodCode;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public double foodPrice()
    {
        double price = 0.0;
        
        //western
        if(foodCode.equalsIgnoreCase("W1"))
            price = 10.0 * quantity;
        else if(foodCode.equalsIgnoreCase("W2"))
            price = 15.0 * quantity;
        else if(foodCode.equalsIgnoreCase("W3"))
            price = 7.0 * quantity;
        else if(foodCode.equalsIgnoreCase("W4"))
            price = 5.0 * quantity;
        
        //malay
        if(foodCode.equalsIgnoreCase("M1"))
            price = 3.0 * quantity;
        else if(foodCode.equalsIgnoreCase("M2"))
            price = 7.0 * quantity;
        else if(foodCode.equalsIgnoreCase("M3"))
            price = 8.0 * quantity;
        else if(foodCode.equalsIgnoreCase("M4"))
            price = 4.0 * quantity;
        
        //thai
        if(foodCode.equalsIgnoreCase("T1"))
            price = 7.5 * quantity;
        else if(foodCode.equalsIgnoreCase("T2"))
            price = 6.5 * quantity;
        else if(foodCode.equalsIgnoreCase("T3"))
            price = 6.0 * quantity;
        else if(foodCode.equalsIgnoreCase("T4"))
            price = 7.0 * quantity;
        
        //korean
        if(foodCode.equalsIgnoreCase("K1"))
            price = 6.5 * quantity;
        else if(foodCode.equalsIgnoreCase("K2"))
            price = 15.0 * quantity;
        else if(foodCode.equalsIgnoreCase("K3"))
            price = 12.0 * quantity;
        else if(foodCode.equalsIgnoreCase("K4"))
            price = 10.0 * quantity;
        
        //beverage
        if(foodCode.equalsIgnoreCase("B1"))
            price = 2.5 * quantity;
        else if(foodCode.equalsIgnoreCase("B2"))
            price = 3.0 * quantity;
        else if(foodCode.equalsIgnoreCase("B3"))
            price = 3.5 * quantity;
        else if(foodCode.equalsIgnoreCase("B4"))
            price = 4.0 * quantity;
            
        return price;
    }
    
    public String foodName(){
        String foodName = " ";
        
        //western
        if(foodCode.equalsIgnoreCase ("W1"))
            foodName = "Fish ‘n’ Chip   ";
        else if(foodCode.equalsIgnoreCase("W2"))
            foodName = "Chicken Chop    ";
        else if(foodCode.equalsIgnoreCase("W3"))
            foodName = "Burger GTR      ";
        else if(foodCode.equalsIgnoreCase("W4"))
            foodName = "Nugget & Sausage";
        
        //malay
        if(foodCode.equalsIgnoreCase("M1"))
            foodName = "Nasi Lemak      ";
        else if(foodCode.equalsIgnoreCase("M2"))
            foodName = "Chicken Rice    ";
        else if(foodCode.equalsIgnoreCase("M3"))
            foodName = "Nasi Kerabu     ";
        else if(foodCode.equalsIgnoreCase("M4"))
            foodName = "Apam Balik      ";
            
        //thai
        if(foodCode.equalsIgnoreCase("T1"))
            foodName = "Tomyam          ";
        else if(foodCode.equalsIgnoreCase("T2"))
            foodName = "Pad Thai        ";
        else if(foodCode.equalsIgnoreCase("T3"))
            foodName = "Kerabu Tomyam   ";
        else if(foodCode.equalsIgnoreCase("T4"))
            foodName = "Claypot Chicken ";
        
        //korean
        if(foodCode.equalsIgnoreCase("K1"))
            foodName = "Ramyeon         ";
        else if(foodCode.equalsIgnoreCase("K2"))
            foodName = "Jajangmyeon     ";
        else if(foodCode.equalsIgnoreCase("K3"))
            foodName = "Kimchi Stew     ";
        else if(foodCode.equalsIgnoreCase("K4"))
            foodName = "Bulgogi         ";
        
        //beverage
        if(foodCode.equalsIgnoreCase("B1"))
            foodName = "Iced Lemon Tea  ";
        else if(foodCode.equalsIgnoreCase("B2"))
            foodName = "Chocolate Milk  ";
        else if(foodCode.equalsIgnoreCase("B3"))
            foodName = "Matcha          ";
        else if(foodCode.equalsIgnoreCase("B4"))
            foodName = "Coffee       ";
        
        return foodName;
    }
    
    public String toString()
    {
        return("\n" + quantity + "\t" + foodCode + "\t\t" + foodName() + "\t\t" + df.format(foodPrice()));
    }
}


