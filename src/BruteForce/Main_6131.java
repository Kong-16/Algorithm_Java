package BruteForce;
import java.io.*;

public class Main_6131 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int ans = 0;

        for (int b = 1; b <= 500; b++) {
            for (int a = 1; a <= 500; a++) {
                if (b * b + N == a * a)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
