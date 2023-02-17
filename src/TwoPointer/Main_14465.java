package TwoPointer;

/*
 * 슬라이딩 윈도우.
 * 투포인터로 전체 범위 순회 하면서 최솟값 저장.
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 0; i < b; i++)
            arr[Integer.parseInt(bf.readLine())] = 1;

        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            cnt += arr[i];
        }

        int minNum = cnt;
        int s = 1;
        int e = k + 1;

        for (; e <= n; e++) {
            cnt += arr[e] - arr[s++];
            minNum = Math.min(cnt, minNum);
        }
        bw.write(minNum + "\n");
        bw.flush();
        bw.close();
    }
}
