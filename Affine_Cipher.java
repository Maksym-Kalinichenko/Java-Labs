package network.security;

import java.util.Scanner;

/**
 *
 * @author maksymkalinichenko
 */
public class Affine_Cipher {

    /**
     * @param args the command line arguments
     */
    public static void Encryption() {
        Scanner input = new Scanner(System.in);
        System.out.print("Write your text \"LOWER CASE\": ");
        String text = input.nextLine();
        System.out.println("Write your key1: ");
        int k1 = input.nextInt();
        System.out.println("Write your key2: ");
        int k2 = input.nextInt();

        for (int i = 0, min = text.charAt(0); i < text.length(); i++) {

            int a = text.charAt(i);
            if (a != 32) {
                a = a - 97;
                a = (((a * k1) + k2) % 26);
                a = a + 65;
                char c = (char) a;
                System.out.print(c);
            } else {
                System.out.print(" ");
            }
        }
    }

    public static void Decryption() {
        int flag = 0, inv = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Write your text \"UPPER CASE\": ");

        String text = input.nextLine();
        System.out.println("Write your key1: ");

        int k1 = input.nextInt();
        System.out.println("Write your key2: ");

        int k2 = input.nextInt();

        for (int i = 0; i < 26; i++) {
            flag = (k1 * i) % 26;

            if (flag == 1) {
                inv = i;
            }
        }

        for (int i = 0, min = text.charAt(0); i < text.length(); i++) {

            int a = text.charAt(i);
            if (a != 32) {
                a = a - 65;
                a = ((a - k2) * inv);
                if (a < 0) {
                    a = a + 26;
                } else {
                    a = a % 26;
                }
                a = a + 97;
                char c = (char) a;
                System.out.print(c);
            } else {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        int num1;

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("0 - Exit; 1 - Encryption; 2 - Decryption");
            num1 = input.nextInt();
        } while (num1 < 0 || 2 < num1);

        if (num1 == 0) {
            System.exit(0);
        }
        if (num1 == 1) {
            Encryption();
        } else {
            Decryption();
        }
        System.out.println("\n");
    }
}
