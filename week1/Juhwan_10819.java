package week1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10819
class Juhwan_10819 {

	static int answer;
	static int n;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		recur(0, 0, 0);
		System.out.print(answer);
	}

	static void recur(int depth, int prev, int sum) {
		if (depth == n) {
			answer = Integer.max(sum, answer);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;

			visited[i] = true;
			int add = depth != 0 ? Math.abs(prev - arr[i]) : 0;
			recur(depth + 1, arr[i], sum + add);
			visited[i] = false;
		}
	}
}