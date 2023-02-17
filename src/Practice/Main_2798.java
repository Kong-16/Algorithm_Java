package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// n이 100까지, 고르는 숫자가 3이므로
// 100C3인 161700이 최대 연산수.
// 완전탐색으로 풀 수 있음
public class Main_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int maxNum = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int score = arr[i] + arr[j] + arr[k];
                    if (0 <= (m - score) && (m - score) < maxNum) {
                        maxNum = m - score;
                        ans = score;
                    }
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}