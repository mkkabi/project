package shop;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Shop implements Comparable<Shop>{
    
    private String nameID; 
   private  Worker currentEmploee;
   static final Set<Shop> spisokShops=new TreeSet<>();

    public Shop(String nameID) throws Exception {
        this.nameID = nameID;
        if(!spisokShops.add(this)){
            throw new Exception("Duble name Shop");
        }
    }

    public String getNameID() {
        return nameID;
    }

    public void setNameID(String nameID) {
        this.nameID = nameID;
    // как поведет программа если попробую заменить на существующее имя
    }

    public Worker getCurrentEmploee() {
        return currentEmploee;
    }

    public void setCurrentEmploee(Worker currentEmploee) {
        this.currentEmploee = currentEmploee;
        //как исключить ситуацию закрепления 1 работника за несколькими точками
    }
   
    
   //ArrayList<String> itemsInStock;

       @Override
    public int compareTo(Shop o) {
        return this.nameID.compareToIgnoreCase(o.nameID);
    }
    
}
