package Homework_AuCD_1;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число x: ");
        int x = scanner.nextInt();
        System.out.print("Введите степень n: ");
        int n = scanner.nextInt();
        int result = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }

        System.out.println(result);
    }
}

