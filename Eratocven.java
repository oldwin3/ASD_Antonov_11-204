package Homework_AuCD_1;

public class Eratocven {
    public static void main(String[] args) {
        int n = 1000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        a[1] = 0;
        for (int i = 2; i < n; i++) {
            if (a[i] != 0)
                for (int j = i + i; j < n; j += i) {
                    a[j] = 0;
                }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
