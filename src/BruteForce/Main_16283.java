package BruteForce;
import java.util.*;
import java.io.*;

public class Main_16283 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int sheep = 0;
        for (int i = 1; i < n; i++) {
            if (a * i + b * (n - i) == w) {
                if (sheep != 0) {
                    sheep = -1;
                    break;
                } else
                    sheep = i;
            }
        }
        if (sheep > 0)
            System.out.println(sheep + " " + (n - sheep));
        else
            System.out.println(-1);

    }
}
