/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Recept {
    String name;
    Map<Ingradient,Integer> sostav=new TreeMap<>();
    int price;
    static final Set<Recept> spisokReceptov=new TreeSet<>();

    public Recept(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    
    
}

