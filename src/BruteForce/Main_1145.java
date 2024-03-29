package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1145 {
    public static void solve(int... arr) {
        int num = 1;
        while (true) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (num % arr[i] == 0) {
                    if (++cnt >= 3) {
                        System.out.println(num);
                        return;
                    }
                }
            }
            num++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        solve(arr);
    }

}
