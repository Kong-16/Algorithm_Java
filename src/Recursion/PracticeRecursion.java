package Recursion;
import java.io.IOException;

public class PracticeRecursion {
    static int arr[] = { 10, 20, 30 };
    static int n = 1;
    static int ans = 1;

    private static void printArray(int i) {
        if (i == arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[i] + "\t");
        printArray(i + 1);
    }

    public static int choose(int n, int k) {
        if (k == 1)
            return (n / k);
        return choose(n - 1, k - 1) * n / k;
    }

    public static void hanoi(int start, int mid, int end, int goal, int target) {
        if (goal == target)
            return;
        hanoi(start, end, mid, goal - 1, target);
        System.out.println(start + " -> " + end);
        hanoi(mid, end, start, 1, target);
    }

    public static void main(String[] args) throws IOException {
        printArray(0);
        System.out.println(choose(7, 3));
        hanoi(1, 2, 3, 3, 1);
    }

}
