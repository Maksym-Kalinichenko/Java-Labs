package network.security;

import java.util.Scanner;

/**
 *
 * @author maksymkalinichenko
 */
public class Hill_Substitution_Cipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Write your text: ");
        String text = input.nextLine();
        System.out.println("Write size mxm for matrix: ");
        int k = input.nextInt();
        int[][] keyMatrix = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.println("Write a letter for your matrix: ");
                char c = input.next().charAt(0);
                int a = (int) c;
                if (a >= 65 && a <= 90) {
                    keyMatrix[i][j] = a - 65;
                } else if (a >= 97 && a <= 122) {
                    keyMatrix[i][j] = a - 97;
                }

            }
        }
        while (text.length() % k != 0) {
            text += " ";
        }

        int p = text.length() / k;
        int[][] letterMatrix = new int[k][p];
        int flag = 0;
        int l = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < p; j++) {
                l = text.charAt(flag);

                if (l == 32 || l == 0) {
                    letterMatrix[i][j] = l;
                } else if (l >= 65 && l <= 90) {
                    letterMatrix[i][j] = l - 65;
                } else if (l >= 97 && l <= 122) {
                    letterMatrix[i][j] = l - 97;
                }

                flag++;
            }
        }

        int[][] cipherMatrix = new int[k][p];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < p; j++) {
                for (int x = 0; x < k; x++) {
                    cipherMatrix[i][j] = cipherMatrix[i][j] + (keyMatrix[i][x] * letterMatrix[x][j]);
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < p; j++) {
                char c = (char) (cipherMatrix[i][j] + 65);
                System.out.print(c);
            }
        }
        System.out.print("\n");

    }
}
