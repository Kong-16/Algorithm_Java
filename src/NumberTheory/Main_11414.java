package NumberTheory;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11414 {

    public static long GCD(long a, long b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    // 소인수 분해
    public static ArrayList<Long> factorizate(long n) {
        ArrayList<Long> fact = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                fact.add(i);
                if (i * i != n) fact.add(n / i);
            }
        }
        return fact;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        // a 가 더 큰 수로 올 수 있도록 함.
        if (a < b) {
            long tmp = b;
            b = a;
            a = tmp;
        }

        long MIN = Long.MAX_VALUE;
        long ans = 0;
        // GCD(a+n,b+n) == GCD(b+n,a-b)
        // => a-b로 만들 수 있는 공약수 중에서 LCM을 가장 작게 만들 수 있는 수를 만드는 n을 구함.
        ArrayList<Long> fact = factorizate(a - b);
        // i => 공약수
        for (long i : fact) {
            // GCD(b+n, a-b) = i가 되는 n 구함 => b 보다 큰 가장 작은 i의 배수 = b+n 이면 됨.
            // i * ( x / i ) : x 이하의 가장 큰 i의 배수
            // b보다 큰 가장 작은 i의 배수 : b + n
            long n = (i * (b / i)) + i - b;
            long mul = (a + n) * (b + n);
            if (mul % i == 0 && mul / i < MIN) {
                MIN = mul / i;
                ans = n;
            }
        }
        if (a == b) ans = 1;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
