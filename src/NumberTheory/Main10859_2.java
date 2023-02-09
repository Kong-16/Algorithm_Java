package NumberTheory;
/* 실행시간이 줄을 것으로 예상했지만 오히려 늘어남.
 * 아마 한자리씩 처리하는 것이 String의 replace보다 효율이 안좋을 것으로 예상됨.
 * 
 */

import java.io.*;

public class Main10859_2 {
    public static boolean isPrime(long num) {
        if (num == 1)
            return false;
        for (long i = 2; i * i <= num; i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bf.readLine());
        long reverseN = 0;
        if (!isPrime(n))
            System.out.println("no");
        else {
            while (n >= 1) {
                long mod = n % 10;
                if (mod == 3 || mod == 4 || mod == 7) {
                    reverseN = 1;
                    break;
                } else if (mod == 6)
                    reverseN = (reverseN * 10) + 9;
                else if (mod == 9)
                    reverseN = (reverseN * 10) + 6;
                else
                    reverseN = (reverseN * 10) + mod;
                n /= 10;
            }
            if (!isPrime(reverseN))
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}