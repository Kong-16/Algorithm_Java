/*
 * n!을 k^i로 나눴을 때 나누어 떨어지는 가장 큰 i값 구하기
 * n!에 k가 얼마나 있나? => k를 소인수분해  : x1,x2...
 * n!에 x가 얼마나 있나? => n / x + n / (x * x) + n / (x * x * x)... : nx
 * k = x1^a * x2^b ... 이므로  n!에 k가 얼마나 있나? => min (nx / a , nx / b ...)
 * 
 */

package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3964 {
    public static long getMultiplier(long number, long divisor) {
        long cnt = 0;
        while (number % divisor == 0) {
            cnt++;
            number /= divisor;
        }
        return cnt;
    }

    public static long getFactMul(long factorial, long divisor) {
        long weight = 0;
        while (factorial >= divisor) {
            weight += factorial / divisor;
            factorial /= divisor;
        }
        return weight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int test_case = 0; test_case < t; test_case++) {
            st = new StringTokenizer(bf.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long k_mul;
            long n_mul;
            long min_num = Long.MAX_VALUE;
            for (long i = 2; i * i <= k; i++) {
                if (k % i == 0) {
                    k_mul = getMultiplier(k, i);
                    n_mul = getFactMul(n, i);
                    min_num = Math.min(n_mul / k_mul, min_num);
                    while (k % i == 0)
                        k /= i;
                }
            }
            if (k != 1) {
                k_mul = 1;
                n_mul = getFactMul(n, k);
                min_num = Math.min(n_mul / k_mul, min_num);
            }
            bw.write(min_num + "\n");
        }
        bw.flush();
        bw.close();
    }
}
