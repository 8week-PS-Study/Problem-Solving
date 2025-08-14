package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class YoungHwan_14940 {

    private static int n, m;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        used = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 0) {
                    used[r][c] = true;
                }
            }
        }

        Cell start = new Cell(0, 0);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 2) {
                    map[r][c] = 0;
                    used[r][c] = true;
                    start = new Cell(r, c);
                }
            }
        }

        bfs(start);

        printResult();
    }

    private static void bfs(Cell start) {
        Queue<Cell> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Cell now = q.poll();
            int r = now.getRow();
            int c = now.getCol();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isOutOfMap(nr, nc)) {
                    continue;
                }

                if (used[nr][nc]) {
                    continue;
                }

                // 갈 수 있는 경우 거리 +1. 큐에 추가. 방문 처리
                map[nr][nc] = map[r][c] + 1;
                used[nr][nc] = true;
                q.add(new Cell(nr, nc));
            }
        }
    }

    private static boolean isOutOfMap(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= n || nc >= m;
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (used[r][c]) {
                    sb.append(map[r][c]).append(" ");
                } else {
                    sb.append(-1).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static class Cell {

        private final int row;
        private final int col;

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
