package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Juhwan_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());
		int[] numbers = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 1;
		int[] dp = new int[len];
		Arrays.fill(dp, 1);
		for (int i = 1; i < len; i++) {
			int cur = numbers[i];
			for (int j = 0; j < i; j++) {
				if (numbers[j] < cur) {
					dp[i] = Integer.max(dp[j] + 1, dp[i]);
					answer = Integer.max(answer, dp[i]);
				}
			}
		}

		System.out.print(answer);
	}
}
