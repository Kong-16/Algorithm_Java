package NumberTheory;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long start = 1;
        int digit = 1;
        long nextDigit = 10;
        // 자릿수의 갯수만큼 k에서 빼줌.
        while (digit < k) {
            k -= digit;
            if (++start == nextDigit) {
                nextDigit *= 10;
                digit++;
            }
        }
        // start에는 k번째 수를 포함하는 숫자가 저장됨. => substr
        if (n < start) bw.write(-1 + "\n");
        else {
            String ans = Long.toString(start);
            bw.write(ans.substring(k - 1, k) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
