package javaapplication10;

import java.util.*;

/**
 *
 * @author maksymkalinichenko
 */
public class ListIterator_GetIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Integer> arrlist = new ArrayList<>();

        for (int i = 0; i < 5000000; i++) {
            arrlist.add(i);
        }
        
        LinkedList<Integer> linkedList = new LinkedList<>(arrlist);

        long startTime = System.currentTimeMillis(); //start

        ListIterator<Integer> iterator = linkedList.listIterator();
        
        while (iterator.hasNext()) {
            iterator.next();
        }
        
        long endTime = System.currentTimeMillis(); //end

        System.out.println("Time for a list using an iterator (5000000): " + (endTime - startTime) + " millisecond");//iterator

        startTime = System.currentTimeMillis(); //start
        
        for (int i = 0; i < 500000; i++) {
            linkedList.get(i);
        }
        
        endTime = System.currentTimeMillis(); //end

        System.out.println("Time for a list using the get(index) method (500000): " + (endTime - startTime) + " millisecond"); //get(index) method
    }
}
