package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Juhwan_2470 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] solutions = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(solutions);

		int diff = Integer.MAX_VALUE;
		int[] answer = new int[2];
		int l = 0, r = N - 1;
		while (l < r) {
			int sum = solutions[l] + solutions[r];
			if (Math.abs(sum) < diff) {
				diff = Math.abs(sum);
				answer[0] = solutions[l];
				answer[1] = solutions[r];
			}

			if (sum > 0) r--;
			else l++;
		}

		System.out.print(answer[0] + " " + answer[1]);
	}
}
