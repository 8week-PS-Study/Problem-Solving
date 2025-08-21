package study.dd;

import java.util.Scanner;

public class Juhwan_1182 {

	static int N;
	static int S;
	static int answer;
	static int[] values;

	public static void main(String[] args) {
		getInput();
		solve();
	}

	static void solve() {
		dfs(0, 0);
		System.out.print(S == 0 ? answer - 1 : answer);
	}

	static void dfs(int start, int sum) {
		if (start == N) {
			if (sum == S) answer++;
			return;
		}

		dfs(start + 1, sum + values[start]);
		dfs(start + 1, sum);
	}

	static void getInput() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		values = new int[N];
		for (int i = 0; i < N; i++) {
			values[i] = sc.nextInt();
		}
	}
}
