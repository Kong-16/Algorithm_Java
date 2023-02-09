package NumberTheory;
/* 소인수 분해
 * 2 ~ sqrt(n) 까지 다 나눠봄.
 * 나머지가 0인 수가 있으면 더 안나눠질 때 까지 계속 나눔.
 * n은 sqrt(n) 보다 큰 소인수가 0개 혹은 1개이다. (n <=sqrt(n) * sqrt(n)  => k = sqrt(n) * sqrt(n + a)  > n)
 *  => 다 나누고 n == 1이면 sqrt(n) 보다 큰 소인수가 0개.
 *  아니면 n = sqrt(n) 보다 큰 소인수. => print
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14232 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        long k = Long.parseLong(st.nextToken());
        long[] arr = new long[(int) Math.pow(k, 0.5)];
        int it = 0;

        for (long i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                k /= i;
                arr[it++] = i;
            }
        }
        if (k != 1)
            arr[it++] = k;
        System.out.println(it);
        for (int i = 0; i < it; i++)
            System.out.print(arr[i] + " ");
    }
}
