package TwoPointer;

/*
 * 모든 n을 순회.
 * 거리가 좁혀지는 쪽으로 순회. start ->  <- end 
 * s / e 중 min값의 위치 옮김.
 * 거리가 좁혀지므로 min이 커질 때만 능력치 변동있음
 * min 값이 커질 때, 능력치가 커지는지 검사 후 
 * 능력치가 커지면, 저장 후 다음 min값 움직임. 
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int s = 0;
        int e = n - 1;

        int prev = arr[s] < arr[e] ? arr[s] : arr[e];
        int prevAbility = prev * (e - s - 1);
        while (e - s > 1) {
            if (arr[s] < arr[e]) {
                s++;
                if (prev < arr[s] && Math.min(arr[s], arr[e]) * (e - s - 1) > prevAbility) {
                    prev = arr[s] < arr[e] ? arr[s] : arr[e];
                    prevAbility = prev * (e - s - 1);
                }
            } else {
                e--;
                if (prev < arr[e] && Math.min(arr[s], arr[e]) * (e - s - 1) > prevAbility) {
                    prev = arr[s] < arr[e] ? arr[s] : arr[e];
                    prevAbility = prev * (e - s - 1);
                }
            }
        }

        bw.write(prevAbility + "\n");
        bw.flush();
        bw.close();
    }

}
