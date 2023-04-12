package DP;

import java.io.*;
import java.util.StringTokenizer;

class Solution_3307 {
    public static int lastIdx;
    public static int[] max;

    // find보다 작은 가장 큰 max의 idx의 값 반환.
    public static int binarySearch(int find) {
        int idx = 0;
        int start = 0;
        int end = lastIdx;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (find <= max[mid]) {
                end = mid - 1;
            } else {
                idx = mid;
                start = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            max = new int[n + 1];
            // 가장 작은 값이 들어왔을 때 예외처리를 피하기 위해 min 넣음.
            max[0] = Integer.MIN_VALUE;
            // max의 최대 길이를 저장.
            // max[i] = max[i]가 최대인 부분수열의 길이 : i
            lastIdx = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                int idx = binarySearch(num);
                max[idx + 1] = num;
                if (idx == lastIdx) {
                    lastIdx++;
                }
            }
            bw.write("#" + test_case + " " + lastIdx + "\n");
        }
        bw.flush();
        bw.close();
    }
}
