package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 접근: 재귀 (부분 집합)
// 최초 로직: 부분 수열의 개수가 0 인 경우도 처리를 해서, 50% 쯥에서 틀림
// 부분 수열의 개수가 0 보다 클 경우만 경우의 수를 추가하도록 수정
// 총 풀이 시간: 약 20분
public class YoungHwan_1182 {

    private static int N, S, answer;

    private static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int sum, int cnt) {
        if (depth == N) {
            // 문제 조건에 부분집합의 크기가 양수라는 제한을 만족하기 위한 조건
            if (sum == S && cnt > 0) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + nums[depth], cnt + 1);
        dfs(depth + 1, sum, cnt);
    }
}
