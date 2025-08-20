package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class YoungHwan_1138 {

    private static int N;

    private static int[] counts;
    private static List<Integer> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        counts = new int[N];
        answer = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            answer.add(counts[i], i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int num: answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
