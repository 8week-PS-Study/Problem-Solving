import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static int[] nums, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nums = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.print(max);
    }
}
