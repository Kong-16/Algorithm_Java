package NumberTheory;
/* 등차수열의 합 공식 + GCD
 * 초항 A 공차 D
 * 등차수열의 최대 공약수 : A와 D의 최대공약수
 * d = 0 일 때 고려
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_23888 {

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        int q = Integer.parseInt(bf.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int sign = Integer.parseInt(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            long ans;
            if (sign == 1) {
                ans = (r - l + 1) * a + (r - l + 1) * (r + l - 2) / 2 * d;
                bw.write(ans + "\n");
            } else {
                if (r == l)
                    bw.write(a + (l - 1) * d + "\n");
                else
                    bw.write(gcd(a, d) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}