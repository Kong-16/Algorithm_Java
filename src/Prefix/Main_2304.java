package Prefix;
/*
 * prefix에 왼쪽에서 본 기둥 높이의 최댓값
 * suffix에 오른쪽에서 본 기둥 높이의 최댓값
 * min[i]에 prefix[i]와 suffix[i]중 작은 값
 * => 덮을 수 있는 기둥 중 최소 높이
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2304 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> sufix = new ArrayList<>();
        prefix.add(0);
        sufix.add(0);

        for (int i = 1; i <= n; i++) {
            prefix.add(Math.max(prefix.get(i - 1), arr[i][1]));
            sufix.add(Math.max(sufix.get(i - 1), arr[n + 1 - i][1]));
        }
        Collections.reverse(sufix);
        int[] min = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            min[i] = Math.min(prefix.get(i), sufix.get(i - 1));
            arr[i][1] = min[i];
        }
        int start = arr[1][0];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i][1] < arr[i + 1][1]) {
                sum += (arr[i + 1][0] - start) * arr[i][1];
                start = arr[i + 1][0];

            } else if (arr[i][1] > arr[i + 1][1]) {
                sum += (arr[i][0] + 1 - start) * arr[i][1];
                start = arr[i][0] + 1;
            }
        }
        sum += (arr[n][0] + 1 - start) * arr[n][1];
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
