package TwoPointer;

/*
 * 4반에서 한 명씩 뽑는 경우의 수를 하게되면 N^4로 시간초과 발생.
 * => 2반에서 한 명씩 뽑아서 2반끼리 합침. N^2
 * 이후 투포인터 사용해서 12반 s출발 , 34반 e출발로 검색
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9007 {
    public static int n;
    public static int k;
    public static int s;
    public static int e;
    public static int weight;
    public static int ans;

    public static int[] getClass(int[] arr, StringTokenizer st) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tmp[i] = Integer.parseInt(st.nextToken());

        return tmp;
    }

    public static int[] combineClass(StringTokenizer st1, StringTokenizer st2) {
        int[] class1 = new int[n];
        int[] class2 = new int[n];
        class1 = getClass(class1, st1);
        class2 = getClass(class2, st2);
        int[] combinedClass = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                combinedClass[(n * i) + j] = class1[i] + class2[j];
            }
        }
        Arrays.sort(combinedClass);
        return combinedClass;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(bf.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int[] class12 = new int[n * n];
            int[] class34 = new int[n * n];
            class12 = combineClass(new StringTokenizer(bf.readLine()), new StringTokenizer(bf.readLine()));
            class34 = combineClass(new StringTokenizer(bf.readLine()), new StringTokenizer(bf.readLine()));
            s = 0;
            e = n * n - 1;
            ans = Integer.MAX_VALUE;
            while (s < n * n && 0 <= e) {
                weight = class12[s] + class34[e];
                if (k < weight)
                    e--;
                else
                    s++;
                if (Math.abs(k - weight) < Math.abs(k - ans))
                    ans = weight;
                else if (Math.abs(k - weight) == Math.abs(k - ans))
                    ans = weight < ans ? weight : ans;

            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
    }

}
