package study.dd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Juhwan_13164 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		if (K == N) {
			System.out.print(0);
			return;
		}

		int[] heights = new int[N];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(values[i]);
		}

		int[] diffs = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diffs[i] = heights[i + 1] - heights[i];
		}

		Arrays.sort(diffs);

		int answer = 0;
		for (int i = 0; i < N - K; i++) {
			answer += diffs[i];
		}

		System.out.print(answer);
	}
}
