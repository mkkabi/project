package shop;

public class Start {

    public static void main(String[] args) throws Exception {
        System.out.println("adsfadsf=====");
        
        Shop shop1 = new Shop("shop1");
        System.out.println(shop1.getNameID());
        Worker wasia = new Worker("wasia", "123", "wasia");
        shop1.setNameID("Wasia");
        System.out.println(shop1.getNameID());
        shop1.setCurrentEmploee(wasia);
        
        shop1.setNameID("shop new name");
        System.out.println(shop1.getNameID());
                
        System.out.println("to string: " + shop1.getCurrentEmploee().toString());
        
        Shop shop2 = new Shop("shop 2");
        shop2.setCurrentEmploee(wasia);
        System.out.println(shop2.getCurrentEmploee());
        System.out.println("====");
        
        shop1.setCurrentEmploee(wasia);
        System.out.println("222222");
        System.out.println(shop2.getCurrentEmploee());
        System.out.println(shop1.getCurrentEmploee());
    }
}
