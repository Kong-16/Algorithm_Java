package BruteForce;
import java.io.*;
import java.util.*;

public class Main_14697 {
    public static void solve(int a, int b, int c, int n) {
        // for (int i = 0; i <= (n / c) + 1; i++) {
        // int minus_c = n - (c * i);
        // for (int j = 0; j <= (minus_c / b) + 1; j++) {
        // int minus_b = minus_c - (b * j);
        // for (int k = 0; k <= (minus_b / c) + 1; k++) {
        // if (minus_b - (a * k) == 0) {
        // System.out.println(1);
        // return;
        // }
        // }
        // }
        // }

        for (int i = (n / c); i >= 0; i--) {
            int minus_c = n - (c * i);
            for (int j = (minus_c / b); j >= 0; j--) {
                int minus_b = minus_c - (b * j);
                for (int k = (minus_b / a); k >= 0; k--) {
                    if (minus_b - (a * k) == 0) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        System.out.println(0);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        solve(a, b, c, n);

    }
}
