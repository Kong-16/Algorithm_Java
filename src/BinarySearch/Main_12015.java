package BinarySearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12015 {
    public static int n;
    public static int[] max;
    public static int lastIdx;

    // 시간 줄이기 위해 이분탐색 사용.
    public static int binarySearch(int find) {
        int start = 0;
        int end = lastIdx;
        int idx = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (max[mid] < find) {
                idx = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        max = new int[n + 1];
        max[0] = Integer.MIN_VALUE;
        lastIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // num이 max[i]보다 커지는 i 찾은 뒤 max[i+1]에 num 저장.
            // => num으로 만들 수 있는 가장 긴 부분수열의 길이 : i+1
            int num = Integer.parseInt(st.nextToken());
            int idx = binarySearch(num);
            max[idx + 1] = num;
            if (idx == lastIdx) {
                lastIdx++;
            }
        }
        bw.write(lastIdx + "\n");
        bw.flush();
        bw.close();
    }
}
