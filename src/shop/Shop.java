package shop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedSet;
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
   final NavigableMap<Date,Vector<Recept>>  jurnalShopSales=new TreeMap<>();

   public Map<Ingradient, Integer> shopSklad = new TreeMap<>();
    public Shop(String nameID) throws Exception {
        this.nameID = nameID;
        if(spisokShops.add(this)){
            System.out.println("Magazin dobavlen");
        }else{
            throw new Exception("Duble name Shop");
        } 
    }
    
    public Date printDay(){
        System.out.println(currentDay);
        return currentDay;
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
    private void prodaga(Recept rec,Date d1 ){
        if(jurnalShopSales.get(d1)==null){
            jurnalShopSales.put(d1,new Vector<>());
        }
         jurnalShopSales.get(d1).add(rec);       

    }
    

       @Override
    public int compareTo(Shop o) {
        return this.nameID.compareToIgnoreCase(o.nameID);
    }

    
//    public void reportShopForPeriod(Date start,Date end){
//        Set<Map.Entry<Date, Vector<Recept>>> temp1 = jurnalShopSales.entrySet();
//        final Vector<Recept> allReceptForPeriod = new Vector<>();
//        final Map<Recept, Integer> result = new TreeMap<>();
//        Consumer<Map.Entry<Date, Vector<Recept>>> function1 = (n) -> {
//            allReceptForPeriod.addAll(n.getValue());
//            
//        };        
//        temp1.stream()
//                .filter(this.beetween(start, end))
//                .forEach(function1);
//        
//        Consumer<Recept> function2 = (n) -> {
//            if (result.containsKey(n)) {
//                result.put(n, result.get(n) + 1);
//            } else {
//                result.put(n, 1);
//            }
//        };
//        Stream<Recept> str = allReceptForPeriod.stream();
//        str.forEach(function2);
//        
//        int i = 1;
//        int sumItog = 0;
//        Set<Map.Entry<Recept, Integer>> countReceptov = result.entrySet();
//         System.out.println(" Отчет по точке :" + this.nameID);
//         System.out.println("    за период " + start + " - " + end);
//       
//        for (Map.Entry<Recept, Integer> para : countReceptov) {
//            Recept currRec = para.getKey();
//            int currCount = para.getValue();
//            int sumPoPozic = currRec.getCurrentPriceForDate(end) * currCount;/////////////////// end is problem
//            System.out.println(i + ". " + currRec + " -- " + currCount + " шт. сумма - " + sumPoPozic);
//            i++;
//            sumItog = sumItog + sumPoPozic;
//        }
//        System.out.println("_____________________________Итого по точке за период сумма - " + sumItog);
//
//    }       
//    
//    private Predicate<Map.Entry<Date, Vector<Recept>>> beetween(Date d1, Date d2) {
//        Predicate<Map.Entry<Date, Vector<Recept>>> prStart;
//        Predicate<Map.Entry<Date, Vector<Recept>>> prEnd;
//        if (d2.after(d1)) {
//            prStart = (n) -> n.getKey().after(d1);
//            prEnd = (n) -> n.getKey().before(d2);
//        } else {
//            prEnd = (n) -> n.getKey().after(d2);
//            prStart = (n) -> n.getKey().before(d1);
//        }
//
//        return prStart.or(prEnd);
//    }
    
    public int newReportShopForPeriod(Date start,Date end){
      final NavigableMap<Date, Vector<Recept>> result = jurnalShopSales.subMap(start, true, end, true);//это список продаж за период
      final Vector<Integer> itogForPeriod=new Vector<>();
        if(result.isEmpty()){
           System.out.println("За период с "+start+" по "+end+" продаж не было !");
       return 0;
       }
       
       Map<Recept,Integer> tempS=new TreeMap<>();
       System.out.println(" Отчет по точке :" + this.nameID);
        System.out.println("    за период " + this.getDateFormat(start) + " - " + this.getDateFormat(end));
       
       BiConsumer<Date,Vector<Recept>> reportForDay=(n,v)->{
           System.out.println("             По дате -"+this.getDateFormat(n));
         
           v.stream().forEach( new  Consumer<Recept>() {
               @Override
               public void accept(Recept t) {
                   if(tempS.get(t)==null){
                       tempS.put(t, 1);
                   }else{
                       tempS.put(t, tempS.get(t)+1);
                   }
               }
           });
           
           tempS.forEach(new BiConsumer<Recept, Integer>() {
               int i=1;
               int sumDay=0;
               @Override
               public void accept(Recept t, Integer u) {
                   int temp=u*t.getCurrentPriceForDate(n);
                System.out.println(i+ ". " +t + " -- " + u + " шт. сумма - " +temp );   
              i++;
              sumDay=sumDay+temp;
              
              if(i==tempS.size()+1){
                System.out.println("____________________ Итого за день - "+sumDay ); 
                itogForPeriod.add(sumDay);
              }
               }
               
           });
           tempS.clear();
       }; 
       result.forEach(reportForDay);
        System.out.println("**************************************");
        Integer sumItogov= itogForPeriod.stream()
                .mapToInt(Integer::intValue)
                .sum();
         System.out.println("Итого по магазину за период -" +sumItogov);
         return sumItogov;       
    } 
    
    private String getDateFormat(Date d1){
        SimpleDateFormat sf=new SimpleDateFormat("dd.MM.yyyy");
        return sf.format(d1);
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
    Date startPeriod=new Date(116, 4, 11);
    Date endPeriod=new Date(116, 4, 17);
      Date equalDate=new Date(116, 4, 15);
   
    Recept r1=new Recept("capuchino", 50);
    Recept r2=new Recept("brasil", 40);
    
    r1.changePrice(50, new Date(116, 4, 11));
    r2.changePrice(70, new Date(116, 4, 10));
    r2.changePrice(105, new Date(116, 4, 12));
    System.out.println(r2.arhivPrice);
    sh1.prodaga(r2);
    sh1.prodaga(r2);
    sh1.prodaga(r2);
    sh1.prodaga(r2);
    sh1.prodaga(r1);
    sh1.prodaga(r1);
    sh1.prodaga(r2, new Date(116, 4, 11));
    sh1.prodaga(r2, new Date(116, 4, 11));

sh1.newReportShopForPeriod(startPeriod, endPeriod);

     
}

}


