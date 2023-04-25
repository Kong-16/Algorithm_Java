import java.io.*;
import java.util.*;

public class LAB {
    public static int[] a;
    public static int[] b;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        bw.flush();
//        bw.close();
        a = b = new int[3];
        for (int i = 0; i < 3; i++) a[i] = i + 1;
        System.out.println(Arrays.toString(b));


    }
}