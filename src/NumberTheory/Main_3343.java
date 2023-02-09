package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_3343 {
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long n = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        long big_flower, small_flower, big_money, small_money;
        if (a > c) {
            big_flower = a;
            big_money = b;
            small_flower = c;
            small_money = d;
        } else {
            big_flower = c;
            big_money = d;
            small_flower = a;
            small_money = b;
        }
        long result = 0;
        long mul = lcm(big_flower, small_flower);
        // small사는게 이득일 경우
        if ((mul / big_flower) * big_money > (mul / small_flower) * small_money) {
            result += (n / mul) * (mul / small_flower) * small_money;
        } else {
            result += (n / mul) * (mul / big_flower) * big_money;
        }
        n %= mul;
        long min_money = Long.MAX_VALUE;
        for (int i = 0; i <= n / big_flower; i++) {
            long tmp = i * big_money;
            long remain = n - (i * big_flower);
            if (remain % small_flower == 0)
                min_money = Math.min(result + tmp + (remain / small_flower) * small_money, min_money);
            else
                min_money = Math.min(result + tmp + ((remain / small_flower) + 1) * small_money, min_money);
        }

        bw.write(min_money + "\n");
        bw.flush();
        bw.close();

    }
}