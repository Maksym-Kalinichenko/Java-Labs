package javaapplication10;

import java.util.*;

/**
 *
 * @author maksymkalinichenko
 */
public class European_States {

    /**
     * @param args the command line arguments
     */
    private static String[][] statecapital = {
        {"France", "Paris"},
        {"England", "London"},
        {"Italy", "Rome"},
        {"Denmark", "Copenhagen"},
        {"Croatia", "Zagreb"},
        {"Austria", "Vienna"},
        {"Belgium", "Brussels"},
        {"Germany", "Berlin"},
        {"Monaco", "Monaco"},
        {"Portugal", "Lisbon"},
        {"Sweden", "Stockholm"},
        {"Ukraine", "Kiev"},
        {"Poland", "Warsaw"},
        {"Romania", "Bucharest"},
        {"Russia", "Moscow"},
        {"Spain", "Madrid"}};

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int correctCount = 0;

        final List<Integer> random = new ArrayList<>();
        for (int i = 0; i < statecapital.length; i++) {
            random.add(i);
        }
        Collections.shuffle(random);

        for (int i = 0; i < statecapital.length; i++) {
            int c = random.get(i);
            System.out.print("What is the capital of " + statecapital[c][0] + "? ");
            String s = input.nextLine();
            if (s.equalsIgnoreCase(statecapital[c][1])) {
                System.out.println("Answer is correct!");
                correctCount++;
            } else {
                System.out.println("WRONG - The correct answer is " + statecapital[c][1]);
            }
        }
        System.out.println("The correct count is " + correctCount + " of " + statecapital.length);
    }

}
