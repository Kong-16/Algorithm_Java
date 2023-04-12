package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int max = 1000010;
        int[] arr = new int[max + 1];
        arr[max] = Integer.MAX_VALUE;
        // 각 수에 대해 연산 횟수의 최솟값 저장 후 출력.
        for (int i = 1; i <= max; i++) {
            int first = i % 3 == 0 ? i / 3 : max;
            int second = i % 2 == 0 ? i / 2 : max;
            int small = arr[first] > arr[second] ? second : first;

            arr[i] = Math.min(arr[small], arr[i - 1]) + 1;
        }
        bw.write(arr[n] - 1 + "\n");
        bw.flush();
        bw.close();

    }

}
