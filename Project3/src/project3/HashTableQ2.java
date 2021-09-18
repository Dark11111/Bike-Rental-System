/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Mohamed Hasabo
 */


import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author Mohamed Hasabo
 */
public class HashTableQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hashtable<String, Integer> ht = new Hashtable<>();
        String[] stations = { "İnciraltı,28,2,10", "Sahilevleri,8,1,11",
            "Doğal Yaşam,17,1,6", "Bostanlı iskele,7,0,5" };
        
        stations = Arrays.copyOf(stations, stations.length + 1);
        stations[stations.length - 1] = "Karşıyaka,30,3,7";
        
        stations = Arrays.copyOf(stations, stations.length + 1);
        stations[stations.length - 1] = "Konak,27,2,9";
        
        stations = Arrays.copyOf(stations, stations.length + 1);
        stations[stations.length - 1] = "Alsancak,15,2,4";
        
        stations = Arrays.copyOf(stations, stations.length + 1);
        stations[stations.length - 1] = "Göztepe,19,4,16";
        
        stations = Arrays.copyOf(stations, stations.length + 1);
        stations[stations.length - 1] = "Balçova,33,10,12";
        
        
        
        String temp[];
        String name[] = new String[stations.length];
        int EP[] = new int[stations.length];
        int TB[] = new int[stations.length];
        int NB[] = new int[stations.length];
        for (int i = 0; i < stations.length ; i++) {
            temp = stations[i].split(",") ;
            name[i] = temp[0];
            EP[i] = Integer.parseInt(temp[1]);
            TB[i] = Integer.parseInt(temp[2]);
            NB[i] = Integer.parseInt(temp[3]);
            
            // Adding elements using put method 
            ht.put(name[i], TB[i]); 
        }
        
          // Iterating using enhanced for loop 
        for (Map.Entry<String, Integer> e : ht.entrySet()) 
            System.out.println(e.getKey() + " " + e.getValue()); 
        
        for (int i = 0; i < stations.length ; i++) {
            
            if(TB[i]>=5){
                ht.put(name[i], TB[i]);
            }else{
                TB[i] = TB[i]+5;
                ht.put(name[i], TB[i]);
            }
            
        }
        
        System.out.println("\n\n************* UPDATED MAP *************");
        for (Map.Entry<String, Integer> e : ht.entrySet()) 
            System.out.println(e.getKey() + " " + e.getValue()); 
        
    }
    
}
