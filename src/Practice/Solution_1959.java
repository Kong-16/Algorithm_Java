package Practice;
import java.io.*;
import java.util.*;

public class Solution_1959 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int a_size = Integer.parseInt(st.nextToken());
            int b_size = Integer.parseInt(st.nextToken());
            int[] a_arr = new int[a_size];
            int[] b_arr = new int[b_size];

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < a_size; i++)
                a_arr[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < b_size; i++)
                b_arr[i] = Integer.parseInt(st.nextToken());

            int large, small;
            int[] large_arr, small_arr;
            if (a_size < b_size) {
                large = b_size;
                small = a_size;
                large_arr = b_arr;
                small_arr = a_arr;
            }

            else {
                large = a_size;
                small = b_size;
                large_arr = a_arr;
                small_arr = b_arr;
            }

            int sum = 0;

            for (int i = 0; i < large - small + 1; i++) {
                int[] tmp = new int[small];
                for (int j = 0; j < small; j++) {
                    tmp[j] = large_arr[j + i] * small_arr[j];
                }
                sum = Math.max(sum, Arrays.stream(tmp).sum());
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }

}
