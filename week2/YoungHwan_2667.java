package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 접근: BFS
// map 배열 초기화 시 '0' 안 빼준거 말고는 없었음
// 총 풀이 시간: 약 20분
public class YoungHwan_2667 {

    private static int N;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] used;
    private static List<Integer> counts = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        used = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = input.charAt(c) - '0';
                used[r][c] = map[r][c] == 0;
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (used[r][c]) {
                    continue;
                }
                if (map[r][c] == 1) {
                    Cell cell = new Cell(r, c);
                    used[r][c] = true;
                    bfs(cell, 1);
                }
            }
        }

        Collections.sort(counts);

        StringBuilder sb = new StringBuilder();
        sb.append(counts.size()).append("\n");
        for (int count: counts) {
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Cell start, int count) {
        Queue<Cell> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Cell now = q.poll();

            int row = now.getRow();
            int col = now.getCol();

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (isOutOfRange(nr, nc)) {
                    continue;
                }

                if (used[nr][nc]) {
                    continue;
                }

                used[nr][nc] = true;
                count++;
                q.offer(new Cell(nr, nc));
            }
        }
        counts.add(count);
    }

    private static boolean isOutOfRange(int row, int col) {
        return row < 0 || col < 0 || row >= N || col >= N;
    }

    private static class Cell {

        private int row;
        private int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }
}
