package lottery;

/**
 *
 * @author maksymkalinichenko
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Lottary {

    public static void main(String args[]) {

        int lot_num = (int) (Math.random() * 1000);
        int user_num = 0, flag = 0;

        List<Integer> lot_list = new ArrayList<Integer>();
        List<Integer> user_list = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);

        while (flag == 0) {
            System.out.println("Enter your lottery pick (three digits): ");
            user_num = input.nextInt();
            if (user_num > 99 && user_num < 1000) {
                flag = 1;
            } else {
                System.out.println("Error!");
            }
        }

        int lot_num1 = lot_num / 100;
        lot_list.add(lot_num1);
        int lot_num2 = (lot_num % 100) / 10;
        lot_list.add(lot_num2);
        int lot_num3 = lot_num % 10;
        lot_list.add(lot_num3);

        int user_num1 = user_num / 100;
        user_list.add(user_num1);
        int user_num2 = (user_num % 100) / 10;
        user_list.add(user_num2);
        int user_num3 = user_num % 10;
        user_list.add(user_num1);

        Collections.sort(user_list);
        Collections.sort(lot_list);

        System.out.println("Lottery number: " + lot_num);

        if (user_num == lot_num) {
            System.out.println("You have matched all the numbers in order! You win $10,000");
        } else if (lot_list.contains(user_num1) && lot_list.contains(user_num2) && lot_list.contains(user_num3)) {
            System.out.println("You have matched all the numbers! You win $3,000");
        } else if ((lot_list.contains(user_num1) && lot_list.contains(user_num2)) || (lot_list.contains(user_num1) && lot_list.contains(user_num3)) || (lot_list.contains(user_num3) && lot_list.contains(user_num2))) {
            System.out.println("You have matched ецщ numbers! You win $2,000");
        } else if (lot_list.contains(user_num1) || lot_list.contains(user_num2) || lot_list.contains(user_num3)) {
            System.out.println("You have matched 1 number! You win $1,000");
        } else {
            System.out.println("You lose! You win $0");
        }

    }
}
