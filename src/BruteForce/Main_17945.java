package BruteForce;
import java.util.*;
import java.io.*;

public class Main_17945 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans1, ans2;
        int root = (int) Math.sqrt((A * A) - B);
        ans1 = -A + root;
        ans2 = -A - root;
        if (ans1 < ans2)
            System.out.println(ans1 + " " + ans2);
        else if (ans1 == ans2)
            System.out.println(ans1);
        else
            System.out.println(ans2 + " " + ans1);

    }
}