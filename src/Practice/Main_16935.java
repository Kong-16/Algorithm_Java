package Practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main_16935 {
    public static int n;
    public static int m;
    public static int r;

    public static int[][] arr;
    public static int[][] workSpace;


    // 모든 함수 실행후 synchronize 함수를 통해 두 배열을 같게 해주어서 이후 연산 가능케함.
    // clone 혹은 = 연산자로 배열 복사시 주솟값을 가져옴 (얕은복사)
    // => 깊은 복사해야함
    public static void synchronize() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = workSpace[i][j];
            }
        }
    }

    // 상하반전
    public static void inverse() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[n - 1 - i][j] = arr[i][j];
            }
        }
        synchronize();
    }

    //좌우반전
    public static void reverse() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[i][m - 1 - j] = arr[i][j];
            }
        }
        synchronize();
    }

    //90도 회전. n x m 배열이 m x n 배열이 되므로 n과 m 바꿔줌.
    public static void rotate90() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[j][n - 1 - i] = arr[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;
        synchronize();
    }

    //-90도 회전. n x m 배열이 m x n 배열이 되므로 n과 m 바꿔줌.
    public static void rotate270() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                workSpace[m - 1 - j][i] = arr[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;
        synchronize();
    }

    //부분 배열 90도 회전
    public static void pushPartArr90() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2) {
                    if (j < m / 2) {
                        workSpace[i][j] = arr[i + n / 2][j];
                    } else {
                        workSpace[i][j] = arr[i][j - m / 2];
                    }
                } else if (j < m / 2) {
                    workSpace[i][j] = arr[i][j + m / 2];
                } else {
                    workSpace[i][j] = arr[i - n / 2][j];
                }
            }
        }
        synchronize();
    }

    //부분 배열 -90도 회전
    public static void pushPartArr270() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i < n / 2) {
                    if (j < m / 2) {
                        workSpace[i][j] = arr[i][j + m / 2];
                    } else {
                        workSpace[i][j] = arr[i + n / 2][j];
                    }
                } else if (j < m / 2) {
                    workSpace[i][j] = arr[i - n / 2][j];
                } else {
                    workSpace[i][j] = arr[i][j - m / 2];
                }
            }
        }
        synchronize();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int big = n > m ? n : m;
        arr = new int[big][big];
        workSpace = new int[big][big];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int t = 0; t < r; t++) {
            switch (Integer.parseInt(st.nextToken())) {
                // 1 ~ 6번까지 연산 함수화
                case 1:
                    inverse();
                    break;
                case 2:
                    reverse();
                    break;
                case 3:
                    rotate90();
                    break;
                case 4:
                    rotate270();
                    break;
                case 5:
                    pushPartArr90();
                    break;
                case 6:
                    pushPartArr270();
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}