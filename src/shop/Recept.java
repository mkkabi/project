
package shop;

import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Recept  implements Comparable<Recept>{
    String name;
    Map<Ingradient,Integer> sostav = new TreeMap<>();
    Map<Ingradient,Integer> dopSostav = new TreeMap<>();//это для изменения состава конкретному клиенту пока не
   NavigableMap<Date,Integer> arhivPrice=new TreeMap<Date, Integer>();// это для истории цен
   private int currentPrice;
    static final Set<Recept> spisokReceptov = new TreeSet<>();

    public Recept(String name, int price) {
        this.name = name;
        this.changePrice(price, new Date());
          }
    public int getCurrentPriceForDate(Date d1){
        int result=0;
        
        if(arhivPrice.get(d1)==null){
        result=d1.after(arhivPrice.firstKey())?arhivPrice.get(arhivPrice.lowerKey(d1)):0;
        }else{
        result=arhivPrice.get(d1);
        }
        //System.out.println(arhivPrice);
        return result;
    }
public boolean changePrice(int newPrice,Date dateChange){
    boolean result=false;
    //проверка возможности изменения цены если можно
    arhivPrice.put(dateChange, newPrice);
    this.currentPrice=newPrice;
    result=true;
    return  result;
    
}
    @Override
    public int compareTo(Recept o) {
     return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Recept{" + "name=" + name + '}';
    }
    
}

