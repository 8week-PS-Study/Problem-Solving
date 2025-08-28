import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] nums, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        answer = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int sum = nums[start] + nums[end];
            int abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                answer[0] = nums[start];
                answer[1] = nums[end];
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
