package shop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Shop implements Comparable<Shop>{
    
    private String nameID; 
   private  Worker currentEmploee;
   static final Set<Shop> spisokShops = new TreeSet<>();
   final Map<Date,Vector<Recept>>  jurnalShop=new TreeMap<>();
   final Vector<Recept> curentSpicok=new Vector<>();

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
        if(!currentEmploee.isCurrentlyWorking){
            this.currentEmploee = currentEmploee;
            currentEmploee.isCurrentlyWorking = true;
        }
        else
            System.out.println(currentEmploee.name + " уже работает");
        //как исключить ситуацию закрепления 1 работника за несколькими точками
    }
    public void addZakaz(Recept rec){
        curentSpicok.add(rec);

    }
    

       @Override
    public int compareTo(Shop o) {
        return this.nameID.compareToIgnoreCase(o.nameID);
    }

    public void synchronezeData() {
       jurnalShop.put(new Date(), curentSpicok);
       curentSpicok.clear();
               }
    
    public void reportShopForPeriod(Date start,Date end){
        Set<Map.Entry<Date,Vector<Recept>>> temp1=jurnalShop.entrySet();
        Vector<Recept> result=new Vector<>();
        for(Map.Entry<Date,Vector<Recept>> temp:temp1){
            if(start.after(end)){
              if(temp.getKey().after(start)||temp.getKey().before(end)){
                 result.addAll(temp.getValue());
                }  
            }else{
                
            }
        }
            Map<Recept,Integer> sumRec=new TreeMap<Recept, Integer>();
            for(Recept temp:result){
                Integer ak1=sumRec.get(temp);
                if(ak1==null){
                 sumRec.put(temp, 1);
                }else{
                   sumRec.put(temp,ak1+1 );  
                
            }
                System.out.println(sumRec);
        }
        
    }

    public Shop() {
    }



}
