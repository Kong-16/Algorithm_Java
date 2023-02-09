package NumberTheory;
/* 소수판별
 * n을 입력받고 , n이 소수인지 확인 후 
 * 소수면 디지털 숫자로 뒤집혔을 때도 소수인 지 판별
 * 소수 판별시 2 ~ sqrt(n) 까지만 판별해 실행시간을 줄임.
 * String으로 변환해 처리해서 오래걸림.
 */

import java.io.*;

public class Main_10859 {
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
        String n = bf.readLine();
        long a = 0L;

        StringBuilder sb = new StringBuilder(n);
        a = Long.parseLong(sb.toString());
        if (!isPrime(a))
            System.out.println("no");
        else if (n.contains("3") || n.contains("4") || n.contains("7"))
            System.out.println("no");
        else {
            n = n.replace("6", "s");
            n = n.replace("9", "6");
            n = n.replace("s", "9");
            sb = new StringBuilder(n);
            a = Long.parseLong(sb.reverse().toString());
            if (!isPrime(a))
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}