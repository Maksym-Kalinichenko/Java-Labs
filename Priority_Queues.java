package javaapplication10;

import java.util.*;

/**
 *
 * @author maksymkalinichenko
 */

public class Priority_Queues {

     /**
     * @param args the command line arguments
     */
    
    private static PriorityQueue<String> union(PriorityQueue<String> Priority1, PriorityQueue<String> Priority2) {
        PriorityQueue<String> union = new PriorityQueue<>(Priority1);
        union.addAll(Priority2);
        return union;
    }
    
    private static PriorityQueue<String> difference(PriorityQueue<String> Priority1, PriorityQueue<String> Priority2) {
        PriorityQueue<String> difference = new PriorityQueue<>(Priority1);
        difference.removeAll(Priority2);
        return difference;
    }

    private static PriorityQueue<String> intersection(PriorityQueue<String> Priority1, PriorityQueue<String> Priority2) {
        PriorityQueue<String> intersection = new PriorityQueue<>(Priority1);
        intersection.retainAll(Priority2);
        return intersection;
    }


    public static void main(String[] args) {

        PriorityQueue<String> Priority1 = new PriorityQueue<>(Arrays.asList("Tom", "Viola", "Marco", "Antonio", "Thomas", "Lui"));
        PriorityQueue<String> Priority2 = new PriorityQueue<>(Arrays.asList("Kay-Marie", "Mia", "Lucy", "Ansi", "Simon"));

        System.out.println("Union of queues: " + union(Priority1, Priority2));

        System.out.println("Difference of queues: " + difference(Priority1, Priority2));

        System.out.println("Intersection of sets: " + intersection(Priority1, Priority2));
    }
}
