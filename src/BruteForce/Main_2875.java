package BruteForce;
import java.io.*;
import java.util.StringTokenizer;

public class Main_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;
        while (n > 1 && m > 0 && n + m - k >= 3) {
            // if (n + m - k < 3)
            // break;
            n -= 2;
            m--;
            ans++;
        }
        System.out.println(ans);

    }
}
