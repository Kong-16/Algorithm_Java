package NumberTheory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2023 {
    public static boolean[] arr;

    // 소수판별 -> 2부터 n ^1/2 까지 나눠봄.
    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int cipher = (int) Math.pow(10, n);
        // 10^(n-1) ~ 10^n 까지
        for (int i = cipher / 10; i < cipher; i++) {
            // 실행을 줄이기 위해 앞자리부터 소수판별해야함.
            // ex) 7331 : 7 -> 73 -> 733 -> 7331
            int weight = cipher / 10;
            boolean isAmazing = true;
            while (weight > 0) {
                // => i를 자릿수로 나눔. 나눈 수가 소수면 자릿수 / 10 으로 한자리 내려서 다시 검사.
                if (!isPrime(i / weight)) {
                    isAmazing = false;
                    break;
                }
                weight /= 10;
            }
            if (isAmazing)
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

}
