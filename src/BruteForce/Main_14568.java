package BruteForce;
import java.io.*;

public class Main_14568 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int a, b, c;
        int ans = 0;

        for (a = 2; a <= N; a += 2) {
            for (b = 1; b <= (N / 2) - 2; b++) {
                for (c = b + 2; a + b + c <= N; c++) {
                    if (a + b + c == N)
                        ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
