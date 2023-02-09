package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static int dumpCnt;
    public static int[] arr = new int[102];
    public static int[] prefix = new int[102];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 1; test_case++) {
            dumpCnt = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            arr = new int[102];
            prefix = new int[102];
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            // dump가 충분할 때 평균의 반올림 값으로 높이를 맞추는 것이 이상적임.
            int avg = Math.round(sum / 100);
            // 나누어 떨어지면 0, 그렇지 않으면 1

            System.out.println(avg);
            Arrays.sort(arr);
            for (int i = 1; i <= 101; i++) {
                prefix[i] = arr[i] - arr[i - 1];
            }
            System.out.println(Arrays.toString(prefix));
        }

        bw.flush();
        bw.close();
    }

}
