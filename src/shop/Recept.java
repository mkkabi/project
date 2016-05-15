
package shop;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Recept  implements Comparable<Recept>{
    String name;
    Map<Ingradient,Integer> sostav = new TreeMap<>();
    Map<Ingradient,Integer> dopSostav = new TreeMap<>();
    int currentPrice;
    static final Set<Recept> spisokReceptov = new TreeSet<>();

    public Recept(String name, int price) {
        this.name = name;
        this.currentPrice = price;
   
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

