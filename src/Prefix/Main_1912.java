package Prefix;

/* 
 * prefix[i] 에 arr[i]와 prefix[i -1] + arr[i]비교해서 큰 값 넣음
 * => 이전까지의 최댓값보다 현재 값이 크면 현재부터 더함.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1912 {
    public static int n;
    public static int[] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        prefix = new int[n + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            prefix[i] = Math.max(input, input + prefix[i - 1]);
            ans = Math.max(ans, prefix[i]);
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
