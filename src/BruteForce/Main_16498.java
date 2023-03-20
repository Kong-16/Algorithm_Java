package BruteForce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arrA = new int[a];
        int[] arrB = new int[b];
        int[] arrC = new int[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++)
            arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++)
            arrB[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++)
            arrC[i] = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a; i++) {
            int aPick = arrA[i];
            for (int j = 0; j < b; j++) {
                int bPick = arrB[j];
                for (int k = 0; k < c; k++) {
                    int cPick = arrC[k];
                    int tmpMax = Math.max(aPick, Math.max(bPick, cPick));
                    int tmpMin = Math.min(aPick, Math.min(bPick, cPick));
                    ans = Math.min(ans, Math.abs(tmpMax - tmpMin));
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();

    }

}
