package DP;

import java.io.*;
import java.util.Arrays;

public class Main_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[12][n + 1];
        for (int i = 2; i <= 10; i++) {
            arr[i][1] = 1;
        }

        int mod = 1000000000;

        for (int j = 2; j <= n; j++)
            for (int i = 1; i < 11; i++)
                arr[i][j] = (arr[i - 1][j - 1] + arr[i + 1][j - 1]) % mod;
        long ans = 0;
        for (int i = 1; i < 11; i++) {
            ans = (ans + arr[i][n]) % mod;
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

}
