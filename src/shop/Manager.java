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
    Map<Ingradient,Integer> spisokIngr=new TreeMap<>();
   // final Vector<Recept> curentSpicokRecept = new Vector<>();

    public Manager(String name, String password, String login) {
        super(name, password, login);
    }
    
    public void addProducts(Shop shop,Map<Ingradient,Integer> korzina){}
    
    public void addWorkerInShop(Shop sh, Worker work){
       deleteWorker(work);
        sh.setCurrentEmploee(work);
    }
    public void checkStock(Shop shop){}
    public void getShopReportDay(Shop shop){}
    public void getAllShopReport(){}
   
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
    }
    }
}
