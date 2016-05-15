package shop;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Start {

    public static void main(String[] args) throws Exception {
//        System.out.println("adsfadsf=====");
//        System.out.println("gfggfg");
//         System.out.println("gfggfg");
//        Shop shop1 = new Shop("shop1");
//        System.out.println(shop1.getNameID());
//        Worker wasia = new Worker("wasia", "123", "wasia");
//        shop1.setNameID("Wasia");
//        System.out.println(shop1.getNameID());
//        shop1.setCurrentEmploee(wasia);
//        
//        shop1.setNameID("shop new name");
//        System.out.println(shop1.getNameID());
//                
//        System.out.println("to string: " + shop1.getCurrentEmploee().toString());
//        
//        Shop shop2 = new Shop("shop 2");
//        shop2.setCurrentEmploee(wasia);
//        System.out.println(shop2.getCurrentEmploee());
//        System.out.println("====");
//        
//        shop1.setCurrentEmploee(wasia);
//        System.out.println(shop2.getCurrentEmploee());
//        System.out.println(shop1.getCurrentEmploee());
//        Date currentDate=new Date();
//        SimpleDateFormat sd=new  SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(sd.format(currentDate)); 
Date d1=new Date();
        Thread.sleep(1000);
Date d2=new Date();
        Calendar c1=Calendar.getInstance();
        
        System.out.println(d1.after(d2));
        System.out.println(d1.before(d2));
    }
}
