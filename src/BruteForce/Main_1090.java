package BruteForce;

/*
 * 완전탐색.
 * 중간 값이 될 수 있는 점 : x 점들의 좌표 중 하나 , y 점들의 좌표 중 하나 (중간 값)
 * x와 y좌표들을 받은 뒤, 가능한 x y 좌표들에 대해 해당 점으로 체커들을 옮겨봄.
 * 최솟값 저장
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1090 {
    public static int n;
    public static int[] axisX;
    public static int[] axisY;
    public static ArrayList<Pair> points;

    public static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 점 (x1,y1)에 가까운 순서대로 정렬 후 num 개 만큼 이동시킴.
    public static int go2Point(int x1, int y1, int num) {
        int cnt = 0;
        points.sort((a, b) -> {
            int distA = Math.abs(x1 - a.x) + Math.abs(y1 - a.y);
            int distB = Math.abs(x1 - b.x) + Math.abs(y1 - b.y);
            return distA - distB;
        });
        for (int i = 0; i < num; i++) {
            Pair p = points.get(i);
            cnt += Math.abs(x1 - p.x);
            cnt += Math.abs(y1 - p.y);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        // x 와 y 좌표의 배열
        axisX = new int[n];
        axisY = new int[n];
        // 정답 저장할 배열
        int ans[] = new int[n + 1];
        points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            axisX[i] = Integer.parseInt(st.nextToken());
            axisY[i] = Integer.parseInt(st.nextToken());
            points.add(new Pair(axisX[i], axisY[i]));
        }

        // 1개 ~ n개까지의 체커를 옮겨봄.
        for (int k = 1; k <= n; k++) {
            int tmpMin = Integer.MAX_VALUE;
            // x좌표, y좌표들에 대해 옮겨봄.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmpMin = Math.min(tmpMin, go2Point(axisX[i], axisY[j], k));
                }
            }
            // 최솟값 저장
            ans[k] = tmpMin;
        }
        for (int i = 1; i <= n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
