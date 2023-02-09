package Prefix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w + 2];
        int[] leftPrefix = new int[w + 2];
        int[] rightPrefix = new int[w + 2];

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= w; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            leftPrefix[i] = Math.max(leftPrefix[i - 1], tmp);
        }
        for (int i = w; i > 0; i--) {
            rightPrefix[i] = Math.max(rightPrefix[i + 1], arr[i]);
        }
        int ans = 0;
        for (int i = 1; i <= w; i++) {
            ans += Math.min(rightPrefix[i], leftPrefix[i]) - arr[i];
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
