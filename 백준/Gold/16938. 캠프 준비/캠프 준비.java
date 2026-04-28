import java.util.*;

public class Main {
    static int N, L, R, X;
    static int[] A;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        X = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 모든 부분집합 탐색
        for (int i = 0; i < (1 << N); i++) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = 0;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += A[j];
                    min = Math.min(min, A[j]);
                    max = Math.max(max, A[j]);
                    count++;
                }
            }

            if (count >= 2) {
                if (sum >= L && sum <= R && (max - min) >= X) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}