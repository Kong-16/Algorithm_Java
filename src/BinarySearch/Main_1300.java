package BinarySearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1300 {
    public static long n;
    public static long k;

    public static long lessEqual(long num) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            // cnt += Math.min(n, num / i);
            if (i * n <= num)
                cnt += n;
            else
                cnt += num / i;
        }
        return cnt;
    }

    public static long less(long num) {
        long cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i * n < num)
                cnt += n;
            else {
                cnt += num / i;
                if (num % i == 0)
                    cnt--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());
        long start = 0;
        long end = n * n;
        long ans = 0;
        while (start <= end) {
            // mid보다 작거나, 작거나 같은 숫자의 갯수 세봄.
            long mid = (start + end) / 2;
            // mid = 1;
            long l = less(mid);
            long le = lessEqual(mid);
            // 작거나 같은 숫자의 갯수가 k개 이상이고
            // 작은 숫자의 갯수가 k개 미만이면 정답.
            if (k <= le && l < k) {
                ans = mid;
                break;
            }
            // mid 보다 작은 숫자의 갯수가 k개 이상이면, mid가 작아져야함
            else if (k <= l) {
                end = mid - 1;
            } else
                start = mid + 1;

        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
