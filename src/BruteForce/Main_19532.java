package BruteForce;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19532 {
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(bf.readLine());
        var a = Integer.parseInt(st.nextToken());
        var b = Integer.parseInt(st.nextToken());
        var c = Integer.parseInt(st.nextToken());
        var d = Integer.parseInt(st.nextToken());
        var e = Integer.parseInt(st.nextToken());
        var f = Integer.parseInt(st.nextToken());
        int x, y;
        y = ((a * f) - (c * d)) / ((a * e) - (b * d));
        x = ((c * e) - (b * f)) / ((a * e) - (b * d));

        System.out.println(x + " " + y);
    }
}
