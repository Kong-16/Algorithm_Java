package DFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14888 {
    public static int n;
    public static int maxNum = Integer.MIN_VALUE;
    public static int minNum = Integer.MAX_VALUE;
    public static int[] num;
    public static int[] op;
    public static int[] equation;

    public static void dfs(int depth) {
        if (depth == n - 1) {
            int sum = num[0];
            for (int i = 1; i < n; i++) {
                // 각 연산자에 해당하는 연산 수행
                switch (equation[i - 1]) {
                    case 0:
                        sum += num[i];
                        break;
                    case 1:
                        sum -= num[i];
                        break;
                    case 2:
                        sum *= num[i];
                        break;
                    case 3:
                        sum /= num[i];
                        break;
                }
            }
            minNum = Math.min(minNum, sum);
            maxNum = Math.max(maxNum, sum);
            return;
        }
        // 연산자가 남아있으면 해당 연산자를 자리에 넣음.
        // 해당 연산자의 남은 갯수를 줄이고(사용 처리) 다음 재귀로 넘어간 뒤 재귀 끝나면 다시 갯수 늘려줌 (미사용 처리)
        for (int i = 0; i < 4; i++) {
            if (0 < op[i]) {
                equation[depth] = i;
                op[i] = op[i] - 1;
                dfs(depth + 1);
                op[i] = op[i] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        op = new int[4];
        equation = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(maxNum + "\n");
        bw.write(minNum + "\n");
        bw.flush();
        bw.close();
    }
}