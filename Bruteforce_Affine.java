package network.security;

/**
 *
 * @author maksymkalinichenko
 */
import java.util.Scanner;

public class Bruteforce_Affine {

    public static String Decryption(String cipherText, int key1, int key2) {
        String text = "";
        int k1 = 0;
        int flag = 0;
        
        for (int i = 0; i < 26; i++) {
            flag = (key1 * i) % 26;
            if (flag == 1) {
                k1 = i;
            }
        }
        for (int i = 0; i < cipherText.length(); i++) {
            text = text + (char) (((k1 * ((cipherText.charAt(i) + 'A' - key2)) % 26)) + 'A');
        }
        return text;
    }

    private static int findGCD(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return findGCD(a - b, b);
        }
        return findGCD(a, b - a);
    }

    private static boolean Coprime(int a, int b) {
        if (findGCD(a, b) == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        System.out.print("Write your text \"UPPER CASE\": ");
        String text = input.nextLine();

        for (int i = 0; i < 26 && flag; i++) {

            if (Coprime(i, 26)) {
                for (int j = 1; j <= 26 && flag; j++) {

                    System.out.println(i + "," + j + " : PlainText : " + Decryption(text, i, j));
                    System.out.println("Is this text makes sense?");
                    String valid = input.next();
                    if (valid.equals("YES") || valid.equals("yes")) {
                        System.out.println("PlainText : " + Decryption(text, i, j) + "\nSHIFT KEY1 = " + i + ", SHIFT KEY2 = " + j);
                        flag = false;
                    }
                }
            }
        }
        input.close();
    }
}
