package BinarySearch;

/*
 * 매개변수 탐색, 구하려는 답이 ans라고 가정하고 구해지는지 시도해봄.
 * ans의 범위를 0~Max 로 하고 이분탐색.
 * ans가 홀수 개이므로 ans보다 작은 것의 갯수를 세었을 때,
 * ans 전까지는 짝수 개, ans 부터는 홀수 개 나와야함. 
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1637 {
    public static int n;
    public static long[][] numArr;

    public static long lessEqual(long num) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            long d = numArr[i][2];
            long minNum = numArr[i][0] - d;
            long maxNum = numArr[i][1];
            maxNum = Math.min(num, maxNum);
            if (minNum < maxNum)
                cnt += ((maxNum - minNum) / d);
        }
        return cnt;
    }

    public static long less(long num) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            long d = numArr[i][2];
            long minNum = numArr[i][0] - d;
            long maxNum = numArr[i][1];
            maxNum = Math.min(num - 1, maxNum);
            if (minNum < maxNum)
                cnt += ((maxNum - minNum) / d);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        numArr = new long[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                numArr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        long start = 0;
        long end = Integer.MAX_VALUE;
        long ans = 0;
        long cnt = 0;
        while (start <= end) {
            // mid의 갯수 세봄
            long mid = (start + end) / 2;
            // mid가 홀수 개라면, mid 보다 작은 갯수는 짝수, mid 포함하면 홀수
            long l = less(mid);
            long le = lessEqual(mid);
            if (l % 2 == 0 && le % 2 == 0) {
                start = mid + 1;
            } else if (l % 2 == 1 && le % 2 == 1) {
                end = mid - 1;
            } else if (l % 2 == 0 && le % 2 == 1) {
                ans = mid;
                cnt = le - l;
                break;
            }

        }
        if (0 < ans)
            bw.write(ans + " " + cnt + "\n");
        else
            bw.write("NOTHING \n");
        bw.flush();
        bw.close();
    }

}
