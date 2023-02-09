package Prefix;
/*
 * 구간 update를 위해 시작지점에 +, 끝지점에 - 를 해서 누적합 구함.
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] arr = new int[h + 1];
        int[] prefix = new int[h + 1];
        arr[1] = n / 2;
        for (int i = 1; i <= n; i += 2) {
            int bottom = Integer.parseInt(bf.readLine());
            int top = Integer.parseInt(bf.readLine());
            arr[bottom + 1]--;
            arr[h - top + 1]++;
        }
        int min_num = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
            if (min_num > prefix[i]) {
                min_num = prefix[i];
                cnt = 0;
            }
            if (prefix[i] == min_num)
                cnt++;
        }
        bw.write(min_num + " " + cnt + "\n");
        bw.flush();
        bw.close();
    }

}
