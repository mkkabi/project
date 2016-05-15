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
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Shop implements Comparable<Shop>{
    
    private String nameID; 
   private  Worker currentEmploee;
   private  Date currentDay;
   static final Set<Shop> spisokShops = new TreeSet<>();
   final Map<Date,Vector<Recept>>  jurnalShopSales=new TreeMap<>();

    public Shop(String nameID) throws Exception {
        this.nameID = nameID;
        if(!spisokShops.add(this)){
            throw new Exception("Duble name Shop");
        }
    }
public void openWorkDay(){
    //проверка нет ли такого дня в журнале, если нет то
    currentDay=new Date();
    // если есть то
}
    
    public void prodaga(Recept rec){
        if(jurnalShopSales.get(currentDay)==null){
            jurnalShopSales.put(currentDay,new Vector<>());
        }
         jurnalShopSales.get(currentDay).add(rec);       

    }
    

       @Override
    public int compareTo(Shop o) {
        return this.nameID.compareToIgnoreCase(o.nameID);
    }

    
    public void reportShopForPeriod(Date start,Date end){
        Set<Map.Entry<Date, Vector<Recept>>> temp1 = jurnalShopSales.entrySet();
        final Vector<Recept> allReceptForPeriod = new Vector<>();
        final Map<Recept, Integer> result = new TreeMap<>();
        Consumer<Map.Entry<Date, Vector<Recept>>> function1 = (n) -> {
            allReceptForPeriod.addAll(n.getValue());
            
        };        
        temp1.stream()
                .filter(this.beetween(start, end))
                .forEach(function1);
        
        Consumer<Recept> function2 = (n) -> {
            if (result.containsKey(n)) {
                result.put(n, result.get(n) + 1);
            } else {
                result.put(n, 1);
            }
        };
        Stream<Recept> str = allReceptForPeriod.stream();
        str.forEach(function2);
        
        int i = 1;
        int sumItog = 0;
        Set<Map.Entry<Recept, Integer>> countReceptov = result.entrySet();
         System.out.println(" Отчет по точке :" + this.nameID);
         System.out.println("    за период " + start + " - " + end);
       
        for (Map.Entry<Recept, Integer> para : countReceptov) {
            Recept currRec = para.getKey();
            int currCount = para.getValue();
            int sumPoPozic = currRec.currentPrice * currCount;
            System.out.println(i + ". " + currRec + " -- " + currCount + " шт. сумма - " + sumPoPozic);
            i++;
            sumItog = sumItog + sumPoPozic;
        }
        System.out.println("_____________________________Итого по точке за период сумма - " + sumItog);

    }       
    
    private Predicate<Map.Entry<Date, Vector<Recept>>> beetween(Date d1, Date d2) {
        Predicate<Map.Entry<Date, Vector<Recept>>> prStart;
        Predicate<Map.Entry<Date, Vector<Recept>>> prEnd;
        if (d2.after(d1)) {
            prStart = (n) -> n.getKey().after(d1);
            prEnd = (n) -> n.getKey().before(d2);
        } else {
            prEnd = (n) -> n.getKey().after(d2);
            prStart = (n) -> n.getKey().before(d1);
        }

        return prStart.or(prEnd);
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
public static void main(String[] qwe) throws Exception{
    Shop sh1=new Shop("Точка 1");
    sh1.openWorkDay();
    Date startPeriod=new Date(2016, 5, 11);
    Date endPeriod=new Date(2016, 5, 17);
      Date equalDate=new Date(2016, 5, 15);
    sh1.reportShopForPeriod(startPeriod, endPeriod);
    Recept r1=new Recept("capuchino", 50);
    Recept r2=new Recept("brasil", 40);
    sh1.prodaga(r2);
    sh1.prodaga(r2);
    sh1.prodaga(r2);
    sh1.prodaga(r2);
    sh1.prodaga(r1);
    sh1.prodaga(r1);
    sh1.reportShopForPeriod(startPeriod, endPeriod);
     sh1.reportShopForPeriod(equalDate, equalDate);
}

}

