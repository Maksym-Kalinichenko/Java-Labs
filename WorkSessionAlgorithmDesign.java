package work.session.algorithm.design;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author maksymkalinichenko
 */
public class WorkSessionAlgorithmDesign {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList<Character> maxlist = new LinkedList<>();
        LinkedList<Character> startlist = new LinkedList<>();

        System.out.print("Enter a word: ");
        String word = input.nextLine();

        for (int i = 0, min = word.charAt(0); i < word.length(); i++) {

            int a = word.charAt(i);

            if (min > a) {
                startlist.clear();
            }

            startlist.add(word.charAt(i));
            if (min < a) {
                min = word.charAt(i);
            }
            if (startlist.size() > maxlist.size()) {
                maxlist.clear();
                maxlist.addAll(startlist);
            }

        }

        for (Character ch : maxlist) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
