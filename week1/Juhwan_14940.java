package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14940
class Juhwan_14940 {

	static int n;
	static int m;
	static int[] goal = new int[2];
	static int[][] map;
	static int[][] distances;

	public static void main(String[] args) throws IOException {
		getInput();
		solve();
	}

	static void solve() {
		bfs(goal[0], goal[1]);
		print();
	}

	static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	static void bfs(int sourceRow, int sourceColumn) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {sourceRow, sourceColumn});
		distances[sourceRow][sourceColumn] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int[] direction : directions) {
				int nextRow = cur[0] + direction[0];
				int nextColumn = cur[1] + direction[1];

				if (isOutOfBoundary(nextRow, nextColumn) || map[nextRow][nextColumn] != 1 || distances[nextRow][nextColumn] != -1) continue;

				distances[nextRow][nextColumn] = distances[cur[0]][cur[1]] + 1;
				queue.offer(new int[] {nextRow, nextColumn});
			}
		}
	}

	static boolean isOutOfBoundary(int r, int c) {
		return r < 0 || r >= n || c < 0 || c >= m;
	}

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < n; row++) {
			for (int column = 0; column < m; column++) {
				int value = distances[row][column];
				if (distances[row][column] == -1 && map[row][column] == 0) value = 0;
				sb.append(value).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		distances = new int[n][m];

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int column = 0; column < m; column++) {
				distances[row][column] = -1;
				map[row][column] = Integer.parseInt(st.nextToken());
				if (map[row][column] == 2) {
					goal[0] = row;
					goal[1] = column;
				}
			}
		}
	}
}
