package DFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15650 {
    public static int n;
    public static int m;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        // 증가하는 순서이므로 작은 숫자부터 넣어봄. 넣은 뒤 다시 고려하지않음.
        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0, 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
