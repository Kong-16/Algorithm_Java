package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_15650 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int m;
    public static int[] input;
    public static int[] arr;

    public static void choose(int cnt, int start) throws IOException {
        if (cnt == m) {
            for (int i = 0; i < m; i++)
                bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            arr[cnt] = input[i];
            choose(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }
        choose(0, 0);

        bw.flush();
        bw.close();
    }
}