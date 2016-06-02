package shop;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager extends Worker{
//    Set<Shop> spisok=new TreeSet<>();
    Map<Ingradient,Integer> spisokIngrNaSclad=new TreeMap<>();
   // final Vector<Recept> curentSpicokRecept = new Vector<>();
    
    public void addIngredient(Ingradient ingr, int ves){
        if(spisokIngrNaSclad.containsKey(ingr)){
        spisokIngrNaSclad.put(ingr,spisokIngrNaSclad.get(ingr)+ ves);
        }else{
        spisokIngrNaSclad.put(ingr, ves);
        }
    }
    
    public void otpravitIngrNaShop (Map<Ingradient, Integer> korzina, Shop shop){
       Set<Map.Entry<Ingradient,Integer>>  setKorz=korzina.entrySet();
        for(Map.Entry<Ingradient,Integer> temp :setKorz ){
        Ingradient tIngr=temp.getKey();
        Integer tInt=temp.getValue();
        Integer t1=shop.shopSklad.get(tIngr);
        if(t1==null){
           shop.shopSklad.put(tIngr, tInt);
        }else{
            shop.shopSklad.put(tIngr, shop.shopSklad.get(tIngr)+tInt);
        }
    }
    }
       public Manager(String name, String password, String login) {
        super(name, password, login);
    }
    
    public void addProducts(Shop shop,Map<Ingradient,Integer> korzina){}
    
    public void addWorkerInShop(Shop sh, Worker work){
       deleteWorker(work);
        sh.setCurrentEmploee(work);
    }
    public void checkStock(Shop shop){}
    public void getShopReportDay(Shop shop,Date start,Date end){
    shop.newReportShopForPeriod(start, end);
    
    }
    public void getAllShopReport(Date start, Date end){
    int itogo=0;
        for (Shop temp : Shop.spisokShops){
        
        itogo = itogo+temp.newReportShopForPeriod(start, end);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }System.out.println("Итого по всем магазинам: "+ itogo);
    }
   
    public void createNewShop(String name){
        try {
            new Shop(name);
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int checkWorkerDay(Worker worker, Date period){
    return 0;
    }
    public void addRecept(String nameRecept,Map<Ingradient,Integer> sostav1,int price){
        
    }
    public void deleteRecept(Recept rec){
        
    }

    private void deleteWorker(Worker work) {
        for(Shop temp:Shop.spisokShops){
        if(temp.getCurrentEmploee().equals(work)){
             temp.setCurrentEmploee(null);
             break;
        }
        System.out.println(temp.getNameID());
    } 
    }
}
