
/*
 * 투포인터 사용해 0에 가까운 값 찾기 => 절댓값이 작은 값
 * 두 수의 차가 0보다 크다면 작아져야함. => e--
 * 작다면 s++ 
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int e = n - 1;
        int ansS = 0;
        int ansE = 0;
        while (s < e) {
            int gap = arr[e] + arr[s];
            if (Math.abs(ans) > Math.abs(gap)) {
                ans = gap;
                ansS = arr[s];
                ansE = arr[e];
            }
            if (gap > 0)
                e--;
            else if (gap < 0)
                s++;
            else {
                ansS = arr[s];
                ansE = arr[e];
                break;
            }

        }
        bw.write(ansS + " " + ansE + "\n");
        bw.flush();
        bw.close();
    }
}