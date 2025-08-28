import java.io.*;
import java.util.*;

class YoungHwan_1210 {

    private static int n, k, cnt;
    private static int[] nums;

    private static boolean isSuccess = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[12];

        dfs(0, 0, sb);
        if (isSuccess) {
            System.out.println(sb);
            return;
        }

        System.out.println("-1");
    }

    private static void dfs(int depth, int sum, StringBuilder sb) {
        if (sum > n) {
            return;
        }

        // 합이 n 인 경우
        if (sum == n) {
            cnt++;
            if (cnt == k) {
                isSuccess = true;
                for (int i = 0; i < depth - 1; i++) {
                    sb.append(nums[i]).append("+");
                }
                sb.append(nums[depth - 1]);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            nums[depth] = i;
            dfs(depth + 1, sum + i, sb);
        }
    }
}
