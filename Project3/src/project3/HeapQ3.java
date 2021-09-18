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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author Mohamed Hasabo
 */
public class HeapQ3 {

    /**
     * @param args the command line arguments
     */
    static class MaxHeap {
        private int[] Heap;
        private int size;
        private int maxsize;
 
        public MaxHeap(int size) {
            this.maxsize = size;
            this.size = 0;
            Heap = new int[this.maxsize + 1];
            Heap[0] = Integer.MAX_VALUE;
        }
 
        private int parent(int pos) {
            return pos / 2;
        }
 
        private int leftChild(int pos) {
            return (2 * pos)  ;
        }
 
        private int rightChild(int pos) {
            return (2 * pos) + 1;
        }
 
 
        private void swap(int fpos, int spos) {
            int tmp;
            tmp = Heap[fpos];
            Heap[fpos] = Heap[spos];
            Heap[spos] = tmp;
        }
 
        private void downHeapify(int pos) {
            if (pos >= (size / 2) && pos <= size)
                return;
 
            if (Heap[pos] < Heap[leftChild(pos)] ||
                    Heap[pos] < Heap[rightChild(pos)]) {
 
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    downHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    downHeapify(rightChild(pos));
                }
            }
        }
        private void heapifyUp(int pos) {
            int temp = Heap[pos];
            while(pos>0 && temp > Heap[parent(pos)]){
                Heap[pos] = Heap[parent(pos)];
                pos = parent(pos);
            }
            Heap[pos] = temp;
        }
 
 
        public void insert(int element) {
            Heap[++size] = element;
 
 
            int current = size;
            heapifyUp(current);
 
        }
 
        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.print(+ Heap[i] + ": L- " +
                        Heap[2 * i] + " R- " + Heap[2 * i + 1]);
                System.out.println();
            }
        }
 
        public int extractMax() {
            int max = Heap[1];
            Heap[1] = Heap[size--];
            downHeapify(1);
            return max;
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
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
        
        MaxHeap maxHeap = new MaxHeap(15);
        
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
             
            maxHeap.insert(EP[i]);
        }

        maxHeap.print();
        System.out.println("The max is " + maxHeap.extractMax());
        
        
        
        
        
        
        
        //priority queues
        // Creating empty priority queue 
        PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(Collections.reverseOrder()); 
  
        // Adding items to the pQueue using add() 
        for (int i = 0; i < stations.length ; i++) {
            pQueue.add(EP[i]);
        }
  
        // Displaying the highest priority element 
        System.out.println("Head value using peek function:" +  pQueue.peek()); 
  
        // Printing all elements 
        System.out.println("The queue elements:"); 
        Iterator itr = pQueue.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
  
        // Removing the top priority element (or head) and 
        // printing the modified pQueue using poll() 
        pQueue.poll(); 
        System.out.println("After removing an element with poll function:"); 
        Iterator<Integer> itr2 = pQueue.iterator(); 
        while (itr2.hasNext()) 
            System.out.println(itr2.next()); 
  
        // Removing element 28 using remove() 
        pQueue.remove(28); 
        System.out.println("after removing 28 with remove function:"); 
        Iterator<Integer> itr3 = pQueue.iterator(); 
        while(itr3.hasNext()) 
            System.out.println(itr3.next()); 
  
        // Check if an element is present using contains() 
        boolean b = pQueue.contains(28); 
        System.out.println("Priority queue contains 28 or not?: " + b); 
  
        // Getting objects from the queue using toArray() in an array and display the array 
        Object[] arr = pQueue.toArray(); 
        System.out.println("Value in array: ");
        for(int i = 0; i < arr.length; i++) 
            System.out.println("Value: " + arr[i].toString()); 
     
    }
    
}
