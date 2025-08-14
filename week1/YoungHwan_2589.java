package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class YoungHwan_2589 {

    private static int n, m;
    private static int answer = Integer.MIN_VALUE;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private static char[][] map;
    private static boolean[][] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int r = 0; r < n; r++) {
            String input = br.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = input.charAt(c);
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] == 'W') {
                    continue;
                }
                int result = bfs(new Cell(r, c, 0));
                answer = Math.max(answer, result);
            }
        }

        System.out.println(answer);
    }

    private static int bfs(Cell start) {
        int result = 0;
        Queue<Cell> q = new LinkedList<>();
        used = new boolean[n][m];

        used[start.getRow()][start.getCol()] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Cell now = q.poll();
            int row = now.getRow();
            int col = now.getCol();
            int dist = now.getDist();
            result = dist;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                // OutOfRange
                if (isOutOfMap(nr, nc)) {
                    continue;
                }

                // UnReachable
                if (isUnReachable(nr, nc)) {
                    continue;
                }

                used[nr][nc] = true;
                q.add(new Cell(nr, nc, dist + 1));
            }
        }
        return result;
    }

    private static boolean isOutOfMap(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= n || nc >= m;
    }

    private static boolean isUnReachable(int nr, int nc) {
        return used[nr][nc] || map[nr][nc] == 'W';
    }

    private static class Cell {

        private final int row;
        private final int col;
        private final int dist;

        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public int getDist() {
            return this.dist;
        }
    }
}
