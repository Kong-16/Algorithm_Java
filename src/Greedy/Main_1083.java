package Greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            if (s <= 0)
                break;
            int start = i;
            int maxNum = 0;
            int maxIt = i;
            while (start <= s + i && start < n) {
                if (maxNum < arr[start]) {
                    maxNum = arr[start];
                    maxIt = start;
                }
                start++;
            }

            s -= (maxIt - i);
            while (i < maxIt) {
                int tmp = arr[maxIt];
                arr[maxIt] = arr[maxIt - 1];
                arr[maxIt - 1] = tmp;
                maxIt--;
            }
        }
        for (int i = 0; i < n; i++)
            bw.write(arr[i] + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
    }

}
