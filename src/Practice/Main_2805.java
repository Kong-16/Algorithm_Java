package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (end < trees[i])
                end = trees[i];
        }
        while (start < end) {
            int mid = (start + end) / 2;
            long sum = 0;
            for (int t : trees) {
                if (0 < t - mid)
                    sum += (t - mid);
            }
            if (sum < m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        bw.write(start - 1 + "\n");
        bw.flush();
        bw.close();
    }
}
