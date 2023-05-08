import java.io.*;
import java.util.StringTokenizer;

public class Main_1208 {
    public static int n, s, l1, l2, frontSum, ans;
    public static int[] arr;

    public static void dfsFront(int depth, int total) {
        if (depth == l1) {
            frontSum = total;
            dfsBack(depth, 0);
            return;
        }
        dfsFront(depth + 1, total + arr[depth]);
        dfsBack(depth, total);
    }

    public static void dfsBack(int depth, int total) {
        if (depth == n) {
            if (total == s) ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

    }
}
