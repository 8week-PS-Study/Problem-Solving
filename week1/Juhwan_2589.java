package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

// https://www.acmicpc.net/problem/2589
class Juhwan_2589 {

	static int answer;
	static int width;
	static int height;
	static char[][] map;
	static int[][] distances;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		getInput();
		solve();
	}

	static void solve() {
		for (int row = 0; row < width; row++) {
			for (int column = 0; column < height; column++) {
				if ('L' == map[row][column]) {
					distances = new int[width][height];
					visited =  new boolean[width][height];
					bfs(row, column);
				}
			}
		}

		System.out.print(answer);
	}

	static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static void bfs(int row, int column) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {row, column});
		visited[row][column] = true;
		distances[row][column] = 0;

		int max = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int[] direction : directions) {
				int nextRow = cur[0] + direction[0];
				int nextColumn = cur[1] + direction[1];

				if (isOutOfBoundary(nextRow, nextColumn) || visited[nextRow][nextColumn] || 'W' == map[nextRow][nextColumn]) continue;

				queue.offer(new int[] {nextRow, nextColumn});
				visited[nextRow][nextColumn] = true;
				distances[nextRow][nextColumn] = distances[cur[0]][cur[1]] + 1;
				max = distances[nextRow][nextColumn];
			}

		}
		answer = Integer.max(answer, max);
	}

	static boolean isOutOfBoundary(int r, int c) {
		return r < 0 || r >= width || c < 0 || c >= height;
	}

	static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] wh = br.readLine().split(" ");
		width = Integer.parseInt(wh[0]);
		height = Integer.parseInt(wh[1]);
		map = new char[width][height];

		for (int row = 0; row < width; row++) {
			map[row] = br.readLine().toCharArray();
		}
	}
}