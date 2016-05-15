
package shop;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Ingradient {
    String name;
    String proizvoditel;
     Map<Date,Integer> arhivPrice=new TreeMap<Date, Integer>();// это для истории цен
    int price;

    public Ingradient(String name, String proizvoditel, int price) {
        this.name = name;
        this.proizvoditel = proizvoditel;
        this.price = price;
    }
    
    public boolean changePrice(int newPrice,Date dateChange){
    boolean result=false;
    
    return  result;
}
}
