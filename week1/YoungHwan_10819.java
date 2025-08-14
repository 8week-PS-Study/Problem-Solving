package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YoungHwan_10819 {

    private static int n;
    private static int answer = Integer.MIN_VALUE;

    private static int[] A, selected;
    private static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        selected = new int[n];
        used = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(answer);
    }

    private static void permutation(int depth) {
        // 모든 숫자 선택 완료. 순열 완성
        if (depth == n) {
            updateMaxResult();
            return;
        }

        // 순열 생성
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            selected[depth] = A[i];
            permutation(depth + 1);
            used[i] = false;
        }
    }

    private static void updateMaxResult() {
        int result = 0;
        for (int i = 1; i < n; i++) {
            result += Math.abs(selected[i] - selected[i - 1]);
        }
        answer = Math.max(answer, result);
    }
}
