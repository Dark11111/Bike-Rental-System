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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 *
 * @author Mohamed Hasabo
 */

class stationTree { 
    
    class Node  
    { 
        int key; 
        Node left, right; 
        String name;
        int ep, tb, nb, rental_time;

        public Node(int item, String name1, int ep1, int tb1, int nb1, int rental_time1) 
        { 
            key = item; 
            left = right = null; 
            name = name1;
            ep = ep1;
            tb = tb1;
            nb = nb1;
            rental_time = rental_time1;
        } 
    } 

    // Root of BST 
    Node root; 

    // Constructor 
    stationTree()  
    {  
         root = null;  
    } 

    // This method mainly calls insertRec() 
    void insert(int key, String name1, int ep1, int tb1, int nb1, int rental_time1)  
    {  
         root = insertRec(root, key, name1, ep1, tb1, nb1, rental_time1);  
    } 

    /* A recursive function to  
       insert a new key in BST */
    Node insertRec(Node root, int key, String name1, int ep1, int tb1, int nb1, int rental_time1) 
    { 

        /* If the tree is empty, 
           return a new node */
        if (root == null)  
        { 
            root = new Node(key, name1, ep1, tb1, nb1, rental_time1); 
            return root; 
        } 

        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key, name1, ep1, tb1, nb1, rental_time1); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key, name1, ep1, tb1, nb1, rental_time1); 

        /* return the (unchanged) node pointer */
        return root; 
    } 

    // This method mainly calls InorderRec() 
    void inorder()  
    {  
        System.out.println();
        inorderRec(root);  
    } 

    // A utility function to  
    // do inorder traversal of BST 
    void inorderRec(Node root) 
    { 
        if (root != null) { 
            System.out.println();
            inorderRec(root.left); 
            System.out.println("Key root: "+root.key); 
            System.out.println("Station Name: "+root.name); 
            System.out.println("Rental Time: "+root.rental_time); 
            System.out.println("Empty Parks: "+root.ep); 
            System.out.println("Tandem Bicycles: "+root.tb); 
            System.out.println("Normal Bicycles: "+root.nb); 
            inorderRec(root.right); 
            
        } 
    }
    
    int maxDepth(Node node)  
    { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left); 
            int rDepth = maxDepth(node.right); 
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    }
    
    void inorder1()  
    {   
        inorderRec1(root);  
    } 
    
    void inorderRec1(Node root) 
    { 
        if (root != null) { 
            inorderRec1(root.left); 
            System.out.println("\nStation Name : "+root.name); 
            System.out.println("Rental Time : "+root.rental_time); 
            inorderRec1(root.right); 
        } 
    }
    
   }

public class Project3 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //String stations[] = new String[9];
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
        
        
        
        for (int i = 0; i < stations.length ; i++) {
            System.out.println("\nStations Info "+(i+1)+" : "+ stations[i]);
        }
        
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
            if(TB[i] == 0){
                TB[i] = 1;
            }
            NB[i] = Integer.parseInt(temp[3]);
        }
        
        
        Random rand = new Random();
        int rental_time = 0; 
        
        stationTree tree = new stationTree(); 

        
        int cid=1;
        for (int i = 0; i < stations.length; i++) {
            rental_time = rand.nextInt(10)+1;
            tree.insert(cid, name[i], EP[i], TB[i], NB[i], rental_time);
            
            cid++;
        }
        
        // print inorder traversal of the BST 
        tree.inorder(); 
        System.out.println();
        System.out.println("Height of tree is : " + tree.maxDepth(tree.root)); 
        tree.inorder1(); 
        
        
    }
    
}
