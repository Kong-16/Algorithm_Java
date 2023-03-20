package BinarySearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lines = new int[k];
        long start = 1;
        long end = 0;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, lines[i]);
        }
        long ans = start;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += lines[i] / mid;
            }
            if (cnt < n) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

}
