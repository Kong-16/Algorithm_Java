package Prefix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] prefix = new int[n + 1];
        st = new StringTokenizer(bf.readLine());

        // arr = input 배열
        // prefix에 arr[0] ~ arr[i] 까지의 합 저장.
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }
        // arr[i] ~ arr[j] 의 합 = arr[j] 까지의 합 - arr[i - 1]까지의 합
        // => prefix[j] - prefix[i - 1]
        for (int test_case = 0; test_case < m; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write(prefix[j] - prefix[i - 1] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
