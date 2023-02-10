package TwoPointer;

/*
 * mergesort
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        int[] mergedArr = new int[n + m];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++)
            b[i] = Integer.parseInt(st.nextToken());

        int aIter = 0;
        int bIter = 0;
        for (int i = 0; i < mergedArr.length; i++) {
            if (aIter >= n)
                mergedArr[i] = b[bIter++];
            else if (bIter >= m)
                mergedArr[i] = a[aIter++];
            else if (a[aIter] > b[bIter])
                mergedArr[i] = b[bIter++];
            else
                mergedArr[i] = a[aIter++];
        }

        for (int i = 0; i < mergedArr.length; i++) {
            bw.write(mergedArr[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

}
